package src;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Usuario {
    protected String nome;
    protected int codigoidentificacao;
    protected ArrayList<Emprestimo> emprestimospassados; //tipo um histórico
    protected ArrayList<Emprestimo> emprestimosatuais; //empréstimos ativos
    protected ArrayList<Reserva> reservas;
    protected ICalculadoraEmprestimo calculadora; //aqui que vai lidar com o tempo de aluguel, prioridade e etc de cada usuário
    protected boolean devedor;
    
    
    public Usuario(String nome, int codigoidentificacao) { //imagino que todo Usuario novo vai começar com os arrays zerados e sem ser um devedor
        this.nome = nome;
        this.codigoidentificacao = codigoidentificacao;

        emprestimospassados = new ArrayList<Emprestimo>();
        emprestimosatuais = new ArrayList<Emprestimo>();
        reservas = new ArrayList<Reserva>();
        devedor = false;
    }

    private void realizarEmprestimo(Exemplar exemplar) {
        int diasEmprestimo = obterDiasEmprestimo();
        Emprestimo emprestimo = new Emprestimo(this, exemplar, LocalDate.now(), LocalDate.now().plusDays(diasEmprestimo));
        exemplar.setEmprestimoatual(emprestimo);
        emprestimosatuais.add(emprestimo);
   }

    public void alugarLivro(Livro livro) {
        Exemplar exemplar = livro.checarExemplares();
        this.verificaDevedor(); //verifica se não está devendo nenhum livro para poder realizar novo empréstimo
        if (exemplar != null && !devedor) {
            if (calculadora.podeEmprestar(this, exemplar)) {
                realizarEmprestimo(exemplar);
                livro.removerReservaPeloUsuario(this);  //função criada para no caso de o empréstimo ser decorrente de uma reserva, a reserva ser removida do array reservas do livro;
                System.out.println("Empréstimo realizado com sucesso!");
            } else {
                System.out.println(calculadora.getmotivoFalhaEmprestimo());
            }
         } else {
            System.out.println("Não foi possível realizar o empréstimo: exemplar indisponível ou usuário devedor.");
         }
   }
   public void fazerReserva(Livro livro){
        if (livro != null){
            Reserva reserva = new Reserva(this, livro);
            livro.adicionarReserva(reserva);
            System.out.println("Reserva efetuada com sucesso!");
        }
        else{
            System.out.println("O livro não foi encontado no sistema.");
        }
   }

   public void fazerDevolucao(Livro livro){
        if (livro != null) {
            for (Emprestimo emprestimo : emprestimosatuais) {
                Exemplar exemplar = emprestimo.getExemplar();
                if (exemplar.getLivro() == livro) {
                    exemplar.setEmprestimoatual(null);
                    emprestimo.setDataderetorno(LocalDate.now());
                    emprestimosatuais.remove(emprestimo);
                    emprestimospassados.add(emprestimo);
                    this.verificaDevedor(); //verifica se ao devolver o livro, ainda resta algum empréstimo pendente ou não
                    System.out.println("Devolução realizada com sucesso!");
                    return;
                }
            }
            System.out.println("O usuário não possui nenhum empréstimo corrente desse livro.");
            return;
        }
        else{
            System.out.println("O livro não foi encontrado no sistema.");

        }
   }

   public void verificaDevedor(){
        if(!emprestimosatuais.isEmpty()) {
            for (Emprestimo emprestimo : emprestimosatuais) {
                if (emprestimo.getDataderetorno().isBefore(LocalDate.now())) {
                    this.setDevedor(true);
                    return;
                }
            }
        }
        this.setDevedor(false);
   }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCodigoidentificacao() {
        return codigoidentificacao;
    }

    public void setCodigoidentificacao(int codigoidentificacao) {
        this.codigoidentificacao = codigoidentificacao;
    }

    public ArrayList<Emprestimo> getEmprestimospassados() {
        return emprestimospassados;
    }

    public void setEmprestimospassados(ArrayList<Emprestimo> emprestimospassados) {
        this.emprestimospassados = emprestimospassados;
    }

    public ArrayList<Emprestimo> getEmprestimosatuais() {
        return emprestimosatuais;
    }

    public void setEmprestimosatuais(ArrayList<Emprestimo> emprestimosatuais) {
        this.emprestimosatuais = emprestimosatuais;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    public boolean getDevedor() {
        return devedor;
    }

    public void setDevedor(boolean valor) {
        this.devedor = valor;
    }

    // Função abstrata que deve ser implementada por cada tipo de usuário:
     protected abstract int obterDiasEmprestimo(); // Não sei se precisar ser protected, mas é uma função que deve ser implementada por cada tipo de usuário (Aluno, Professor, etc) para definir quantos dias o empréstimo pode durar.

}

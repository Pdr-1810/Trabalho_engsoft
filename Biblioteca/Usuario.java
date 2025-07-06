package Biblioteca;

import Verificadores.IVerificadorEmprestimo;

import java.util.ArrayList;
import java.time.LocalDate;

public abstract class Usuario {
    protected String nome;
    protected String codigoidentificacao;
    protected ArrayList<Emprestimo> emprestimospassados; //tipo um histórico
    protected ArrayList<Emprestimo> emprestimosatuais; //empréstimos ativos
    protected ArrayList<Reserva> reservas;
    protected IVerificadorEmprestimo verificador; //aqui que vai lidar com o tempo de aluguel, prioridade e etc de cada usuário
    protected boolean devedor;
    
    
    public Usuario(String nome, String codigoidentificacao) { //imagino que todo biblioteca.Usuario novo vai começar com os arrays zerados e sem ser um devedor
        this.nome = nome;
        this.codigoidentificacao = codigoidentificacao;
        emprestimospassados = new ArrayList<Emprestimo>();
        emprestimosatuais = new ArrayList<Emprestimo>();
        reservas = new ArrayList<Reserva>();
        devedor = false;
    }

    public void removerReservaDeLivro(Livro livro){
       for (Reserva reserva: reservas){
            if (reserva.getLivro() == livro){
                reservas.remove(reserva);
                livro.removerReserva(reserva);
                return;
            }
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

    public String getCodigoidentificacao() {
        return codigoidentificacao;
    }

    public void setCodigoidentificacao(String codigoidentificacao) {
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

    public void adicionarReserva(Reserva reserva) {
        this.reservas.add(reserva);
    }

    public void removerReserva(Reserva reserva) {
        this.reservas.remove(reserva);
    }

    public boolean getDevedor() {
        return devedor;
    }

    public void setDevedor(boolean valor) {
        this.devedor = valor;
    }

    public boolean podeEmprestar(Exemplar exemplar) {
        return this.verificador.podeEmprestar(this, exemplar);
    }


    public String getMotivoFalhaEmprestimo() {
        return this.verificador.getmotivoFalhaEmprestimo();
    }

    // Função abstrata que deve ser implementada por cada tipo de usuário:
    public abstract int obterDiasEmprestimo(); // Não sei se precisar ser protected, mas é uma função que deve ser implementada por cada tipo de usuário (Aluno, biblioteca.Professor, etc) para definir quantos dias o empréstimo pode durar.

    public abstract int obterMaxEmprestimos();

}

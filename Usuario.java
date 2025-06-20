import java.util.ArrayList;

public class Usuario {
    protected String nome;
    protected int codigoidentificacao;
    protected ArrayList<Emprestimo> emprestimospassados; //tipo um histórico
    protected ArrayList<Emprestimo> emprestimosatuais; //empréstimos ativos
    protected ArrayList<Reserva> reservas;
    protected Repositorio repositorio;
    protected ICalculadoraEmprestimo calculadora; //aqui que vai lidar com o tempo de aluguel, prioridade e etc de cada usuário
    protected boolean devedor;
    

    public Usuario(String nome, int codigoidentificacao, Repositorio repositorio, ICalculadoraEmprestimo calculadora) { //imagino que todo Usuario novo vai começar com os arrays zerados e sem ser um devedor
        this.nome = nome;
        this.codigoidentificacao = codigoidentificacao;
        this.repositorio = repositorio;
        this.calculadora = calculadora;

        emprestimospassados = new ArrayList<Emprestimo>();
        emprestimosatuais = new ArrayList<Emprestimo>();
        reservas = new ArrayList<Reserva>();
        devedor = false;
    }

    public void alugarLivro(int codigolivro){
        Livro livro = repositorio.buscarLivro(codigolivro);  //busca no respositorio
        Exemplar exemplar = livro.checarExemplares(); //checa o livro possui exemplares diponíveis
        if (exemplar != null && devedor == false){ //verifica se tem exemplares disponíveis e o usuário não é devedor, o que é padrão para todo tipo de usuário
           calculadora.fazerEmprestimo(this, exemplar);
        }
    }
    
    public void devolverLivro(int codigolivro){
        for (Emprestimo emprestimo : emprestimosatuais){
            if(emprestimo.getExemplar().getLivro().getCodigo() == codigolivro){
                emprestimosatuais.remove(emprestimo);
                emprestimospassados.add(emprestimo);
                System.out.println("Livro devolvido com sucesso");
                return;
            }
        }
        System.out.println("O usuário não possui nenhuma empréstimo desse livro");
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

    public Repositorio getRepositorio() {
        return repositorio;
    }

    public void setRepositorio(Repositorio repositorio) {
        this.repositorio = repositorio;
    }

    //provavelmente adicionaremos funções de adiconar empréstimo e etc...
}

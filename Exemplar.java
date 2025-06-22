import java.util.ArrayList;

public class Exemplar {
    private Livro livro;
    private Emprestimo emprestimoatual;
    private ArrayList<Emprestimo> emprestimospassados;
    
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
    public Emprestimo getEmprestimoatual() {
        return emprestimoatual;
    }
    public void setEmprestimoatual(Emprestimo emprestimoatual) {
        this.emprestimoatual = emprestimoatual;
    }
    public ArrayList<Emprestimo> getEmprestimospassados() {
        return emprestimospassados;
    }
    public void setEmprestimospassados(ArrayList<Emprestimo> emprestimospassados) {
        this.emprestimospassados = emprestimospassados;
    }

    public List<Reserva> obterReservasLivro() {
    return this.livro.getReservas(); // Retorna a lista de reservas do livro associado a este exemplar
    }
    public List<Exemplar> obterExemplaresLivro() {
        return this.livro.getExemplares(); // Retorna a lista de exemplares do livro associado a este exemplar
    }

    //não entendi direito o modelo conceitual, talvez tenha uma lista de emprestimos passados e uma referencia pro emprestimo atual
}

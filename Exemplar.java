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

    //não entendi direito o modelo conceitual, talvez tenha uma lista de emprestimos passados e uma referencia pro emprestimo atual
}

package src;
import java.util.ArrayList;

public class Exemplar {
    private Livro livro;
    private Emprestimo emprestimoatual;
    
    public Exemplar(Livro livro) {
        this.livro = livro;
        this.emprestimoatual = null; // Inicialmente, não há empréstimo atual
    }


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
    


    
    public ArrayList<Reserva> obterReservasLivro() {
    return this.livro.getReservas(); // Retorna a lista de reservas do livro associado a este exemplar
    }
    public ArrayList<Exemplar> obterExemplaresLivro() {
        return this.livro.getExemplares(); // Retorna a lista de exemplares do livro associado a este exemplar
    }
    public int getExemplaresDisponiveis(){
        return this.livro.checarQuantidadeExemplaresDisponiveis(); // Retorna a quantidade de exemplares disponíveis do livro associado a este exemplar
    }

    public String getTituloDoLivro() {
        return livro.getTitulo();
    }

    //não entendi direito o modelo conceitual, talvez tenha uma lista de emprestimos passados e uma referencia pro emprestimo atual
}

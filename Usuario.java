import java.util.ArrayList;

public class Usuario {
    private String nome;
    private int codigoidentificacao;
    private ArrayList<Emprestimo> emprestimospassados; //tipo um histórico
    private ArrayList<Emprestimo> emprestimosatuais; //empréstimos ativos
    private ArrayList<Reserva> reservas;
}

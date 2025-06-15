import java.util.ArrayList;

public class AlunoGraduacao extends Usuario{

    public AlunoGraduacao(String nome, int codigoidentificacao, Repositorio repositorio,ICalculadoraEmprestimo calculadora) {
        super(nome, codigoidentificacao, repositorio, calculadora);
        
        emprestimospassados = new ArrayList<Emprestimo>();
        emprestimosatuais = new ArrayList<Emprestimo>();
        reservas = new ArrayList<Reserva>();
        devedor = false;
    }

}
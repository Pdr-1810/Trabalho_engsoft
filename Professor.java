import java.util.ArrayList;

public class Professor extends Usuario{

    
    public Professor(String nome, int codigoidentificacao, Repositorio repositorio, ICalculadoraEmprestimo calculadora) {
        super(nome, codigoidentificacao, repositorio, calculadora);
        
        emprestimospassados = new ArrayList<Emprestimo>();
        emprestimosatuais = new ArrayList<Emprestimo>();
        reservas = new ArrayList<Reserva>();
        devedor = false;
    }
    @Override
    protected int obterDiasEmprestimo(){
        return 8;
    }
}

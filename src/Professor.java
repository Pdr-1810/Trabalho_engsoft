import java.util.ArrayList;

public class Professor extends Usuario{

    
    public Professor(String nome, int codigoidentificacao, Repositorio repositorio) {
        super(nome, codigoidentificacao, repositorio);
        
        calculadora = new CalculadoraEmprestimoProfessor();
        devedor = false;
    }
    protected int obterDiasEmprestimo(){
        return 8;
    }
}

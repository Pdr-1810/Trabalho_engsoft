import java.util.ArrayList;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String nome, int codigoidentificacao) {
        super(nome, codigoidentificacao);
        
    
        calculadora = new CalculadoraEmprestimoPosGraduacao();
        devedor = false;
    }
    protected int obterDiasEmprestimo(){
        return 5;
    }
    
}

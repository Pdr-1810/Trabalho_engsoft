import java.util.ArrayList;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String nome, int codigoidentificacao, Repositorio repositorio) {
        super(nome, codigoidentificacao, repositorio);
        
    
        calculadora = new CalculadoraEmprestimoAlunoPosGraduacao();
        devedor = false;
    }
    protected int obterDiasEmprestimo(){
        return 5;
    }
    
}

import java.util.ArrayList;

public class AlunoGraduacao extends Usuario{

    public AlunoGraduacao(String nome, int codigoidentificacao) {
        super(nome, codigoidentificacao);
        
        
        calculadora = new CalculadoraEmprestimoGraduacao();
        devedor = false;
    }
 
    protected int obterDiasEmprestimo(){
        return 4;
    }
}
import java.util.ArrayList;

public class AlunoGraduacao extends Usuario{

    public AlunoGraduacao(String nome, int codigoidentificacao, Repositorio repositorio) {
        super(nome, codigoidentificacao, repositorio);
        
        
        calculadora = new CalculadoraEmprestimoAlunoGraduacao();
        devedor = false;
    }
 
    protected int obterDiasEmprestimo(){
        return 4;
    }
}
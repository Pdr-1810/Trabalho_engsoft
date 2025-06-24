import java.util.ArrayList;

public class Professor extends Usuario implements IObservadorLivro{
    private int notificacoes;

    
    public Professor(String nome, int codigoidentificacao) {
        super(nome, codigoidentificacao);
        
        calculadora = new CalculadoraEmprestimoProfessor();
        devedor = false;
        notificacoes = 0;
    }
    protected int obterDiasEmprestimo(){
        return 8;
    }

    @Override
    public void atualizar(int valor){
        notificacoes += valor;
    }

    @Override
    public int obterNotificacoes(){
        return notificacoes;
    }

    @Override
    public void registrarObservadorDeLivro(Livro livro){
        livro.registrarObservador(this);
    }
}

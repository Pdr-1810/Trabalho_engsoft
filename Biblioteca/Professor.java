package Biblioteca;

import Verificadores.VerificadorEmprestimoProfessor;


public class Professor extends Usuario implements IObservadorLivro {
    private int notificacoes;

    
    public Professor(String nome, String codigoidentificacao) {
        super(nome, codigoidentificacao);
        this.verificador = new VerificadorEmprestimoProfessor();
        this.devedor = false;
        this.notificacoes = 0;
    }

    public int obterDiasEmprestimo(){
        return 8;
    }
    public int obterMaxEmprestimos(){
        return Integer.MAX_VALUE;
    }

    @Override
    public void atualizar(){
        notificacoes += 1;
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

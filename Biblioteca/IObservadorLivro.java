package Biblioteca;

public interface IObservadorLivro {

    public void atualizar();

    public int obterNotificacoes();

    public void registrarObservadorDeLivro(Livro livro);
}

package  src;

public interface IObservadorLivro {

    public void atualizar(int valor);

    public int obterNotificacoes(); //como novos tipos de usuarios podem ser cadastrados como observadores, achei válido colocar isso aqui

    public void registrarObservadorDeLivro(Livro livro); //no caso a função de registrar observador na hash vai retornar essa interface
}

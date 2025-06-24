public interface IObjetoObservado {

    public void registrarObservador(IObservadorLivro observador);

    public void removerObservador(IObservadorLivro observador);

    public void notificarObservadores(int n);
}

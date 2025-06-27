package Comandos;
import Biblioteca.*;

public class RegistrarObservador implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = new Repositorio();
        IObservadorLivro observador = repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        Livro livro = repositorio.buscarLivro(carregadorParametros.getParametroDois());
        observador.RegistrarObservadorDeLivro(livro);

    }

}

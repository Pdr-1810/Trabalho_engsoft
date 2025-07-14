package Comandos;
import Biblioteca.*;

public class RegistrarObservador implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = Repositorio.getInstancia();

        IObservadorLivro observador = (IObservadorLivro)repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        Livro livro = repositorio.buscarLivro(carregadorParametros.getParametroDois());
        observador.registrarObservadorDeLivro(livro);
        System.out.println("Usuário registrado como observador!");

    }

}

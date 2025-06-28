package Comandos;
import Biblioteca.*;

public class DevolverExemplar implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = Repositorio.getInstancia();
        Usuario usuario = repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        Livro livro = repositorio.buscarLivro(carregadorParametros.getParametroDois());
        usuario.fazerDevolucao(livro);
    }

}

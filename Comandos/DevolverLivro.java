package Comandos;
import Biblioteca.*;

public class DevolverLivro implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = new Repositorio();
        Usuario usuario = repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        Livro livro = repositorio.buscarLivro(carregadorParametros.getParametroDois());
        usuario.devolverLivro(livro);
    }

}

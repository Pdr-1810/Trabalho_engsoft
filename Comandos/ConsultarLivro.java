package Comandos;
import Biblioteca.*;

public class ConsultarLivro implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = new Repositorio();
        Livro livro =  repositorio.buscarLivro(carregadorParametros.getParametroUm());
        ConsultaLivro.consulta(livro);
    }

}

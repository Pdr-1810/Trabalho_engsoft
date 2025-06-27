package Comandos;
import Biblioteca.*;

public class ConsultarNotificacoes implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = new Repositorio();
        IObservadorLivro observador = repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        observador.obterNotificacoes();
    }

}

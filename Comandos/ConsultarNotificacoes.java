package Comandos;
import Biblioteca.*;
import Consultas.*;

public class ConsultarNotificacoes implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = Repositorio.getInstancia();

        IObservadorLivro observador = (IObservadorLivro) repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        ConsultaNotificacoes.consulta(observador);
    }

}

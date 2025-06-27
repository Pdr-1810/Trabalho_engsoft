package Comandos;
import Biblioteca.*;
import Consultas.*;

public class ConsultarNotificacoes implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = new Repositorio();
        IObservadorLivro observador = repositorio.buscarObservador(carregadorParametros.getParametroUm());
        ConsultaNotificacoes.consulta(observador);
    }

}

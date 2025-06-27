package Comandos;
import Biblioteca.*;
import Consultas.*;

public class ConsultarUsuario implements Comando{

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = new Repositorio();
        Usuario usuario = repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        ConsultaUsuarioGenerico.consulta(usuario);
    }

}

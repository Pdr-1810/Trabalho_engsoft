package Comandos;
import Biblioteca.*;

public class FazerReserva implements Comando{

    public void fazerReserva(Livro livro,Usuario usuario){
        if (livro != null){
            Reserva reserva = new Reserva(usuario, livro);
            livro.adicionarReserva(reserva);
            usuario.adicionarReserva(reserva);
            System.out.println("Reserva efetuada com sucesso!");
        }
    }

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        Livro livro = repositorio.buscarLivro(carregadorParametros.getParametroDois());

        fazerReserva(livro,usuario);
    }

}

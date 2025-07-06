package Comandos;
import Biblioteca.*;

import java.time.LocalDate;

public class FazerEmprestimo implements Comando{

    private void realizarEmprestimo(Exemplar exemplar, Usuario usuario) {
        int diasEmprestimo = usuario.obterDiasEmprestimo();
        Emprestimo emprestimo = new Emprestimo(usuario, exemplar, LocalDate.now(), LocalDate.now().plusDays(diasEmprestimo));
        exemplar.setEmprestimoatual(emprestimo);
        usuario.getEmprestimosatuais().add(emprestimo);
    }
    //Usuario pode alugar um livro. Eu não posso trazer uma relação  direta entre o usuario e o livro. Reserva é uma classe que possui relação entre o usuario e o livro ->

    private void RemoverReserva(Usuario usuario,Livro livro) {
        Reserva reservaParaRemover = null;
        for (Reserva reserva : usuario.getReservas()) {
            if (reserva.getLivro().equals(livro)) {
                reservaParaRemover = reserva;
                break;
            }
        }
        if (reservaParaRemover != null) {
            livro.removerReserva(reservaParaRemover);
            usuario.removerReserva(reservaParaRemover);
        }

    }

    public void alugarLivro(Livro livro,Usuario usuario) {
        usuario.verificaDevedor();
        Exemplar exemplar = livro.checarExemplares();
        if (exemplar != null) {
            if (usuario.podeEmprestar(exemplar)) {
                realizarEmprestimo(exemplar,usuario);
                RemoverReserva(usuario, livro);  // Remove reserva se o empréstimo for decorrente de uma reserva
                System.out.println("Empréstimo realizado com sucesso!");
            } else {
                System.out.println(usuario.getMotivoFalhaEmprestimo());
            }
        } else {
            System.out.println("Não foi possível realizar o empréstimo: exemplar indisponível ou usuário devedor.");
        }
    }

    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = Repositorio.getInstancia();

        Usuario usuario = repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        Livro livro = repositorio.buscarLivro(carregadorParametros.getParametroDois());
        alugarLivro(livro,usuario);
    }

}

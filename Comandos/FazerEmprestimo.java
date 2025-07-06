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

    public void alugarLivro(Livro livro,Usuario usuario) {
        usuario.verificaDevedor();
        Exemplar exemplar = livro.checarExemplares();
        if (exemplar != null) {
            if (usuario.podeEmprestar(exemplar)) {
                realizarEmprestimo(exemplar,usuario);
                usuario.removerReservaDeLivro(livro);
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

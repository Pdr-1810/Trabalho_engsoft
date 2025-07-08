package Comandos;
import Biblioteca.*;

import java.util.ArrayList;

public class DevolverExemplar implements Comando{


    public void fazerDevolucao(Livro livro, Usuario usuario) {
        if (livro == null) {
            System.out.println("O livro não foi encontrado no sistema.");
            return;
        }
        ArrayList<Emprestimo> emprestimosAtuais = usuario.getEmprestimosatuais();
        for (Emprestimo emprestimo : emprestimosAtuais) {
            Exemplar exemplar = emprestimo.getExemplar();
            if (exemplar.getLivro().equals(livro)) {
                exemplar.devolver();
                emprestimo.devolver();
                usuario.devolver(emprestimo);
                System.out.println("Devolução realizada com sucesso!");
                return;
            }
        }
        System.out.println("Nenhum exemplar deste livro está emprestado para este usuário.");
    }


    public void executar(CarregadorParametros carregadorParametros){
        Repositorio repositorio = Repositorio.getInstancia();
        Usuario usuario = repositorio.buscarUsuario(carregadorParametros.getParametroUm());
        Livro livro = repositorio.buscarLivro(carregadorParametros.getParametroDois());
        fazerDevolucao(livro,usuario);
    }

}

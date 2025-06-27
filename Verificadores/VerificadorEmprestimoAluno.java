package Verificadores;

import Biblioteca.*;

import java.util.ArrayList;



public class VerificadorEmprestimoAluno implements IVerificadorEmprestimo {

    private String motivoFalha = "";
    @Override
    public boolean podeEmprestar(Usuario usuario, Exemplar exemplar){

        if(usuario.getEmprestimosatuais().size() < usuario.obterMaxEmprestimos()){  //verifica se o aluno de pos-graducaao ja não está no limite de livro emprestados

            ArrayList<Reserva> reservas = exemplar.obterReservasLivro();  //pega a lista de reservas do livro
            ArrayList<Exemplar> exemplares = exemplar.obterExemplaresLivro();  //pega a lista de exemplares do livro

            for(Emprestimo emprestimo: usuario.getEmprestimosatuais()){ //percorre a lista de emprestimos atuais do usuario, se ja tiver um emprestimo do exemplar a função termina

                if(emprestimo.getLivro() == exemplar.getLivro()){
                    motivoFalha = "Aluno já possui empréstimo de um exemplar desse livro";
                    return false;
                }
            }

            if(reservas.size() < exemplares.size()){ //se tiver menos reservas do que exemplares disponíveis, o empréstimo é feito normalmente e a função termina
                motivoFalha = "";
                return true;
            }

            else{
                for(Reserva reserva : reservas){ //se tiver mais reservas do que exemplares disponíveis, checamos se alguma das reservas é do usuário
                    if (reserva.getUsuario() == usuario){  //caso o usuário tenha alguma reserva, o empréstimo é feito normalmente e a função termina
                        motivoFalha = "";
                        return true;
                    }
                }
                motivoFalha = "Esse exemplar já estava reservado"; //caso o usuário nã tenha nenhuma reserva, o empréstimo não é feito
                return false;   
            }
        }
        else{      //se o aluno tiver mais do que 3, não é realizado o empréstimo
            motivoFalha = "Aluno já possui o máximo de empréstimos permitidos";
            return false;
        }

    }
    @Override
    public String getmotivoFalhaEmprestimo() {
        return motivoFalha;
    }
    
}

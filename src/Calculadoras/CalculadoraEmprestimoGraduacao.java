package src.Calculadoras;

import src.Exemplar;
import src.Emprestimo;
import src.Usuario;
import src.Reserva;
import src.ICalculadoraEmprestimo;
import java.util.ArrayList;

public class CalculadoraEmprestimoGraduacao implements ICalculadoraEmprestimo {

    private String motivoFalha = "";
    
    @Override
    public boolean podeEmprestar(Usuario usuario, Exemplar exemplar){

        if(usuario.getEmprestimosatuais().size() < 2){  //verifica se o aluno de graducaao ja não está no limite de livro emprestados

            ArrayList<Reserva> reservas = exemplar.obterReservasLivro();  //pega a lista de reservas do livro

            for(Emprestimo emprestimo: usuario.getEmprestimosatuais()){ //percorre a lista de emprestimos atuais do usuario, se ja tiver um emprestimo do exemplar a função termina
                if(emprestimo.getLivro() == exemplar.getLivro()){
                    motivoFalha = "Aluno já possui empréstimo de um exemplar desse livro";
                    return false;
                }
            }

            if(reservas.size() < exemplar.getExemplaresDisponiveis()){ //se tiver menos reservas do que exemplares disponíveis, o empréstimo é feito normalmente e a função termina
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
        else{      //se o aluno tiver mais do que 2, não é realizado o empréstimo
            motivoFalha = "Aluno já possui o máximo de empréstimos permitidos";
            return false;
        }
    }

    @Override
    public String getmotivoFalhaEmprestimo() {
        return motivoFalha;
    }
    
}

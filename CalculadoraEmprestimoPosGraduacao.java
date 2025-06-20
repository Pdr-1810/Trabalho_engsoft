import java.time.LocalDate;
import java.util.ArrayList;

public class CalculadoraEmprestimoPosGraduacao implements ICalculadoraEmprestimo{
        
    //isso é apenas um esboço da operação de empréstimo, estou violando todos os padrões grasp
    //esses armengues de get's serão transformados em funções específicas posteriormente, ex: exemplar.getLivro().getReservas() = exemplar.obterReservasLivro
    //também não estou muito certo se a lógica está 100%, nem mesmo se fiz corretamente essas calculadoras, mas pelo menos já deu uma base para aprimorar depois

    public void fazerEmprestimo(Usuario usuario, Exemplar exemplar){

        if(usuario.emprestimosatuais.size() < 3){  //verifica se o aluno de pos-graducaao ja não está no limite de livro emprestados

            ArrayList<Reserva> reservas = exemplar.getLivro().getReservas();  //pega a lista de reservas do livro
            ArrayList<Exemplar> exemplares = exemplar.getLivro().getExemplares();  //pega a lista de exemplares do livro

            for(Emprestimo emprestimo: usuario.getEmprestimosatuais()){ //percorre a lista de emprestimos atuais do usuario, se ja tiver um emprestimo do exemplar a função termina

                if(emprestimo.getExemplar().getLivro() == exemplar.getLivro()){
                    System.out.println("Aluno já possui empréstimo de um exemplar desse livro");
                    return;
                }
            }
            LocalDate diadoemprestimo = LocalDate.now();
            if(reservas.size() < exemplares.size()){ //se tiver menos reservas do que exemplares disponíveis, o empréstimo é feito normalmente e a função termina
                Emprestimo emprestimo = new Emprestimo(usuario, exemplar, diadoemprestimo, diadoemprestimo.plusDays(5)); //coloca o dia do emprestimo como o hoje e a data de retorno como hoje +5;
                exemplar.setEmprestimoatual(emprestimo);
                usuario.emprestimosatuais.add(emprestimo);
                System.out.println("Emprestimo realizado com sucesso");
                return;

            }

            else{
                for(Reserva reserva : reservas){ //se tiver mais reservas do que exemplares disponíveis, checamos se alguma das reservas é do usuário

                    if (reserva.getUsuario() == usuario){  //caso o usuário tenha alguma reserva, o empréstimo é feito normalmente e a função termina
                        Emprestimo emprestimo = new Emprestimo(usuario, exemplar, diadoemprestimo, diadoemprestimo.plusDays(5)); //coloca o dia do emprestimo como o hoje e a data de retorno como hoje +5;
                        exemplar.setEmprestimoatual(emprestimo);
                        usuario.emprestimosatuais.add(emprestimo);
                        System.out.println("Emprestimo realizado com sucesso");
                        return;
                    }
                }
                System.out.println("Esse exemplar já estava reservado"); //caso o usuário nã tenha nenhuma reserva, o empréstimo não é feito
            }
        }

        else{      //se o aluno tiver mais do que 3, não é realizado o empréstimo
            System.out.println("Aluno já possui o máximo de empréstimos permitidos");
        }
    }
}

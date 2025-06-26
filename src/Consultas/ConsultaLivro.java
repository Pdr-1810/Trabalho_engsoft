package src.Consultas;

import src.Emprestimo;
import src.Usuario;
import src.Reserva;
import src.IConsulta;
import src.Exemplar;
import src.Livro;
import java.time.format.DateTimeFormatter;

public class ConsultaLivro implements IConsulta<Livro> {
    public  void consulta(Livro livro){
       if(livro == null){
              System.out.println("Livro não encontrado.");
              return;
         } else {
              // Titulo:
              System.out.println("Livro encontrado: " + livro.getTitulo());

              // Reservas:
                if (livro.getReservas().isEmpty()) {
                    System.out.println("Não há reservas para este livro.");
                } else {
                    System.out.println("Reservas: \n");
                    System.out.println("Quantidade de reservas: " + livro.getReservas().size());
                    for (Reserva reserva : livro.getReservas()) {
                        System.out.println("Usuário: " + reserva.getNomeDoUsuario());
                    }
                }
                // Exemplares:
                System.out.println("Exemplares: \n");
                if (livro.getExemplares().isEmpty()) {
                    System.out.println("Não há exemplares para este livro.");
                } else {
                    System.out.println("Quantidade de exemplares: " + livro.getExemplares().size());
                    for(Exemplar exemplar:livro.getExemplares()){
                        Emprestimo emprestimo = exemplar.getEmprestimoatual();
                        if (emprestimo != null) {
                            System.out.print(" | Status: Emprestado");
                            System.out.print(" | Usuário: " + emprestimo.getNomeDoUsuario());
                            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                            System.out.print(" | Data de empréstimo: " + emprestimo.getDatadeemprestimo().format(formatter));
                            System.out.println(" | Data prevista para devolução: " + emprestimo.getDataderetorno().format(formatter));
                        } else {
                            System.out.println("| Status: Exemplar disponível.");
                        }
                    }
                }
       }
    }
}

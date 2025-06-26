package Consultas;


import biblioteca.Emprestimo;
import biblioteca.Usuario;
import biblioteca.IConsulta;
import biblioteca.Reserva;

import java.time.format.DateTimeFormatter;

public class ConsultaUsuarioGenerico{
    @Override
    public static void consulta(biblioteca.Usuario usuario){
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Emprestimos:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Emprestimos passados: ");
        for(Emprestimo emp: usuario.getEmprestimospassados()){
            String status = " "; //Temos que definir o processo de devolução primeiro
            String dataDevolucao = emp.getDataderetorno().format(formatter);
            System.out.println("biblioteca.Livro: " + emp.getTituloDoLivro() +
                    " | Data do empréstimo: " + emp.getDatadeemprestimo().format(formatter) +
                    " | Status: " + status +
                    " | Data de devolução: " + dataDevolucao);
        }

        System.out.println("Emprestimos atuais: ");
        for(Emprestimo emp: usuario.getEmprestimosatuais()){
            String status = " "; //Temos que definir o processo de devolução primeiro
            String dataDevolucao = emp.getDataderetorno().format(formatter);
            System.out.println("biblioteca.Livro: " + emp.getTituloDoLivro() +
                    " | Data do empréstimo: " + emp.getDatadeemprestimo().format(formatter) +
                    " | Status: " + status +
                    " | Data de devolução: " + dataDevolucao);

        }
        System.out.println("Reservas: ");
        for(Reserva reserva:usuario.getReservas()){
            System.out.println("biblioteca.Livro: " + reserva.getTituloDoLivro() +
                    " | Data da reserva: " + reserva.getDatadareserva().format(formatter));// Criar o processo de Reservar primeiro
        }

    }
}

package Consultas;

import Biblioteca.Emprestimo;
import Biblioteca.Reserva;
import Biblioteca.Usuario;
import Biblioteca.Livro;

import java.time.format.DateTimeFormatter;

public class ConsultaUsuarioGenerico{
    public static void consulta(Usuario usuario){
        if(usuario == null){
            System.out.println("Usuário não encontrado.");
            return;
        }
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Emprestimos:");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("Emprestimos passados: ");
        for(Emprestimo emp: usuario.getEmprestimospassados()){
            String status = emp.obterStatusPorExtenso(); //Temos que definir o processo de devolução primeiro
            String dataDevolucao = emp.getDataderetorno().format(formatter);
            System.out.println("Livro: " + emp.getTituloDoLivro() +
                    " | Data do empréstimo: " + emp.getDatadeemprestimo().format(formatter) +
                    " | Status: " + status +
                    " | Data de devolução: " + dataDevolucao);
        }

        System.out.println("Emprestimos atuais: ");
        for(Emprestimo emp: usuario.getEmprestimosatuais()){
            String status = emp.obterStatusPorExtenso(); //Temos que definir o processo de devolução primeiro
            String dataDevolucao = emp.getDataderetorno().format(formatter);
            System.out.println("Livro: " + emp.getTituloDoLivro() +
                    " | Data do empréstimo: " + emp.getDatadeemprestimo().format(formatter) +
                    " | Status: " + status +
                    " | Data de devolução: " + dataDevolucao);

        }
        System.out.println("Reservas: ");
        for(Reserva reserva:usuario.getReservas()){
            System.out.println("Livro: " + reserva.getTituloDoLivro() +
                    " | Data da reserva: " + reserva.getDatadareserva().format(formatter));// Criar o processo de Reservar primeiro
        }

    }
}

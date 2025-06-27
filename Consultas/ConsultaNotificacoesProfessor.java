package Consultas;

import Biblioteca.Professor;

public class ConsultaNotificacoesProfessor{ //aqui a gente implementa o biblioteca.IConsulta
    public static void consulta(Professor professor) {
        System.out.println("O número total de notificações recebidas por " + professor.getNome() +
                " é de: " + professor.obterNotificacoes());
    }
}

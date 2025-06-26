package Consultas;

import biblioteca.Professor;
import biblioteca.IConsulta;

public class ConsultaNotificacoesProfessor implements IConsulta<Professor> { //aqui a gente implementa o biblioteca.IConsulta
    @Override
    public void consulta(Professor professor) {
        System.out.println("O número total de notificações recebidas por " + professor.getNome() +
                " é de: " + professor.obterNotificacoes());
    }
}

package src.Consultas;

import src.IConsulta;
import src.IObservadorLivro;
import src.Professor;


public class ConsultaNotificacoesProfessor implements IConsulta<Professor> { //aqui a gente implementa o IConsulta
    @Override
    public void consulta(Professor professor) {
        System.out.println("O número total de notificações recebidas por " + professor.getNome() +
                " é de: " + professor.obterNotificacoes());
    }
}

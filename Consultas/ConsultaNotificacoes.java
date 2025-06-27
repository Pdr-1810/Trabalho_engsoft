package Consultas;

import Biblioteca.IObservadorLivro;
import Biblioteca.Professor;

public class ConsultaNotificacoes { //aqui a gente implementa o biblioteca.IConsulta
    public static void consulta(IObservadorLivro observadorLivro) {
        System.out.println("O número total de notificações recebidas pelo usuario é de: " + observadorLivro.obterNotificacoes());
    }
}

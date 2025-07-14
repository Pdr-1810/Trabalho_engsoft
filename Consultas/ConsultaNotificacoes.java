package Consultas;

import Biblioteca.IObservadorLivro;

public class ConsultaNotificacoes {
    public static void consulta(IObservadorLivro observadorLivro) {
        System.out.println("O número total de notificações recebidas pelo usuario é de: " + observadorLivro.obterNotificacoes());
    }
}

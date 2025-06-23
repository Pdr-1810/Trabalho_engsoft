public class ConsultaNotificacoes { //aqui a gente implementa o IConsulta

    public static void consulta(IObservadorLivro usuario){ //pode mudar se tiver uma ideia melhor, vai ter que adicionar os pacotes mesmo
        System.out.println("O número total de notificações recebidas pelo usuário é de: " + usuario.obterNotificacoes()); //recebe observadores no geral, podemos usar para novos tipos de observadorse
    }
}

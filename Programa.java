import Biblioteca.*;
import Comandos.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
public class Programa {
    public static void main(String[] args) {
        //aqui é onde faremos as manipulações
        Repositorio repositorio = Repositorio.getInstancia();
        //Adicionando usuários ao repositório
        Usuario usuarioGraduacao = new AlunoGraduacao("João da Silva", "123");
        Usuario usuarioPosGraduacao = new AlunoPosGraduacao("Maria Oliveira", "456");
        Usuario usuarioGraduacao2 = new AlunoGraduacao("Ana Paula", "789");
        Usuario usuarioProfessor = new Professor("Carlos Lucena", "100");

        repositorio.adicionarUsuario(usuarioGraduacao);
        repositorio.adicionarUsuario(usuarioPosGraduacao);
        repositorio.adicionarUsuario(usuarioGraduacao2);
        repositorio.adicionarUsuario(usuarioProfessor);

        //Adicionando livros ao repositório
        Livro livro1 = new Livro("100", "Engenharia de Software", "Addison Wesley", new ArrayList<>(Arrays.asList("Ian Sommervile")), "6ª", 2000);
        Livro livro2 = new Livro("101", "UML - Guia do Usuário", "Campus", new ArrayList<>(Arrays.asList("Grady Booch", "James Rumbaugh", "Ivar Jacobson")), "7ª", 2000);
        Livro livro3 = new Livro("200", "Code Complete", "Microsoft Press", new ArrayList<>(Arrays.asList("Steve McConnell")), "2ª", 2014);
        Livro livro4 = new Livro("201", "Agile Software Development, Principles, Patterns and Practices", "Prentice Hall", new ArrayList<>(Arrays.asList("Robert Martin")), "1ª", 2002);
        Livro livro5 = new Livro("300", "Refactoring: Improving the Design of Existing Code", "Addison Wesley Professional", new ArrayList<>(Arrays.asList("Martin Fowler")), "1ª", 1999);
        Livro livro6 = new Livro("301", "Software Metrics: A rigorous and Practical Approach", "CRC Press", new ArrayList<>(Arrays.asList("Norman Fenton", "James Bieman")), "3ª", 2014);
        Livro livro7 = new Livro("400", "Design Patterns: Element of Reusable Object-Oriented Software", "Addison Wesley Professional", new ArrayList<>(Arrays.asList("Erich Gamma", "Richard Helm", "Ralph Johnson", "John Vlissides")), "1ª", 1994);
        Livro livro8 = new Livro("401", "UML Distilled: A Brief Guide to the Standard Object Modeling Language", "Addison Wesley Professional", new ArrayList<>(Arrays.asList("Martin Fowler")), "3ª", 2003);

        // Adicionando livros ao repositório
        repositorio.adicionarLivro(livro1);
        repositorio.adicionarLivro(livro2);
        repositorio.adicionarLivro(livro3);
        repositorio.adicionarLivro(livro4);
        repositorio.adicionarLivro(livro5);
        repositorio.adicionarLivro(livro6);
        repositorio.adicionarLivro(livro7);
        repositorio.adicionarLivro(livro8);

        // Adicionando exemplares aos livros
        // Exemplo de criação dos exemplares a partir do código do livro
        Exemplar exemplar1 = new Exemplar(repositorio.buscarLivro("100"), "01", true);
        Exemplar exemplar2 = new Exemplar(repositorio.buscarLivro("100"), "02", true);
        Exemplar exemplar3 = new Exemplar(repositorio.buscarLivro("101"), "03", true);
        Exemplar exemplar4 = new Exemplar(repositorio.buscarLivro("200"), "04", true);
        Exemplar exemplar5 = new Exemplar(repositorio.buscarLivro("201"), "05", true);
        Exemplar exemplar6 = new Exemplar(repositorio.buscarLivro("300"), "06", true);
        Exemplar exemplar7 = new Exemplar(repositorio.buscarLivro("300"), "07", true);
        Exemplar exemplar8 = new Exemplar(repositorio.buscarLivro("400"), "08", true);
        Exemplar exemplar9 = new Exemplar(repositorio.buscarLivro("400"), "09", true);


        // Adicionando exemplares aos livros
        livro1.adicionarExemplar(exemplar1);
        livro1.adicionarExemplar(exemplar2);
        livro2.adicionarExemplar(exemplar3);
        livro3.adicionarExemplar(exemplar4);
        livro4.adicionarExemplar(exemplar5);
        livro5.adicionarExemplar(exemplar6);
        livro5.adicionarExemplar(exemplar7);
        livro6.adicionarExemplar(exemplar8);
        livro6.adicionarExemplar(exemplar9);

        // Adicionar Comandos:
        Comando consultarLivro = new ConsultarLivro();
        Comando consultarUsuario = new ConsultarUsuario();




        Scanner input = new Scanner(System.in);

        Map<String, Comando> comandos = new HashMap<>();
        comandos.put("emp", new FazerEmprestimo());
        comandos.put("dev", new DevolverExemplar());
        comandos.put("res", new FazerReserva());
        comandos.put("obs", new RegistrarObservador());
        comandos.put("liv", new ConsultarLivro());
        comandos.put("usu", new ConsultarUsuario());
        comandos.put("ntf", new ConsultarNotificacoes());

        // 1. Usuário faz dois empréstimos, tenta um terceiro (deve falhar para graduação)
        CarregadorParametros p1 = new CarregadorParametros("123", "100");
        comandos.get("emp").executar(p1); // Sucesso
        CarregadorParametros p2 = new CarregadorParametros("123", "101");
        comandos.get("emp").executar(p2); // Sucesso
        CarregadorParametros p3 = new CarregadorParametros("123", "200");
        comandos.get("emp").executar(p3); // Deve falhar (limite)

// 2. Reserva e empréstimo com reservas pendentes
        CarregadorParametros p4 = new CarregadorParametros("789", "100");
        comandos.get("res").executar(p4); // Reserva feita
        comandos.get("emp").executar(p4); // Deve cancelar reserva e emprestar

// 3. Professor pega vários livros, mesmo com reservas
        CarregadorParametros p5 = new CarregadorParametros("100", "300");
        comandos.get("emp").executar(p5); // Sucesso
        CarregadorParametros p6 = new CarregadorParametros("100", "301");
        comandos.get("emp").executar(p6); // Sucesso

// 4. Devolução e novo empréstimo
        comandos.get("dev").executar(p1); // Devolve livro 100
        comandos.get("emp").executar(p3); // Agora deve conseguir

// 5. Notificações para observador
        CarregadorParametros p7 = new CarregadorParametros("100", "101");
        comandos.get("obs").executar(p7); // Professor observa livro 101
        comandos.get("res").executar(new CarregadorParametros("123", "101"));
        comandos.get("res").executar(new CarregadorParametros("456", "101"));
        comandos.get("res").executar(new CarregadorParametros("789", "101")); // Deve notificar

// 6. Consulta de notificações
        comandos.get("ntf").executar(new CarregadorParametros("100"));
        //Menu de seleção
        while (true){
            System.out.println("Insira um comando");
            String entrada = input.nextLine();
            String[] partes = entrada.trim().split("\\s+");
            ArrayList<String> parametros = new ArrayList<>(Arrays.asList(partes));

            Comando comando = comandos.get(parametros.get(0));
            if (parametros.get(0).equals("sai")){
                break;
            }
            else{

                if (parametros.size() == 2){
                    CarregadorParametros carregador = new CarregadorParametros(parametros.get(1));
                    comando.executar(carregador); 
                }
                else if(parametros.size() == 3){
                    CarregadorParametros carregador = new CarregadorParametros(parametros.get(1), parametros.get(2));
                    comando.executar(carregador);
                }
                else{
                    System.out.println("Erro: Insira um comando de tamanho válido.");
                }
            }

        }

        input.close();

    }
}

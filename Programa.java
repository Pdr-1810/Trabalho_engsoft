import Biblioteca.*;
import Comandos.*;

import java.util.ArrayList;
import java.util.Arrays;

public class Programa {
    public static void main(String[] args) {
        //aqui é onde faremos as manipulações
        Repositorio repositorio = Repositorio.getInstancia();
        //Adicionando usuários ao repositório
        Usuario usuarioGraduacao = new AlunoGraduacao("João da Silva", "123");
        Usuario usuarioPosGraduacao = new AlunoPosGraduacao("Maria Oliveira", "456");
        Usuario usuarioGraducao2 = new AlunoGraduacao("Ana Paula", "789");
        Usuario usuarioProfessor = new Professor("Carlos Lucena", "100");

        repositorio.adicionarUsuario(usuarioGraduacao);
        repositorio.adicionarUsuario(usuarioPosGraduacao);
        repositorio.adicionarUsuario(usuarioGraducao2);
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

        // Adicionar Comandos:
        Comando consultarLivro = new ConsultarLivro();
        Comando consultarUsuario = new ConsultarUsuario();

        // Executando comandos

        CarregadorParametros carregadorParametrosUsuario = new CarregadorParametros("123");
        consultarUsuario.executar(carregadorParametrosUsuario);

        }
    
}

package Comandos;

import java.util.ArrayList;
import Biblioteca.*;

public class Repositorio {
    private static Repositorio instancia;

    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;

    private Repositorio() {
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
    }

    public static Repositorio getInstancia() {
        if (instancia == null) {
            instancia = new Repositorio();
        }
        return instancia;
    }

    //codigo de busca padrãoo
    public Livro buscarLivro(String codigolivro){ 
        for(Livro livro: livros){
            if(livro.getCodigo().equals(codigolivro)){
                return livro;
            }
        }
        return null;
    }

    //codigo de busca padrão
    public Usuario buscarUsuario(String codigousuario){
        for(Usuario usuario: usuarios){
            if(usuario.getCodigoidentificacao().equals(codigousuario)){
                return usuario;
            }
        }
        return null;
    }


    // adicionar um usuário ao repositório
    public void adicionarUsuario(Usuario usuario) {
        if (buscarUsuario(usuario.getCodigoidentificacao()) == null) {
            usuarios.add(usuario);
        } else {
            System.out.println("Usuário já existe.");
        }
    }
    // adicionar um livro ao repositório
    public void adicionarLivro(Livro livro) {
        if (buscarLivro(livro.getCodigo()) == null) {
            livros.add(livro);
        } else {
            System.out.println("Livro já existe.");
        }
    }

    // remover um usuário do repositório
    public void removerUsuario(String codigousuario) {
        Usuario usuario = buscarUsuario(codigousuario);
        if (usuario != null) {
            usuarios.remove(usuario);
        } else {
            System.out.println("Usuário não encontrado.");
        }
    }
    // remover um livro do repositório
    public void removerLivro(String codigoLivro){
        Livro livro = buscarLivro(codigoLivro);
        if (livro != null) {
            livros.remove(livro);
        } else {
            System.out.println("Livro não encontrado.");
        }
    }
    

    
}



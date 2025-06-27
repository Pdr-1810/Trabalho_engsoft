package Comandos;

import java.util.ArrayList;
import Biblioteca.*;

public class Repositorio {
    private static Repositorio instancia;

    private ArrayList<Usuario> usuarios;
    private ArrayList<Livro> livros;

    public Repositorio() {
        usuarios = new ArrayList<>();
        livros = new ArrayList<>();
    }

    public static Repositorio getInstancia() {
        if (instancia == null) {
            instancia = new Repositorio();
        }
        return instancia;
    }

    //codigo de busca padrão
    public Livro buscarLivro(String codigolivro){ 
        for(Livro livro: livros){
            if(livro.getCodigo() == codigolivro){
                return livro;
            }
        }
        return null;
    }

    //codigo de busca padrão
    public Usuario buscarUsuario(String codigousuario){
        for(Usuario usuario: usuarios){
            if(usuario.getCodigoidentificacao() == codigousuario){
                return usuario;
            }
        }
        return null;
    }
    

    
}



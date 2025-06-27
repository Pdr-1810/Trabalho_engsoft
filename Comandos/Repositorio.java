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

    // Metodo para buscar Observadores (não sei se isso seria correto)
    public IObservadorLivro buscarObservador(String codigoUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.getCodigoidentificacao().equals(codigoUsuario) && usuario instanceof IObservadorLivro) {
                return (IObservadorLivro) usuario;
            }
        }
        return null;
    }
    

    
}



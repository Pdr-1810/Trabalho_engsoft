import java.util.ArrayList;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;

    //provavelmente o emprestimo vai ter a data que foi realizado o emprestimo e a data atual, que será checada rotineiramente para todos os usuários (padrão observer).
    //caso ultrapasse o limite de cada tipo de usuário ele ficará com os status de devedor
    //

    
    public Emprestimo(Usuario usuario, Exemplar exemplar) {
        this.usuario = usuario;
        this.exemplar = exemplar;
    }

    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Exemplar getExemplar() {
        return exemplar;
    }
    public void setExemplar(Exemplar exemplar) {
        this.exemplar = exemplar;
    }

    
    
}

import java.time.LocalDate;

public class Reserva{
    private Usuario usuario;
    private Livro livro;
    private LocalDate datadareserva;

    public Reserva(Usuario Usuario, Livro Livro){
        usuario = Usuario;
        livro =  Livro;
        datadareserva = LocalDate.now();
    }
    
    public Usuario getUsuario() {
        return usuario;
    }
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }
}
import java.time.LocalDate;

public class Reserva{
    private LocalDate datadeereserva;
    private Usuario usuario;
    private Livro livro;

    public Reserva(Usuario usuario, Livro livro) {
        this.datadeereserva = LocalDate.now();
        this.usuario = usuario;
        this.livro = livro;
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
    public LocalDate getDatadeereserva() {
        return datadeereserva;
    }
    public void setDatadeereserva(LocalDate datadeereserva) {
        this.datadeereserva = datadeereserva;
    }
}
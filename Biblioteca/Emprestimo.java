package Biblioteca;

import java.time.LocalDate;

public class Emprestimo {
    private Usuario usuario;
    private Exemplar exemplar;
    private LocalDate datadeemprestimo;
    private LocalDate dataderetorno;
    //provavelmente o emprestimo vai ter a data que foi realizado o emprestimo e a data atual, que será checada rotineiramente para todos os usuários (padrão observer).
    //caso ultrapasse o limite de cada tipo de usuário ele ficará com os status de devedor
    //

    public Emprestimo(Usuario usuario, Exemplar exemplar, LocalDate Datadeemprestimo, LocalDate Dataderetorno) {
        this.usuario = usuario;
        this.exemplar = exemplar;
        this.datadeemprestimo = Datadeemprestimo;
        this.dataderetorno = Dataderetorno;
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
    public LocalDate getDatadeemprestimo() {
        return datadeemprestimo;
    }
    public void setDatadeemprestimo(LocalDate datadeemprestimo) {
        this.datadeemprestimo = datadeemprestimo;
    }
    public LocalDate getDataderetorno() {
        return dataderetorno;
    }
    public void setDataderetorno(LocalDate dataderetorno) {
        this.dataderetorno = dataderetorno;
    }


    // Funções mais espcíficas:
    public Livro getLivro() { // retorna o livro do exemplar
       return this.exemplar.getLivro();
    }
    public String getTituloDoLivro() { // retorna o título do livro do exemplar
     return  exemplar.getTituloDoLivro();
    }
    public String getNomeDoUsuario() { // retorna o nome do usuário que fez o empréstimo
        return usuario.getNome();
    }
    
    public void devolver(){
        this.setDataderetorno(LocalDate.now());
    }

    
}

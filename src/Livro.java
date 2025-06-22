import java.util.ArrayList;

public class Livro{
    private int codigo;
    private String titulo;
    private String editora;
    private ArrayList<String> autores; //no PDF fala autores, aí fiquei na dúvida se a gente bota uma lista de strings ou não
    private String edicao;
    private int anodepublicacao;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Reserva> reservas;

    public int getCodigo() {
        return codigo;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getEditora() {
        return editora;
    }
    public void setEditora(String editora) {
        this.editora = editora;
    }
    public ArrayList<String> getAutores() {
        return autores;
    }
    public void setAutores(ArrayList<String> Autores) {
        this.autores =  Autores;
    }
    public String getEdicao() {
        return edicao;
    }
    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }
    public int getAnodepublicacao() {
        return anodepublicacao;
    }
    public void setAnodepublicacao(int anodepublicacao) {
        this.anodepublicacao = anodepublicacao;
    }
    public ArrayList<Exemplar> getExemplares() {
        return exemplares;
    }
    public void setExemplares(ArrayList<Exemplar> exemplares) {
        this.exemplares = exemplares;
    }
    public ArrayList<Reserva> getReservas() {
        return reservas;
    }
    public void setReservas(ArrayList<Reserva> reservas) {
        this.reservas = reservas;
    }

    //checa no arrray se algum exemplar não possui nenhum emprestimo atual, ou seja, está diponível
    public Exemplar checarExemplares(){
        for (Exemplar exemplar: exemplares){
            if(exemplar.getEmprestimoatual() == null){
                return exemplar;
            }
        }
        return null;
    }
    public int checarQuantidadeExemplaresDisponiveis(){
        int quantidade = 0;
        for (Exemplar exemplar: exemplares){
            if(exemplar.getEmprestimoatual() == null){
                quantidade++;
            }
        }
        return quantidade;
    }

    public void adicionarReserva(Reserva reserva){
        reservas.add(reserva);
    }
}
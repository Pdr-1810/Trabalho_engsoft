import java.util.ArrayList;

public class Livro{
    private int codigo;
    private String titulo;
    private String editora;
    private String autor; //no PDF fala autores, aí fiquei na dúvida se a gente bota uma lista de strings ou não
    private String edicao;
    private int anodepublicacao;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Reserva> reservas;
}
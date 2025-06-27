package Biblioteca;

import java.util.ArrayList;

public class Livro implements IObjetoObservado {
    private String codigo;
    private String titulo;
    private String editora;
    private ArrayList<String> autores; //no PDF fala autores, aí fiquei na dúvida se a gente bota uma lista de strings ou não
    private String edicao;
    private int anodepublicacao;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Reserva> reservas;
    private ArrayList<IObservadorLivro> observadores;

    public Livro (String Codigo, String Titulo, String Editora, ArrayList<String> Autores, String Edicao, int Anodepublicacao){
        this.codigo = Codigo;
        this.titulo = Titulo;
        this.editora = Editora;
        this.autores = Autores;
        this.edicao = Edicao;
        this.anodepublicacao = Anodepublicacao;

        exemplares = new ArrayList<Exemplar>();
        reservas = new ArrayList<Reserva>();
        observadores = new ArrayList<IObservadorLivro>();
    }

    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
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
            if(exemplar.isDisponivel()){
                return exemplar;
            }
        }
        return null;
    }
    public int checarQuantidadeExemplaresDisponiveis(){
        int quantidade = 0;
        for (Exemplar exemplar: exemplares){
            if(exemplar.isDisponivel()){
                quantidade++;
            }
        }
        return quantidade;
    }

    public void adicionarReserva(Reserva reserva){
        reservas.add(reserva);
        if (reservas.size() == 2){
            this.notificarObservadores(); //se bater 2 reservas notifica em + 1
        }
    }

    public void removerReservaPeloUsuario(Usuario usuario){ //remove reserva pelo usuário (usado na função de alugar livro no usuario)
        for (Reserva reserva: reservas){
            if(reserva.getUsuario() == usuario){
                reservas.remove(reserva);
                return;
            }
        }
    }

    @Override
    public void registrarObservador(IObservadorLivro observador){
        observadores.add(observador);
    }

    @Override
    public void removerObservador(IObservadorLivro observador){
        observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(){  //atualiza o valor correto de notificacoes ativas para os observadores
        for(IObservadorLivro observador : observadores){
            observador.atualizar();
        }
    }
    //não sei se a logica de incremento e decremento de observadores está correta, mas pelo menos está funcional
}
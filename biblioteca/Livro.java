package biblioteca;

import java.util.ArrayList;

public class Livro implements IObjetoObservado {
    private int codigo;
    private String titulo;
    private String editora;
    private ArrayList<String> autores; //no PDF fala autores, aí fiquei na dúvida se a gente bota uma lista de strings ou não
    private String edicao;
    private int anodepublicacao;
    private ArrayList<Exemplar> exemplares;
    private ArrayList<Reserva> reservas;
    private ArrayList<IObservadorLivro> observadores;

    public Livro (int Codigo, String Titulo, String Editora, ArrayList<String> Autores, String Edicao, int Anodepublicacao){
        codigo = Codigo;
        titulo = Titulo;
        editora = Editora;
        autores = Autores;
        edicao = Edicao;
        anodepublicacao = Anodepublicacao;

        exemplares = new ArrayList<Exemplar>();
        reservas = new ArrayList<Reserva>();
        observadores = new ArrayList<IObservadorLivro>();
    }

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
        if (reservas.size() == 2){
            this.notificarObservadores(+ 1); //se bater 2 reservas notifica em + 1
        }
    }

    public void removerReservaPeloUsuario(Usuario usuario){ //remove reserva pelo usuário (usado na função de alugar livro no usuario)
        for (Reserva reserva: reservas){
            if(reserva.getUsuario() == usuario){
                if (reservas.size() == 2){
                    this.notificarObservadores(- 1);  //se ficar menos de 2 reservas notifica em -1
                }
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
    public void notificarObservadores(int valor){  //atualiza o valor correto de notificacoes ativas para os observadores
        for(IObservadorLivro observador : observadores){
            observador.atualizar(valor);
        }
    }
    //não sei se a logica de incremento e decremento de observadores está correta, mas pelo menos está funcional
}
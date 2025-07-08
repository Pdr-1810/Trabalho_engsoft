package Biblioteca;

import java.util.ArrayList;

public class Exemplar {
    private Livro livro;
    private Emprestimo emprestimoatual;
    private String codigoExemplar;
    private boolean disponivel;
    
    public Exemplar(Livro livro, String codigoExemplar, boolean disponivel) {
        this.livro = livro;
        this.emprestimoatual = null; // Inicialmente, não há empréstimo atual
        this.codigoExemplar = codigoExemplar;
        this.disponivel = disponivel;
    }


    public Livro getLivro() {
        return livro;
    }
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    public Emprestimo getEmprestimoatual() {
        return emprestimoatual;
    }
    public void setEmprestimoatual(Emprestimo emprestimoatual) {
        this.emprestimoatual = emprestimoatual;
    }
    
    public String getCodigoExemplar() {
        return codigoExemplar;
    }
    public void setCodigoExemplar(String codigoExemplar) {
        this.codigoExemplar = codigoExemplar;
    }

    public ArrayList<Reserva> obterReservasLivro() {
    return this.livro.getReservas(); // Retorna a lista de reservas do livro associado a este exemplar
    }
    public ArrayList<Exemplar> obterExemplaresLivro() {
        return this.livro.getExemplares(); // Retorna a lista de exemplares do livro associado a este exemplar
    }
    public int getExemplaresDisponiveis(){
        return this.livro.checarQuantidadeExemplaresDisponiveis(); // Retorna a quantidade de exemplares disponíveis do livro associado a este exemplar
    }

    public String getTituloDoLivro() {
        return livro.getTitulo();
    }

    public boolean isDisponivel() {
        return this.emprestimoatual == null;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void devolver(){
        this.setDisponivel(true); // Remove o empréstimo atual
        this.setEmprestimoatual(null);
    }



}

public interface ICalculadoraEmprestimo {
    //interface básica para mexer com as calculadoras de empréstimos
    public boolean podeEmprestar(Usuario usuario, Exemplar exemplar);

    //Criar metodo para lidar com falhas:
    String getmotivoFalhaEmprestimo();
}

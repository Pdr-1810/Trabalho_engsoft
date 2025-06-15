public class CalculadoraEmprestimoProfessor implements ICalculadoraEmprestimo{
    

    //professor não tem restrição quanto a reserva, então deve ser mais simples mesmo
    public void fazerEmprestimo(Usuario usuario, Exemplar exemplar){  //já chequei anteriormente que tem exemplares disponíveis, então aqui eu só crio o empréstimo e o coloco como atual do exemplar
        Emprestimo emprestimo = new Emprestimo(usuario, exemplar);
        exemplar.setEmprestimoatual(emprestimo);
        usuario.emprestimosatuais.add(emprestimo);  
    }
}

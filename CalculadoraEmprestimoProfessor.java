import java.time.LocalDate;

public class CalculadoraEmprestimoProfessor implements ICalculadoraEmprestimo{
    
    //professor não tem restrição quanto a reserva, então deve ser mais simples mesmo
    public void fazerEmprestimo(Usuario usuario, Exemplar exemplar){  //já chequei anteriormente que tem exemplares disponíveis, então aqui eu só crio o empréstimo e o coloco como atual do exemplar
        LocalDate diadoemprestimo = LocalDate.now();
        Emprestimo emprestimo = new Emprestimo(usuario, exemplar, diadoemprestimo, diadoemprestimo.plusDays(8)); //coloca o dia do emprestimo como o hoje e a data de retorno como hoje +8;
        exemplar.setEmprestimoatual(emprestimo);
        usuario.emprestimosatuais.add(emprestimo);  
    }
}

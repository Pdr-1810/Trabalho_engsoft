package Verificadores;

import biblioteca.Exemplar;
import biblioteca.Usuario;

public class VerificadorEmprestimoProfessor implements IVerificadorEmprestimo {
    private String motivoFalha = "";

    //professor não tem restrição quanto a reserva, então deve ser mais simples mesmo
    public boolean podeEmprestar(Usuario usuario, Exemplar exemplar){  //já chequei anteriormente que tem exemplares disponíveis, então aqui eu só crio o empréstimo e o coloco como atual do exemplar
        motivoFalha = "";
        return true;
    }
    @Override
    public String getmotivoFalhaEmprestimo() {
        return motivoFalha;
    }
}

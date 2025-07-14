package Verificadores;

import Biblioteca.Exemplar;
import Biblioteca.Usuario;

public class VerificadorEmprestimoProfessor implements IVerificadorEmprestimo {
    private String motivoFalha = "";

    //professor não tem restrição quanto a reserva, então deve ser mais simples mesmo
    public boolean podeEmprestar(Usuario usuario, Exemplar exemplar){  //já chequei anteriormente que tem exemplares disponíveis, então aqui eu só crio o empréstimo e o coloco como atual do exemplar
        usuario.verificaDevedor();
        if(usuario.getDevedor()){  //verifica se o professor é devedor, se for, não pode pegar emprestado
            motivoFalha = "Professor devedor não pode pegar emprestado";
            return false;
        }
        motivoFalha = "";
        return true;
    }
    @Override
    public String getmotivoFalhaEmprestimo() {
        return motivoFalha;
    }
}

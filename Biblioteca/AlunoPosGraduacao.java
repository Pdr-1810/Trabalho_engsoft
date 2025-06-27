package Biblioteca;

import Verificadores.VerificadorEmprestimoAluno;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String nome, String codigoidentificacao) {
        super(nome, codigoidentificacao);
        verificador = new VerificadorEmprestimoAluno();
        devedor = false;
    }
    public int obterDiasEmprestimo(){
        return 5;
    }

    public int obterMaxEmprestimos(){
        return 3;
    }
    
}

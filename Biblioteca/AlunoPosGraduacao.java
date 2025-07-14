package Biblioteca;

import Verificadores.VerificadorEmprestimoAluno;

public class AlunoPosGraduacao extends Usuario {

    public AlunoPosGraduacao(String nome, String codigoidentificacao) {
        super(nome, codigoidentificacao);
        this.verificador = new VerificadorEmprestimoAluno();
        this.devedor = false;
    }
    public int obterDiasEmprestimo(){
        return 5;
    }

    public int obterMaxEmprestimos(){
        return 3;
    }
    
}

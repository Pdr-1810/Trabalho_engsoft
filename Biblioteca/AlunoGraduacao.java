package Biblioteca;

import Verificadores.VerificadorEmprestimoAluno;

public class AlunoGraduacao extends Usuario {

    public AlunoGraduacao(String nome, String codigoidentificacao) {
        super(nome, codigoidentificacao);
        this.verificador = new VerificadorEmprestimoAluno();
        this.devedor = false;
    }

    public int obterDiasEmprestimo(){
        return 4;
    }

    public int obterMaxEmprestimos(){
        return 2;
    }
}
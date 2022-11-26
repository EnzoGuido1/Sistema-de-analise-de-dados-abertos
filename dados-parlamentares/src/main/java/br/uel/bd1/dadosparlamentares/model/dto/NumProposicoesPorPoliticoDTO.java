package br.uel.bd1.dadosparlamentares.model.dto;

public class NumProposicoesPorPoliticoDTO {
    private String nome,
                   snome,
                   par_sigla;
    private Long num_proposicoes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSnome() {
        return snome;
    }

    public void setSnome(String snome) {
        this.snome = snome;
    }

    public String getPar_sigla() {
        return par_sigla;
    }

    public void setPar_sigla(String par_sigla) {
        this.par_sigla = par_sigla;
    }

    public Long getNum_proposicoes() {
        return num_proposicoes;
    }

    public void setNum_proposicoes(Long num_proposicoes) {
        this.num_proposicoes = num_proposicoes;
    }
}

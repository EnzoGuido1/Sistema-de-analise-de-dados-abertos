package br.uel.bd1.dadosparlamentares.model.dto;

public class NumPoliticosPorPartidoDTO {
    private String par_sigla;
    private Long num_politicos;

    public String getPar_sigla() {
        return par_sigla;
    }

    public void setPar_sigla(String par_sigla) {
        this.par_sigla = par_sigla;
    }

    public Long getNum_politicos() {
        return num_politicos;
    }

    public void setNum_politicos(Long num_politicos) {
        this.num_politicos = num_politicos;
    }
}

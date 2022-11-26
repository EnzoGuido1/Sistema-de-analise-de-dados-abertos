package br.uel.bd1.dadosparlamentares.model.dto;

public class GastoAnualPorPoliticoDTO {
    private String nome,
                   snome,
                   par_sigla;
    private Double gasto_anual;

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

    public Double getGasto_anual() {
        return gasto_anual;
    }

    public void setGasto_anual(Double gasto_anual) {
        this.gasto_anual = gasto_anual;
    }
}

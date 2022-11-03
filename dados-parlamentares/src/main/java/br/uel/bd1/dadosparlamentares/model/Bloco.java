package br.uel.bd1.dadosparlamentares.model;

import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

//@Named                KKKK SOU UMA ANTA
//@RequestScoped
public class Bloco {
    @NotNull
    private Long id,
                 num_leg;
    @NotNull
    @Size(max=6)
    private String par_sigla;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNum_leg() {
        return num_leg;
    }

    public void setNum_leg(Long num_leg) {
        this.num_leg = num_leg;
    }

    public String getPar_sigla() {
        return par_sigla;
    }

    public void setPar_sigla(String par_sigla) {
        this.par_sigla = par_sigla;
    }
}
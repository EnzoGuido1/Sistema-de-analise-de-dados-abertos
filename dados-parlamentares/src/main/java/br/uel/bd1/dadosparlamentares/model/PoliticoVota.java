package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PoliticoVota {
    @NotNull
    private Long pol_cpf_id;
    @NotNull
    @Size(max=12)
    private String vot_id;

    public Long getPol_cpf_id() {
        return pol_cpf_id;
    }

    public void setPol_cpf_id(Long pol_cpf_id) {
        this.pol_cpf_id = pol_cpf_id;
    }

    public String getVot_id() {
        return vot_id;
    }

    public void setVot_id(String vot_id) {
        this.vot_id = vot_id;
    }
}

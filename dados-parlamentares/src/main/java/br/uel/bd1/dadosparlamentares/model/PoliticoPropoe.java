package br.uel.bd1.dadosparlamentares.model;

import jakarta.validation.constraints.NotNull;

public class PoliticoPropoe {
    @NotNull
    private Long pol_cpf_id;
    @NotNull
    private Long prop_id;

    public Long getPol_cpf_id() {
        return pol_cpf_id;
    }

    public void setPol_cpf_id(Long pol_cpf_id) {
        this.pol_cpf_id = pol_cpf_id;
    }

    public Long getProp_id() {
        return prop_id;
    }

    public void setProp_id(Long prop_id) {
        this.prop_id = prop_id;
    }
}

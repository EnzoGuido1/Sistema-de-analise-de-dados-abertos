package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;

public class DespesaPolitico {
    @NotNull
    private Long for_cpf_cnpj,
                 documento;
    @NotNull
    private Long pol_cpf_id;

    public Long getFor_cpf_cnpj() {
        return for_cpf_cnpj;
    }

    public void setFor_cpf_cnpj(Long for_cpf_cnpj) {
        this.for_cpf_cnpj = for_cpf_cnpj;
    }

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public Long getPol_cpf_id() {
        return pol_cpf_id;
    }

    public void setPol_cpf_id(Long pol_cpf_id) {
        this.pol_cpf_id = pol_cpf_id;
    }
}

package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Named
@RequestScoped
public class DespesaPartido {
    @NotNull
    private Long for_cpf_cnpj,
                 documento;
    @NotNull
    @Size(max=6)
    private String par_sigla;

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

    public String getPar_sigla() {
        return par_sigla;
    }

    public void setPar_sigla(String par_sigla) {
        this.par_sigla = par_sigla;
    }
}

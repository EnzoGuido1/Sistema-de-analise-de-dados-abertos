package br.uel.bd1.dadosparlamentares.model.dto;

public class FornecedoresMaisContratadosDTO {
    private Long for_cpf_cnpj,
                 num_prestacoes;

    public Long getFor_cpf_cnpj() {
        return for_cpf_cnpj;
    }

    public void setFor_cpf_cnpj(Long for_cpf_cnpj) {
        this.for_cpf_cnpj = for_cpf_cnpj;
    }

    public Long getNum_prestacoes() {
        return num_prestacoes;
    }

    public void setNum_prestacoes(Long num_prestacoes) {
        this.num_prestacoes = num_prestacoes;
    }
}

package br.uel.bd1.dadosparlamentares.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class Despesa {
    @NotNull
    private Long documento,
                 for_cpf_cnpj;
    private Date data;
    @Size(max=50)
    private String tipo;
    @Size(max=200)
    private String detalhamento;
    private Double valor;

    public Long getDocumento() {
        return documento;
    }

    public void setDocumento(Long documento) {
        this.documento = documento;
    }

    public Long getFor_cpf_cnpj() {
        return for_cpf_cnpj;
    }

    public void setFor_cpf_cnpj(Long for_cpf_cnpj) {
        this.for_cpf_cnpj = for_cpf_cnpj;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDetalhamento() {
        return detalhamento;
    }

    public void setDetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public void setValor(String valor) {
        try {
            this.valor = Double.valueOf(valor);
        } catch (NumberFormatException e) {
            this.valor = Double.valueOf(0.0);
        }
    }
}

package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.postgresql.util.PGmoney;

import java.sql.Date;
import java.sql.SQLException;

@Named
@RequestScoped
public class Despesa {
    @NotNull
    private Long documento,
                 for_cpf_cnpj;
    private Date data;
    @Size(max=50)
    private String tipo;
    @Size(max=200)
    private String detalhamento;
    private PGmoney valor;

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

    public String getValor() {
        return valor.getValue();
    }

    public void setValor(String valor) {
        try {
            this.valor = new PGmoney(valor);
        }
        catch(SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

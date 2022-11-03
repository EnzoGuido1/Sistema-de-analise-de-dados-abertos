package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Size;

public class Partido {
    @NotNull
    private Short num;
    private Long cnpj;
    @NotNull
    @Size(max=35)
    private String nome;
    @NotNull
    @Size(max=6)
    private String sigla;

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public void setNum(Integer num) { this.num = num.shortValue(); }

    public Long getCnpj() {
        return cnpj;
    }

    public void setCnpj(Long cnpj) {
        this.cnpj = cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}

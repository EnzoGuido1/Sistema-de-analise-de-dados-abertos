package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Named
@RequestScoped
public class Politico {
    @NotNull
    private Long cpf_id;
    @Size(max=15)
    private String nome;
    @Size(max=30)
    private String sobrenome;
    @Size(max=6)
    private String sigla;

    public Long getCpf() {
        return cpf_id;
    }

    public void setCpf(Long cpf) {
        this.cpf_id = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getSigla() {
        return sigla;
    }

    public void setSigla(String sigla) {
        this.sigla = sigla;
    }
}

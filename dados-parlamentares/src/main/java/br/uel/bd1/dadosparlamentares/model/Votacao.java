package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import org.postgresql.util.PGTimestamp;

import java.sql.Date;

@Named
@RequestScoped
public class Votacao {
    @Size(max=11)
    @NotNull
    private String id;
    @Size(max=12)
    private String orgao;
    @NotNull
    private Short votos_s = 0;
    @NotNull
    private Short votos_n = 0;
    private Boolean aprovacao;
    @Size(max=250)
    private String descricao;
    @PastOrPresent
    private PGTimestamp dt_hora;
    @PastOrPresent
    private Date dt_dia;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrgao() {
        return orgao;
    }

    public void setOrgao(String orgao) {
        this.orgao = orgao;
    }

    public Short getVotos_s() {
        return votos_s;
    }

    public void setVotos_s(Short votos_s) {
        this.votos_s = votos_s;
    }

    public Short getVotos_n() {
        return votos_n;
    }

    public void setVotos_n(Short votos_n) {
        this.votos_n = votos_n;
    }

    public Boolean getAprovacao() {
        return aprovacao;
    }

    public void setAprovacao(Boolean aprovacao) {
        this.aprovacao = aprovacao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public PGTimestamp getDt_hora() {
        return dt_hora;
    }

    public void setDt_hora(long dt_hora) {
        this.dt_hora = new PGTimestamp(dt_hora);
    }

    public Date getDt_dia() {
        return dt_dia;
    }

    public void setDt_dia(Date dt_dia) {
        this.dt_dia = dt_dia;
    }
}

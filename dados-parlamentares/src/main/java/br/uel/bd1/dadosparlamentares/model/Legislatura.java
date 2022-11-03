package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.PastOrPresent;
import java.util.Date;

public class Legislatura {
    @NotNull
    private Short num;
    private Integer ano;
    private Date dt_inicio;

    private Date dt_fim;

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }

    public void setNum(Integer num) {
        this.num = num.shortValue();
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setano(Integer ano) {
        this.ano = ano;
    }

    public Date getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(Date dt_inicio) {
        this.dt_inicio = dt_inicio;
    }


    public Date getDt_fim() {
        return dt_fim;
    }

    public void setDt_fim(Date dt_fim) {
        this.dt_fim = dt_fim;
    }
}

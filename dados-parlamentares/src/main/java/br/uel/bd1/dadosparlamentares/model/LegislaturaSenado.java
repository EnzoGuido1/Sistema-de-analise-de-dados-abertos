package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;

@Named
@RequestScoped
public class LegislaturaSenado {
    @NotNull
    private Short num;

    public Short getNum() {
        return num;
    }

    public void setNum(Short num) {
        this.num = num;
    }
}

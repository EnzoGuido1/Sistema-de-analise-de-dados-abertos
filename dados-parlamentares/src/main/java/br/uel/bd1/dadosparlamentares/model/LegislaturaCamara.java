package br.uel.bd1.dadosparlamentares.model;

import jakarta.validation.constraints.NotNull;

public class LegislaturaCamara {
    @NotNull
    private Short num;

    public Short getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num.shortValue();
    }

    public void setNum(Short num) {
        this.num = num;
    }
}

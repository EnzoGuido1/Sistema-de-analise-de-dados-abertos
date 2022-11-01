package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;

@Named
@RequestScoped
public class Senador {
    @NotNull
    private Long cpf_id,
                 num_leg_sen;

    public Long getCpf_id() {
        return cpf_id;
    }

    public void setCpf_id(Long cpf_id) {
        this.cpf_id = cpf_id;
    }

    public Long getNum_leg_sen() {
        return num_leg_sen;
    }

    public void setNum_leg_sen(Long num_leg_sen) {
        this.num_leg_sen = num_leg_sen;
    }
}

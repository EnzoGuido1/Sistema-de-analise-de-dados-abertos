package br.uel.bd1.dadosparlamentares.model;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import jakarta.validation.constraints.NotNull;

@Named
@RequestScoped
public class Deputado {
    @NotNull
    private Long cpf_id,
                 leg_cam_num;

    public Long getCpf_id() {
        return cpf_id;
    }

    public void setCpf_id(Long cpf_id) {
        this.cpf_id = cpf_id;
    }

    public Long getLeg_cam_num() {
        return leg_cam_num;
    }

    public void setLeg_cam_num(Long leg_cam_num) {
        this.leg_cam_num = leg_cam_num;
    }
}

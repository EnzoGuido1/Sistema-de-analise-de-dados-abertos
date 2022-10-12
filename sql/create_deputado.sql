CREATE TABLE deputado(
    id VARCHAR(12) PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    leg_cam_num INTEGER NOT NULL,
    id_votacao VARCHAR(12) NOT NULL,
    CONSTRAINT fk_cpf FOREIGN KEY (cpf) REFERENCES politico(cpf),
    CONSTRAINT fk_leg_cam_num FOREIGN KEY (leg_cam_num) REFERENCES legislatura_ca(num),
);
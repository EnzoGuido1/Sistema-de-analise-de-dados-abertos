CREATE TABLE pol_vota(
    pol_cpf VARCHAR(12) PRIMARY KEY,
    vota_id VARCHAR(12) PRIMARY KEY,
    CONSTRAINT fk_pol_cpf FOREIGN KEY (pol_cpf) REFERENCES politico(cpf),
    CONSTRAINT fk_vota_id FOREIGN KEY (vota_id) REFERENCES votacao(id)
);
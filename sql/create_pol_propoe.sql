CREATE TABLE pol_propoe(
    pol_cpf VARCHAR(12) PRIMARY KEY,
    prop_id VARCHAR(12) PRIMARY KEY,
    CONSTRAINT fk_pol_cpf FOREIGN KEY (pol_cpf) REFERENCES politico(cpf),
    CONSTRAINT fk_prop_id FOREIGN KEY (prop_id) REFERENCES proposicao(id)
);
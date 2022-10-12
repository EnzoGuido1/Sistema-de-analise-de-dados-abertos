CREATE TABLE senador(
    id VARCHAR(12) PRIMARY KEY,
    cpf VARCHAR(11) NOT NULL,
    leg_sen_num INTEGER NOT NULL,
    CONSTRAINT fk_cpf REFERENCES politico(cpf)
    CONSTRAINT fk_leg_sen_num REFERENCES legislatura_se(num)
);
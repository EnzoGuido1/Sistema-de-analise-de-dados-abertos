CREATE TABLE despesa(
    documento VARCHAR(20) PRIMARY KEY,
    fornecedor VARCHAR(12) PRIMARY KEY,
    partido_sigla VARCHAR(5),
    politico_cpf VARCHAR(11),
    dt DATE NOT NULL,
    valor NUMERIC(10,2) NOT NULL,
    detalhamento VARCHAR(100) NOT NULL,
    CONSTRAINT fk_fornecedor FOREIGN KEY (fornecedor) REFERENCES fornecedor(cpf),
    CONSTRAINT fk_partido_sigla FOREIGN KEY (partido_sigla) REFERENCES partido(sigla),
    CONSTRAINT fk_politico_cpf FOREIGN KEY (politico_cpf) REFERENCES politico(cpf)
);
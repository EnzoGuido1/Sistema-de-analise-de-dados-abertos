CREATE TABLE filiacao(
    partido_sigla VARCHAR(5) NOT NULL,
    politico_cpf VARCHAR(11) PRIMARY KEY,
    ano INTEGER NOT NULL,
    turno INTEGER NOT NULL,
    estado_sigla VARCHAR(2) NOT NULL,
    CONSTRAINT fk_partido_sigla FOREIGN KEY (partido_sigla) REFERENCES partido(sigla),
    CONSTRAINT fk_politico_cpf FOREIGN KEY (politico_cpf) REFERENCES politico(cpf),
    CONSTRAINT fk_ano FOREIGN KEY (ano) REFERENCES eleicao(ano),
    CONSTRAINT fk_turno FOREIGN KEY (turno) REFERENCES eleicao(turno),
    CONSTRAINT fk_estado_sigla FOREIGN KEY (estado_sigla) REFERENCES eleicao(estado_sigla)
);
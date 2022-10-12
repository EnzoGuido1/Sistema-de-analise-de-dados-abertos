CREATE TABLE legislatura(
    id VARCHAR(12) PRIMARY KEY,
    ano INTEGER NOT NULL,
    turno INTEGER NOT NULL,
    estado_sigla VARCHAR(2) NOT NULL,
    dt_inicio DATE NOT NULL,
    dt_fim DATE NOT NULL,
    CONSTRAINT fk_id FOREIGN KEY (id) REFERENCES legislatura(id),
    CONSTRAINT fk_ano FOREIGN KEY (ano) REFERENCES eleicao(ano),
    CONSTRAINT fk_turno FOREIGN KEY (turno) REFERENCES eleicao(turno),
    CONSTRAINT fk_estado_sigla FOREIGN KEY (estado_sigla) REFERENCES eleicao(estado_sigla)
);
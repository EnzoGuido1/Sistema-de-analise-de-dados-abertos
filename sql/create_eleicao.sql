CREATE TABLE eleicao(
    ano INTEGER,
    turno INTEGER,
    estado_sigla VARCHAR(2),
    resultado VARCHAR(20),
    PRIMARY KEY(ano, turno, estado_sigla),
);
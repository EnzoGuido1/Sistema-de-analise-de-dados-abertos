CREATE TABLE votacao(
    id VARCHAR(12) PRIMARY KEY,
    orgao VARCHAR(12) NOT NULL,
    dt DATE NOT NULL,
    votos_sim INTEGER,
    votos_nao INTEGER,
    votos_abst INTEGER,
    aprovacao BOOLEAN,
    descricao VARCHAR(100)
);
CREATE TABLE votacao(
    id VARCHAR(12) PRIMARY KEY,
    orgao VARCHAR(12) NOT NULL,
    dt DATE NOT NULL,
    votos_sim INTEGER NOT NULL,
    votos_nao INTEGER NOT NULL,
    votos_abst INTEGER NOT NULL,
    aprovacao BOOLEAN NOT NULL,
    descricao VARCHAR(100) NOT NULL
);
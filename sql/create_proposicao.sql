CREATE TABLE proposicao(
    id VARCHAR(12) PRIMARY KEY,
    autor VARCHAR(12) NOT NULL,
    descricao VARCHAR(100) NOT NULL,
    dt DATE NOT NULL,
    CONSTRAINT fk_autor FOREIGN KEY (autor) REFERENCES politico(cpf)
);
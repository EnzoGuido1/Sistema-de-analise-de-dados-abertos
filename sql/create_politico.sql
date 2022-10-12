CREATE TABLE politico(
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    snome VARCHAR(100) NOT NULL,
    par_sigla VARCHAR(5) NOT NULL,
    CONSTRAINT fk_par_sigla FOREIGN KEY (par_sigla) REFERENCES partido(sigla)
);
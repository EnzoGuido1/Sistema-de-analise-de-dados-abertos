CREATE TABLE politico(
    cpf VARCHAR(11) PRIMARY KEY,
    nome VARCHAR(15) NOT NULL,
    snome VARCHAR(35) NOT NULL,
    par_sigla VARCHAR(5) NOT NULL,
    CONSTRAINT fk_par_sigla FOREIGN KEY (par_sigla) REFERENCES partido(sigla)
);
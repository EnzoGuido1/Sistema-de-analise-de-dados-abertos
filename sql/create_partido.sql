CREATE TABLE partido(
    sigla VARCHAR(5) PRIMARY KEY,
    cnpj VARCHAR(14),
    nome VARCHAR(100) NOT NULL,
    numero INTEGER NOT NULL
);
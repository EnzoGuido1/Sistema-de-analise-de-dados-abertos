CREATE TABLE bloco(
    id VARCHAR(12) PRIMARY KEY,
    leg_id VARCHAR(12) NOT NULL,
    partido_sigla VARCHAR(10) NOT NULL,
    CONSTRAINT fk_leg_id FOREIGN KEY (leg_id) REFERENCES legislatura(id),
    CONSTRAINT fk_partido_sigla FOREIGN KEY (partido_sigla) REFERENCES partido(sigla)
);
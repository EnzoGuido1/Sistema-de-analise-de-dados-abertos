CREATE TABLE legislatura_ca(
    num INTEGER PRIMARY KEY,
    id VARCHAR(12) NOT NULL,
    CONSTRAINT fk_id FOREIGN KEY (id) REFERENCES legislatura(id)
);
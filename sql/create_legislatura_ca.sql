CREATE TABLE legislatura_ca(
    num INTEGER PRIMARY KEY SERIAL,
    CONSTRAINT fk_id FOREIGN KEY (id) REFERENCES legislatura(id)
);
CREATE TABLE dep_proposicao(
    dep_id VARCHAR(12) NOT NULL,
    prop_id VARCHAR(12) NOT NULL
    CONSTRAINT fk_dep_id FOREIGN KEY (dep_id) REFERENCES deputado(id),
    CONSTRAINT fk_prop_id FOREIGN KEY (prop_id) REFERENCES proposicao(id)
);
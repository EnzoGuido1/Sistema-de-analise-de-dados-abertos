CREATE TABLE legislatura(
    id VARCHAR(12) PRIMARY KEY,
    ano INTEGER NOT NULL,
    turno INTEGER NOT NULL,
    estado_sigla VARCHAR(2) NOT NULL,
    dt_inicio DATE NOT NULL,
    dt_fim DATE NOT NULL,
    CONSTRAINT fk_ano FOREIGN KEY (ano) REFERENCES eleicao(ano),
    CONSTRAINT fk_turno FOREIGN KEY (turno) REFERENCES eleicao(turno),
    CONSTRAINT fk_estado_sigla FOREIGN KEY (estado_sigla) REFERENCES eleicao(estado_sigla)
    CONSTRAINT u_turno UNIQUE (ano, turno, estado_sigla)
    CONSTRAINT siglas estado_sigla IN ('AC', 'AL', 'AP', 'AM', 
    'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 'PA', 
    'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 'SC', 
    'SP', 'SE', 'TO')
);
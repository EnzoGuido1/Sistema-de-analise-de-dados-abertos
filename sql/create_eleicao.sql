CREATE TABLE eleicao(
    ano INTEGER,
    turno INTEGER,
    estado_sigla VARCHAR(2),
    PRIMARY KEY(ano, turno, estado_sigla),
    CONSTRAINT turnos CHECK(turno IN (1, 2)),
    CONSTRAINT siglas CHECK(estado_sigla IN ('AC', 'AL', 'AP', 
    'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 
    'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 
    'SC', 'SP', 'SE', 'TO')),
);
CREATE TABLE public.eleicao
(
    ano smallint NOT NULL,
    turno smallint NOT NULL,
    estado_sigla character varying(2) NOT NULL,
    CONSTRAINT pk_estado PRIMARY KEY (ano, turno, estado_sigla),
    CONSTRAINT sigla_valida CHECK (estado_sigla IN ('AC', 'AL', 'AP', 
    'AM', 'BA', 'CE', 'DF', 'ES', 'GO', 'MA', 'MT', 'MS', 'MG', 
    'PA', 'PB', 'PR', 'PE', 'PI', 'RJ', 'RN', 'RS', 'RO', 'RR', 
    'SC', 'SP', 'SE', 'TO'))
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.eleicao
    OWNER to postgres;

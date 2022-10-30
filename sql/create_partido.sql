CREATE TABLE public.partido
(
    sigla character varying(5) NOT NULL,
    nome character varying(35) NOT NULL,
    num smallint NOT NULL,
    cnpj bigint,
    CONSTRAINT pk_partido PRIMARY KEY (sigla)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.partido
    OWNER to postgres;

CREATE TABLE public.politico
(
    cpf bigint NOT NULL,
    nome character varying(15) NOT NULL,
    snome character varying(35),
    par_sigla character varying(5) NOT NULL DEFAULT 'N/A',
    PRIMARY KEY (cpf)
);

ALTER TABLE IF EXISTS public.politico
    OWNER to postgres;

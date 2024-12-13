DROP TABLE IF EXISTS client, jeu_genre, genre, exemplaire, jeu;

CREATE TABLE IF NOT EXISTS public.client
(
    numeroclient integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    nom character varying COLLATE pg_catalog."default" NOT NULL,
    prenom character varying COLLATE pg_catalog."default" NOT NULL,
    email character varying COLLATE pg_catalog."default" NOT NULL,
    rue character varying COLLATE pg_catalog."default" NOT NULL,
    codepostal character varying COLLATE pg_catalog."default" NOT NULL,
    ville character varying COLLATE pg_catalog."default" NOT NULL,
    telephone character varying COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT client_pkey PRIMARY KEY (numeroclient),
    CONSTRAINT email UNIQUE (email)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.client
    OWNER to postgres;


CREATE TABLE IF NOT EXISTS public.genre
(
    numerogenre integer NOT NULL DEFAULT nextval('genre_numerogenre_seq'::regclass),
    libelle character varying(255) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT genre_pkey PRIMARY KEY (numerogenre),
    CONSTRAINT genre_libelle_key UNIQUE (libelle)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.genre
    OWNER to postgres;



CREATE TABLE IF NOT EXISTS public.jeu
(
    numerojeu integer NOT NULL DEFAULT nextval('jeu_numerojeu_seq'::regclass),
    titre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    description text COLLATE pg_catalog."default",
    reference character varying(13) COLLATE pg_catalog."default" NOT NULL,
    tarifjournee numeric(10,2),
    agemin integer,
    duree integer,
    CONSTRAINT jeu_pkey PRIMARY KEY (numerojeu)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.jeu
    OWNER to postgres;



CREATE TABLE IF NOT EXISTS public.jeu_genre
(
    numerojeu integer NOT NULL,
    numerogenre integer NOT NULL,
    CONSTRAINT jeu_genre_pkey PRIMARY KEY (numerojeu, numerogenre),
    CONSTRAINT jeu_genre_numerogenre_fkey FOREIGN KEY (numerogenre)
        REFERENCES public.genre (numerogenre) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT jeu_genre_numerojeu_fkey FOREIGN KEY (numerojeu)
        REFERENCES public.jeu (numerojeu) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.jeu_genre
    OWNER to postgres;




CREATE TABLE IF NOT EXISTS public.exemplaire
(
    numeroexemplaire integer NOT NULL DEFAULT nextval('exemplaire_numeroexemplaire_seq'::regclass),
    codebarre character varying(255) COLLATE pg_catalog."default" NOT NULL,
    louable boolean NOT NULL DEFAULT true,
    numerojeu integer NOT NULL,
    CONSTRAINT exemplaire_pkey PRIMARY KEY (numeroexemplaire),
    CONSTRAINT unique_codebarre UNIQUE (codebarre),
    CONSTRAINT fk_exemplaire_jeu FOREIGN KEY (numerojeu)
        REFERENCES public.jeu (numerojeu) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE CASCADE,
    CONSTRAINT chk_codebarre_length CHECK (char_length(codebarre::text) = 13)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.exemplaire
    OWNER to postgres;
GRANT ALL ON ALL TABLES IN SCHEMA public TO ludouser;
GRANT ALL ON ALL TABLES IN SCHEMA public TO postgres;

DROP TABLE IF EXISTS public.utilisateur;


CREATE TABLE public.utilisateur
(
    id integer NOT NULL DEFAULT nextval('utilisateur_id_seq'::regclass),
    login character varying(50) COLLATE pg_catalog."default" NOT NULL,
    password character varying(255) COLLATE pg_catalog."default" NOT NULL,
    role character varying(50) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT utilisateur_pkey PRIMARY KEY (id),
    CONSTRAINT utilisateur_login_key UNIQUE (login)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.utilisateur
    OWNER to postgres;

GRANT ALL ON TABLE public.utilisateur TO ludouser;

GRANT ALL ON TABLE public.utilisateur TO postgres;


CREATE TABLE IF NOT EXISTS public.location
(
    numerolocation integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    datedebutlocation date NOT NULL,
    paye boolean,
    prixtotal numeric,
    numeroclient integer,
    CONSTRAINT location_pkey PRIMARY KEY (numerolocation),
    CONSTRAINT numeroclient FOREIGN KEY (numeroclient)
        REFERENCES public.client (numeroclient) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.location
    OWNER to postgres;

GRANT ALL ON TABLE public.location TO ludouser;

GRANT ALL ON TABLE public.location TO postgres;

CREATE TABLE IF NOT EXISTS public.detail_location
(
    numeroligne integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 MINVALUE 1 MAXVALUE 2147483647 CACHE 1 ),
    dateretour date,
    tariflocation numeric,
    numeroexemplaire integer,
    numerolocation integer,
    CONSTRAINT detail_location_pkey PRIMARY KEY (numeroligne),
    CONSTRAINT numeroexemplaire FOREIGN KEY (numeroexemplaire)
        REFERENCES public.exemplaire (numeroexemplaire) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT numerolocation FOREIGN KEY (numerolocation)
        REFERENCES public.location (numerolocation) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.detail_location
    OWNER to postgres;

GRANT ALL ON TABLE public.detail_location TO ludouser;

GRANT ALL ON TABLE public.detail_location TO postgres;

create table "individu"(
    id   BIGSERIAL NOT NULL,
    f_name VARCHAR,
    l_name  VARCHAR,
    age int,
    sexe VARCHAR,
    adresse VARCHAR,
    tel VARCHAR,
    NAS VARCHAR,
    departement VARCHAR,
    suivi VARCHAR,
    notes_evolutive TEXT,
    objectif VARCHAR,
    CONSTRAINT individu_pk PRIMARY KEY(id)
);
create table "intervenant"(
    id BIGSERIAL NOT NULL CONSTRAINT intervenant_pk PRIMARY KEY,
    f_name VARCHAR,
    l_name VARCHAR,
    email  VARCHAR,
    tel    VARCHAR,
    adresse VARCHAR,
    mot_de_passe  VARCHAR
);

create table "directeur"
(
    id BIGSERIAL NOT NULL CONSTRAINT directeur_pk PRIMARY KEY,
    username VARCHAR,
    mot_de_passe VARCHAR
);


create table "statistique" (

    id BIGSERIAL NOT NULL CONSTRAINT statistique_pk PRIMARY KEY,
    nb_heure_travailehebdomadaire int ,
    nb_heure_travaile_mensuel int ,
    nb_heure_travaille_annuel  int
);

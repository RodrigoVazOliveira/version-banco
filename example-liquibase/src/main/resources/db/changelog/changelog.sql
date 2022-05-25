--liquibase formatted sql

--changeset rodrigo:1
CREATE TABLE filmes
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(45) NOT NULL,
    ano INT NOT NULL,
    genero VARCHAR(45) NOT NULL,
    CONSTRAINT PK_FILMES_ID PRIMARY KEY(id)
);

--changeset rodrigo:2
INSERT INTO filmes
VALUES
(NULL, 'Kill Bill', 2003, 'Acao');	


-- changeset rodrigo_vaz:3
CREATE TABLE distribuidora
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(25) NOT NULL,
    CONSTRAINT PK_DISTRIBUIDORA PRIMARY KEY(id)
);

--rollback DROP TABLE distribuidora;

-- changeset rodrigo_vaz:4
CREATE TABLE testando
(
	nome VARCHAR(23) NOT NULL
);
-- changeset rodrigo_vaz:5
DROP TABLE testando;
CREATE TABLE categorias
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(25) NOT NULL,
    CONSTRAINT PK_CATEGORIAS PRIMARY KEY(id)
);

CREATE TABLE livros
(
    id BIGINT NOT NULL AUTO_INCREMENT,
    titulo VARCHAR(45) NOT NULL,
    autor VARCHAR(45) NOT NULL,
    categoria_id BIGINT NOT NULL,
    CONSTRAINT PK_LIVROS PRIMARY KEY(id),
    CONSTRAINT FK_CATEGORIA FOREIGN KEY (categoria_id) 
        REFERENCES categorias(id)
);

INSERT INTO 
    categorias (nome) 
VALUES
    ('Ficcao Cientifica'), 
    ('Terror'), 
    ('Romance'), 
    ('Epico'), 
    ('Tecnologia');
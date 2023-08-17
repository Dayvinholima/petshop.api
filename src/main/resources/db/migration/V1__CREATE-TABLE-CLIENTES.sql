CREATE TABLE IF NOT EXISTS tb_clientes(
    idCliente BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR (50) NOT NULL,
    sobreNome VARCHAR (150) NOT NULL,
    genero VARCHAR (20),
    email VARCHAR (255) NOT NULL UNIQUE,
    senha VARCHAR (10),
    PRIMARY KEY (idCliente)
);
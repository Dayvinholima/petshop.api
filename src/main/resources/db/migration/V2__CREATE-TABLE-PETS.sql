CREATE TABLE IF NOT EXISTS tb_pets(
    idPet BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR (100) NOT NULL,
    especie VARCHAR (50) NOT NULL,
    raca VARCHAR (50) NOT NULL,
    dataDeNascimento DATE NOT NULL,
    idCliente BIGINT NOT NULL,
    PRIMARY KEY (idPet),
    FOREIGN KEY (idCliente) REFERENCES tb_clientes(idCliente)
);
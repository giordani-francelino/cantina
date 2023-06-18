-- DELETANDO TODAS AS TABELAS TODAS AS TABLEAS

drop table itemcardapio;
drop table produto;
drop table cardapio;

-- CRIANDO AS TABELAS

CREATE TABLE cardapio (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `descricao` varchar(50) NOT NULL,
    `valor` double NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
);

CREATE TABLE produto (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `descricao` varchar(50) NOT NULL,
    `preco` double NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
);

CREATE TABLE itemCardapio (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `idCardapio` bigint(20) unsigned,
    `idProduto` bigint(20) unsigned,
    `quantidade` int NOT NULL,
    `preco` double NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `idCardapio_idProduto` (`idCardapio`, `idProduto`),
    FOREIGN KEY (`idProduto`) REFERENCES `produto` (`id`),
    FOREIGN KEY (`idCardapio`) REFERENCES `cardapio` (`id`)
);
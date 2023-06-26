-- DELETANDO TODAS AS TABELAS TODAS AS TABELAS

drop table itemVenda;
drop table pagamento;
drop table venda;
drop table produto;
drop tabLe pessoa;

-- CRIANDO AS TABELAS

CREATE TABLE produto (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `descricao` varchar(50) NOT NULL,
    `preco` double NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
);

CREATE TABLE pessoa (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `cpf` bigint(14) unsigned NOT NULL,
    `nome` varchar(20) NOT NULL,
    `endereco` varchar(100) NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
);


 CREATE TABLE `usuario` (
   `id` int(11) NOT NULL AUTO_INCREMENT,
   `nome` varchar(55) NOT NULL,
   `email` varchar(125) NOT NULL,
   `senha` char(32) NOT NULL,
   `administrador` tinyint(1) DEFAULT '0',
   PRIMARY KEY (`id`),
   UNIQUE KEY `email` (`email`)
  ) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1


CREATE TABLE venda (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `idPessoa` bigint(11) unsigned NOT NULL,
    `dataVenda` date NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`),
    FOREIGN KEY (`idPessoa`) REFERENCES `pessoa` (`id`)
);

CREATE TABLE pagamento (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `idVenda` bigint(20) unsigned NOT NULL,
    `dataPagamento` date NOT NULL,
    `dataVencimento` date NOT NULL,
    `valorPagamento` double NOT NULL,
    `acrescimo` double NOT NULL,
    `desconto` double NOT NULL,
    `tipoPagamento` int NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`),
    FOREIGN KEY (`id`) REFERENCES `venda` (`id`)
);

CREATE TABLE itemVenda (
    `id` bigInt(20) unsigned NOT NULL AUTO_INCREMENT,
    `idProduto` bigInt(20) unsigned NOT NULL,
    `idVenda` bigInt(20) unsigned NOT NULL,
    `quantidade` int NOT NULL,
    `preco` double NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`),
    UNIQUE KEY `idProduto_idVenda` (`idProduto`, `idVenda`),
    FOREIGN KEY (`idProduto`) REFERENCES `produto` (`id`),
    FOREIGN KEY (`idVenda`) REFERENCES `venda` (`id`)
);
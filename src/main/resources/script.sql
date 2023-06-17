CREATE TABLE cardapio (
    `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
    `descricao` varchar(50) NOT NULL,
    `valor` double NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `id` (`id`)
);
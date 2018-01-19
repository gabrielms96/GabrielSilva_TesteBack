# GabrielSilva_TesteBack
Sistema batch em Java.

Script para criação da tabela no banco de dados MySQL.

CREATE DATABASE baseDeDados;

USE baseDeDados;

CREATE TABLE tb_customer_account (id_customer INT NOT NULL AUTO_INCREMENT, cpf_cnpj VARCHAR(15), nm_customer VARCHAR(80), is_active VARCHAR(50), vl_total DOUBLE(10, 2), PRIMARY KEY(id_customer));

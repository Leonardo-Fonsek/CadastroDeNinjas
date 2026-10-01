-- V2: Migrations para adicionar coluna de ranking na tabela de cadastro

ALTER TABLE tb_cadastro
ADD COLUMN nivel VARCHAR(255);


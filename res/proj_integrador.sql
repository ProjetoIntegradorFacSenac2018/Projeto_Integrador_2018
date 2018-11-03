
CREATE TABLE tb_forma_pg (
                id_forma_pg INTEGER NOT NULL,
                desc_forma_pg VARCHAR NOT NULL,
                CONSTRAINT tb_forma_pg_pk PRIMARY KEY (id_forma_pg)
);


CREATE TABLE tb_unidade (
                un_vend_prod VARCHAR NOT NULL,
                desc_unid VARCHAR NOT NULL,
                CONSTRAINT tb_unidade_pk PRIMARY KEY (un_vend_prod)
);


CREATE TABLE tb_produto (
                id_produto INTEGER NOT NULL,
                ean_13 VARCHAR NOT NULL,
                desc_prod VARCHAR NOT NULL,
                preco_unit_prod DOUBLE PRECISION NOT NULL,
                un_vend_prod VARCHAR NOT NULL,
                CONSTRAINT tb_produto_pk PRIMARY KEY (id_produto)
);


CREATE TABLE tb_cliente (
                cpf_cli VARCHAR NOT NULL,
                id_cliente INTEGER NOT NULL,
                nome_cli VARCHAR NOT NULL,
                endereco_cli VARCHAR NOT NULL,
                complemento_cli VARCHAR,
                cidade_cli VARCHAR NOT NULL,
                cep_cli VARCHAR NOT NULL,
                uf_cli VARCHAR NOT NULL,
                CONSTRAINT tb_cliente_pk PRIMARY KEY (cpf_cli)
);


CREATE TABLE db_header (
                nr_nf INTEGER NOT NULL,
                serie_nf VARCHAR NOT NULL,
                data_nf DATE NOT NULL,
                id_forma_pg INTEGER NOT NULL,
                cpf_cli VARCHAR NOT NULL,
                CONSTRAINT db_header_pk PRIMARY KEY (nr_nf)
);


CREATE TABLE tb_item (
                nr_nf INTEGER NOT NULL,
                id_produto INTEGER NOT NULL,
                qtd_item DOUBLE PRECISION NOT NULL,
                vlr_desc_item REAL NOT NULL,
                CONSTRAINT tb_item_pk PRIMARY KEY (nr_nf, id_produto)
);


CREATE TABLE tb_fone (
                id_fone VARCHAR NOT NULL,
                tp_fone VARCHAR NOT NULL,
                telefone VARCHAR NOT NULL,
                cpf_cli VARCHAR NOT NULL,
                CONSTRAINT tb_fone_pk PRIMARY KEY (id_fone)
);


ALTER TABLE db_header ADD CONSTRAINT tb_forma_pg_db_header_fk
FOREIGN KEY (id_forma_pg)
REFERENCES tb_forma_pg (id_forma_pg)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_produto ADD CONSTRAINT tb_unidade_tb_produto_fk
FOREIGN KEY (un_vend_prod)
REFERENCES tb_unidade (un_vend_prod)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_item ADD CONSTRAINT tb_produto_tb_item_fk
FOREIGN KEY (id_produto)
REFERENCES tb_produto (id_produto)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_fone ADD CONSTRAINT tb_cliente_tb_fone_fk
FOREIGN KEY (cpf_cli)
REFERENCES tb_cliente (cpf_cli)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE db_header ADD CONSTRAINT tb_cliente_db_header_fk
FOREIGN KEY (cpf_cli)
REFERENCES tb_cliente (cpf_cli)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

ALTER TABLE tb_item ADD CONSTRAINT db_header_tb_item_fk
FOREIGN KEY (nr_nf)
REFERENCES db_header (nr_nf)
ON DELETE NO ACTION
ON UPDATE NO ACTION
NOT DEFERRABLE;

-- Criação das tabelas:
CREATE TABLE cliente(
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    telefone BIGINT NOT NULL,
    email VARCHAR(100)
 );


CREATE TABLE produto(
	id SERIAL PRIMARY KEY,
	descricao VARCHAR(100) NOT NULL,
	valor NUMERIC(10, 2) NOT NULL,
	categoria VARCHAR NOT NULL
);

CREATE TABLE venda (
    id SERIAL PRIMARY KEY,
    observacao VARCHAR(100),
    data TIMESTAMP NOT NULL,
    valor DECIMAL(10,2) NOT NULL,
    cliente_id INTEGER NOT NULL,
    FOREIGN KEY (cliente_id) REFERENCES cliente(id)
);

CREATE TABLE itemvenda(
    id SERIAL PRIMARY KEY,
    quantidade INTEGER NOT NULL,
    valorunitario NUMERIC (10,2) NOT NULL,
    valortotal NUMERIC (10,2) NOT NULL,
    venda_id INTEGER NOT NULL,
    FOREIGN KEY (venda_id) REFERENCES venda(id),
    produto_id INTEGER NOT NULL,
    FOREIGN KEY (produto_id) REFERENCES produto(id)
 );
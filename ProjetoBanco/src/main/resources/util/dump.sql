create table produtos (
    id bigserial not null primary key,
    nome varchar(255) not null,
    valor double precision not null
);

CREATE TABLE categorias (
	id bigserial not null primary key,
	nome varchar(45) not null,
	ativo boolean default true
);

ALTER TABLE produtos
ADD column categoria_id bigint 


ALTER TABLE produtos
ADD FOREIGN KEY (categoria_id)
REFERENCES categorias(id);


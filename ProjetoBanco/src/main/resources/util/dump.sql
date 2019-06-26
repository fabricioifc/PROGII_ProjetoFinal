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

create table usuarios (
  id bigserial not null primary key,
  usuario varchar(255) not null,
  senha varchar(255) not null,
  nome varchar(255) not null,
  status boolean default true
);

insert into usuarios (usuario, senha, nome) values 
('admin', '21232F297A57A5A743894A0E4A801FC3', 'Admin');

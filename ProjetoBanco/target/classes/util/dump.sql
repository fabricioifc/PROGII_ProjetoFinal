create table produtos (
    id bigserial not null primary key,
    nome varchar(255) not null,
    valor double precision not null
);

create table clientes (
    id bigserial not null primary key,
    nome varchar(255) not null,
    cpf bigint,
    dtnascimento date
);
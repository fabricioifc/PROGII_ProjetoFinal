/**
 * Author:  fabricio
 * Created: May 21, 2019
 */
CREATE TABLE produtos (
    id bigserial not null primary key auto_increment,
    nome varchar(255) not null,
    valor double precision not null
);
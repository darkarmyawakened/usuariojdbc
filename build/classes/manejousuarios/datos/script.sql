
create database sistema;
use sistema;

create table usuario(
    id_usuario int not null auto_increment, 
    usuario varchar(40) not null,
    password varchar(30) not null, 
    primary key (id_usuario)
);
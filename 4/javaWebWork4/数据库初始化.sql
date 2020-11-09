DROP DATABASE IF EXISTS javaweb;
CREATE DATABASE javaweb;
use javaweb;
create table user_table
(
    id int not null auto_increment,
    name varchar(20) unique not null,
    password varchar(255) not null,
    email varchar(20),
    phone varchar(20),
    address varchar(255),
    primary key(id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8 ;
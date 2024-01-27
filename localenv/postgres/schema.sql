CREATE SCHEMA pruebatecnica;
create table pruebatecnica.spend(
id serial primary key,
name varchar(50),
last_name varchar(50),
phone_number BIGINT,
email varchar(50),
curp varchar(100),
rfc varchar(100),
name_task varchar(100),
description varchar(300),
initial_date TIMESTAMP,
end_date TIMESTAMP,
state varchar(100));
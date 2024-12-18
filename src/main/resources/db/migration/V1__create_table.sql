create table if not exists "user"
(
    id varchar(36) not null primary key,
    login varchar(100) not null unique,
    password varchar(200) not null
);
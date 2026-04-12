drop table if exists authorities;
drop table if exists users;

create table users (
    username varchar(100) primary key,
    password varchar(100) not null,
    enabled smallint default(1) not null
    -- ...
);

create table authorities (
    author_id serial primary key,
    username varchar(100) not null,
    authority varchar(100),
    -- ...
    foreign key (username) references users
);


-- ...
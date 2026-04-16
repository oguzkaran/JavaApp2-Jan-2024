drop table if exists member_roles;
drop table if exists members;

create table members (
    member_name varchar(100) primary key,
    password varchar(100) not null
    -- ...
);

create table member_roles (
    member_role_id bigserial primary key,
    member_name varchar(100) not null,
    role varchar(100),
    -- ...
    foreign key (member_name) references members
);


-- ...
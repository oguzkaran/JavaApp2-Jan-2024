drop table if exists member_roles;
drop table if exists members;
drop procedure if exists sp_insert_user;

create table members (
    member_name varchar(100) primary key,
    email varchar(200) not null unique,
    birth_date date default(current_date) not null,
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


create or replace procedure sp_insert_user(varchar(100), varchar(100), date, varchar(100), varchar(100))
language plpgsql
as '
begin
    insert into members (member_name, email, birth_date, password) values ($1, $2, $3, $4);
    insert into member_roles (member_name, role) values ($1, $5);
    commit;
end
';
-- ...
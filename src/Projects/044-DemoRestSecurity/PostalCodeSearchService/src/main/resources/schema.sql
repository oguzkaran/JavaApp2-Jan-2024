create table if not exists members (
    member_name varchar(100) primary key,
    email varchar(200) not null unique,
    birth_date date default(current_date) not null,
    password varchar(100) not null
    -- ...
);

create table if not exists member_roles (
    member_role_id bigserial primary key,
    member_name varchar(100) not null,
    role varchar(100),
    constraint uq_member_role unique (member_name, role),
    foreign key (member_name) references members
);


create or replace procedure sp_insert_user(varchar(100), varchar(100), date, varchar(100), varchar(100))
language plpgsql
as '
begin
    insert into members (member_name, email, birth_date, password)
    values ($1, $2, $3, $4)
    on conflict (member_name)
    do update set
        email      = excluded.email,
        birth_date = excluded.birth_date,
        password   = excluded.password;

    insert into member_roles (member_name, role)
    values ($1, $5)
    on conflict (member_name, role) do nothing;
    commit;
end
';


-- ...
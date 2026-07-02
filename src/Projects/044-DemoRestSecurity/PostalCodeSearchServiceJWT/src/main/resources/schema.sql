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

create or replace procedure sp_insert_user(varchar(100), varchar(100), date, varchar(100))
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
end
';

create or replace procedure sp_upsert_authority(varchar(100), varchar(100))
language plpgsql
as '
begin
    insert into member_roles (member_name, role)
    values ($1, $2)
    on conflict (member_name, role) do nothing;
end
';

create or replace procedure sp_insert_user_with_authority(varchar(100), varchar(100), date, varchar(100), varchar(100))
language plpgsql
as '
begin
    call sp_insert_user($1, $2, $3, $4);
    call sp_upsert_authority($1, $5);
    commit;
end
';

create or replace procedure sp_update_password(varchar(100), varchar(100))
language plpgsql
as '
begin
    update members set password=$2 where member_name = $1;
end
';

create or replace procedure sp_update_user(varchar(100), varchar(100), date)
language plpgsql
as '
begin
    update members set email = $2, birth_date = $3 where member_name = $1;
end
';

create or replace function find_user_by_username(varchar(100))
returns table (member_name varchar(100), email varchar(100), birth_date date)
as '
    begin
        return query select m.member_name, m.email, m.birth_date from members m where m.member_name = $1;
    end;
' language plpgsql;

create or replace function find_user_by_username_for_auth(varchar(100))
returns table (username varchar(100), password varchar(100), enabled boolean)
as '
    begin
        return query select m.member_name, m.password, true from members m where member_name = $1;
    end;
' language plpgsql;

create or replace function find_authorities_by_username(varchar(100))
returns table (role varchar(100))
as '
    begin
        return query select mr.role from member_roles mr where mr.member_name = $1;
    end;
' language plpgsql;

create or replace function find_authorities_by_username_for_auth(varchar(100))
returns table (username varchar(100), role varchar(100))
as '
    begin
        return query select mr.member_name, mr.role from member_roles mr where mr.member_name = $1;
    end;
' language plpgsql;

-- ...
create table if not exists server_info (
                                           id varchar(100) primary key,
    communication_info varchar(512) not null,
    connection_info varchar(512) not null,
    register_datetime timestamp default(current_timestamp) not null
    );

create table if not exists connections (
                                           connection_id bigserial primary key,
                                           connection_info varchar(512) not null,
    server_id varchar(100) references server_info(id) not null,
    connect_time timestamp default(current_timestamp) not null,
    disconnect_time timestamp
    );

truncate table connections restart identity;
truncate table server_info cascade;

drop function if exists find_server_by_id;

create or replace function find_server_by_id(varchar(100))
returns table (server_id varchar(100), com_info varchar(512), conn_info varchar(512), reg_datetime timestamp)
as
'
    begin
        return query select * from server_info where id = $1;
    end
' language plpgsql;

create or replace function save_connection(varchar(512), varchar(100))
returns bigint
as
'
    begin
        insert into connections (connection_info, server_id) values ($1, $2);

        return currval($$connections_connection_id_seq$$::regclass);
    end
' language plpgsql;



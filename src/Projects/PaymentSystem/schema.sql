create table if not exists server_info (
	id varchar(100) primary key,
	communication_info varchar(512) not null,
	connection_info varchar(512) not null,	
	register_datetime timestamp default(current_timestamp) not null
);

create table if not exists connections (
	connection_id bigserial primary key,
	connection_info varchar(512) not null,
	server_id varchar(100) references servers(id) not null,
	connect_time timestamp default(current_timestamp) not null,
	disconnect_time timestamp
);


-- create or replace procedure sp_insert_server_first_time()



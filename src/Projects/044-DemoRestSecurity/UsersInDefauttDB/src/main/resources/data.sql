insert into users (username, password, enabled) values ('admin', '{noop}admin', 1);
insert into authorities (username, authority) values ('admin', 'ROLE_ADMIN');

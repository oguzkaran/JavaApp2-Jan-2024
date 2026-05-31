insert into members (member_name, email, password)
values ('admin', 'admin@csystem.org', '$2y$10$8Y05sOsjZo.nUgqnFUZb2.mGO6YV6kGw/5Nm2GubNVNr9hzZkcwkC')
on conflict (member_name) do nothing;

insert into member_roles (member_name, role)
values ('admin', 'ROLE_ADMIN')
on conflict (member_name, role) do nothing;

insert into member_roles (member_name, role)
values ('admin', 'ROLE_USER')
on conflict (member_name, role) do nothing;
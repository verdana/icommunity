-- admin
-- insert into admin(id, name, password, true_name) values (1, 'admin', '96e79218965eb72c92a549dd5a330112', '管理员帐户');
-- insert into admin(id, name, password, true_name) values (2, 'guest', '96e79218965eb72c92a549dd5a330112', '来宾帐户');

INSERT INTO admin (id,name,password,true_name,state,create_time,version) VALUES (1,'root','$2a$10$lKjlSxG9E3QDUmJNcQHUceYe6JtjfGc46vqbg9UYgnqMEcSRgYz4C','Administrator',0,'2012-01-01 01:00:00',0);

-- admin_role
insert into role(id,name,permissions,create_time,version) values (1,'超级管理员','admin:read,admin:change,role:read,role:change','2012-01-01 01:00:00',0);

-- admin_x_role
insert into admin_x_role(admin_id, role_id) values (1, 1);

-- admin_permission
insert into permission(id,name,permit) values (1,'管理员访问','admin:read');
insert into permission(id,name,permit) values (2,'管理员修改','admin:change');
insert into permission(id,name,permit) values (3,'管理员权限访问','role:read');
insert into permission(id,name,permit) values (4,'管理员权限修改','role:change');

create database teamdb;

create table teams(
  id int(6) not null auto_increment,
  name varchar(40) not null,
  rating int(6) not NULL,
  primary key(id)
)  ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

create table users(
  username varchar(100) not null primary key,
  password varchar(100) not null,
  enabled boolean not null
);

create table authorities(
  username varchar(100) not null,
  authority varchar(50) not null,
  constraint fk_username_users
  foreign key(username) references users(username)
);

create unique index idx_username on authorities(username, authority);

insert into users values('naga',  'admin', true);
insert into users values('baba',  'admin', true);
insert into users values('varne',  'admin', true);
insert into authorities values('naga','ROLE_USER');
insert into authorities values('baba','ROLE_USER');
insert into authorities values('varne','ROLE_ADMIN');
insert into authorities values('naga','ROLE_ADMIN');

update users set password='$2a$10$cKSBEbhBtVjuUVvHra4Y9eGueyyR9llOEV8xFonM8UV3l41xLgBbq' where password='admin';


select count(*) from mysql.user where user = 'root' and authentication_string is null;

SELECT host, user, authentication_string FROM mysql.user;

--ALTER DATABASE PASSWORD
ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';

--ALTER TABLE CONSTRAINT
alter table clerk
add constraint uniquessn UNIQUE (ssn);


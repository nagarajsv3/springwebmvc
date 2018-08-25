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

select count(*) from mysql.user where user = 'root' and authentication_string is null;

SELECT host, user, authentication_string FROM mysql.user;

--ALTER DATABASE PASSWORD
ALTER USER 'root'@'localhost' IDENTIFIED BY 'root';

--ALTER TABLE CONSTRAINT
alter table clerk
add constraint uniquessn UNIQUE (ssn);
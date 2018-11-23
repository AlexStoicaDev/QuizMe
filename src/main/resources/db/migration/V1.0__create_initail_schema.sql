 drop table if exists hibernate_sequence
 drop table if exists role
 drop table if exists user
 drop table if exists user_role
 create table hibernate_sequence (next_val bigint) engine=MyISAM
 insert into hibernate_sequence values ( 1 )
 create table role (id integer not null auto_increment, name varchar(255), primary key (id)) engine=MyISAM
 create table user (id integer not null, email varchar(255), enabled bit, name varchar(255), password varchar(255), phone_number varchar(255), user_key varchar(255), primary key (id)) engine=MyISAM
 create table user_role (user_id integer not null, role_id integer not null) engine=MyISAM
 alter table role add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name)

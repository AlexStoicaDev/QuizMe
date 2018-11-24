drop table if exists event;
drop table if exists hibernate_sequence;
drop table if exists question;
drop table if exists quiz;
drop table if exists role;
drop table if exists app_user;
drop table if exists user_role;
create table event
(
  id integer not null,
  primary key (id)
);
create table hibernate_sequence
(
  next_val bigint
);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
insert into hibernate_sequence
values (1);
create table question
(
  dtype                     varchar(31) not null,
  id                        integer     not null,
  question_category         integer,
  question_sentence         varchar(255),
  question_difficulty_level integer,
  time_constraint           datetime,
  answers                   varchar(255),
  score                     integer,
  answer                    varchar(255),
  primary key (id)
);
create table quiz
(
  id integer not null,
  primary key (id)
);
create table role
(
  id   integer not null auto_increment,
  name varchar(255),
  primary key (id)
);
create table app_user

(
  id           integer not null,
  email        varchar(255),
  enabled      bit,
  name         varchar(255),
  password     varchar(255),
  phone_number varchar(255),
  user_key     varchar(255),
  primary key (id)
);
create table user_role
(
  user_id integer not null,
  role_id integer not null
);

alter table user_role
  add constraint FK_user_user_role foreign key (user_id) references app_user (id);
alter table user_role
  add constraint FK_role_user_role foreign key (role_id) references role (id);

insert into role (id, name)
values (1, 'ROLE_ADMIN');
insert into role(id, name)
values (2, 'ROLE_USER');

insert into app_user
  (id, email, phone_number, name, password, enabled)
values (999, 'alexandrupetrutstoica@gmail.com', null, 'admin',
        '$2a$10$LVbmdZk3w.hkUE0VdMdrYeuO1wNPgOW6LnRMHYF673rg/E2Y29vSy', true);





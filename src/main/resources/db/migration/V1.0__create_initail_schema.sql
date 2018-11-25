drop table if exists app_user;
drop table if exists event;
drop table if exists event_quiz;
drop table if exists event_user;
drop table if exists hibernate_sequence;
drop table if exists question;
drop table if exists quiz;
drop table if exists quiz_question;
drop table if exists role;
drop table if exists user_role;
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
create table event
(
  id                        integer not null,
  question_category         integer,
  question_difficulty_level integer,
  nr_of_quizzes             integer,
  nr_of_questions_per_quiz integer,
  primary key (id)
);
create table event_quiz
(
  event_id integer not null,
  quiz_id  integer not null
);
create table event_user
(
  event_id integer not null,
  user_id  integer not null
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
  question_difficulty_level integer,
  question_sentence         varchar(255),
  time_constraint           datetime,
  answers                   varchar(255),
  options                   varchar(255),
  score                     integer,
  answer                    varchar(255),
  primary key (id)
);
create table quiz
(
  id          integer not null,
  completed   bit     not null,
  total_score integer,
  primary key (id)
);
create table quiz_question
(
  quiz_id     integer not null,
  question_id integer not null
);
create table role
(
  id   integer not null auto_increment,
  name varchar(255),
  primary key (id)
);
create table user_role
(
  role_id integer not null,
  user_id integer not null
);
alter table role
  add constraint UK_8sewwnpamngi6b1dwaa88askk unique (name);


alter table event_quiz
  add constraint FKsyunjavmdt1thi9fykvaym044 foreign key (quiz_id) references quiz (id);
alter table event_quiz
  add constraint FK4u253q60wur8otlwggq784fjf foreign key (event_id) references event (id);
alter table event_user
  add constraint FKf0vp7avckk573ryiqgeea63xx foreign key (user_id) references app_user (id);
alter table event_user
  add constraint FKtc58o1e7bpugjcxuqr8l05l12 foreign key (event_id) references event (id);
alter table quiz_question
  add constraint FK62empq7vfu15qv1kci624f1js foreign key (question_id) references question (id);
alter table quiz_question
  add constraint FKdtynvfjgh6e7fd8l0wk37nrpc foreign key (quiz_id) references quiz (id);
alter table user_role
  add constraint FKg7fr1r7o0fkk41nfhnjdyqn7b foreign key (user_id) references app_user (id);
alter table user_role
  add constraint FKa68196081fvovjhkek5m97n3y foreign key (role_id) references role (id);


insert into role (id, name)
values (1, 'ROLE_ADMIN');
insert into role(id, name)
values (2, 'ROLE_USER');

insert into app_user
  (id, email, phone_number, name, password, enabled)
values (999, 'alexandrupetrutstoica@gmail.com', null, 'admin',
        '$2a$10$LVbmdZk3w.hkUE0VdMdrYeuO1wNPgOW6LnRMHYF673rg/E2Y29vSy', true);





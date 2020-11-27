create sequence s_accounts start 1 increment 1
create sequence s_business start 1 increment 1
create sequence s_city start 1 increment 1
create sequence s_employee start 1 increment 1
create sequence s_offer start 1 increment 1
create sequence s_term start 1 increment 1
create table account (id int8 not null, created timestamp, first_name varchar(255), last_name varchar(255), mail varchar(255), password varchar(255), phone varchar(255), strikes int4, primary key (id))
create table business (id int8 not null, address varchar(255), created timestamp, created_by varchar(255), latitude float4, longitude float4, mail varchar(255), min_interval varchar(255), name varchar(255), oib int8, phone varchar(255), rating float4, website varchar(255), city_id int8 not null, primary key (id))
create table city (id int8 not null, name varchar(255), postal_code int4, primary key (id))
create table employee (id int8 not null, created timestamp, created_by varchar(255), name varchar(255), title varchar(255), business_id int8 not null, primary key (id))
create table employee_offer_mapping (employee_id int8 not null, offer_id int8 not null, primary key (employee_id, offer_id))
create table offer (id int8 not null, created timestamp, created_by varchar(255), duration varchar(255), name varchar(255), price float4, business_id int8 not null, primary key (id))
create table term (id int8 not null, created timestamp, from_time timestamp, to_time timestamp, account_id int8, employee_id int8 not null, offer_id int8 not null, primary key (id))
alter table if exists business add constraint FKj03ss55615qnbwb7m5lbxr98c foreign key (city_id) references city
alter table if exists employee add constraint FKby2mxoe9cvixkcsckxqom6wft foreign key (business_id) references business
alter table if exists employee_offer_mapping add constraint FK32n3jc4v1qfaivn06xxc9xv6j foreign key (offer_id) references offer
alter table if exists employee_offer_mapping add constraint FKgi8ssjhssix3a5ekj9sw40c17 foreign key (employee_id) references employee
alter table if exists offer add constraint FK4oorn5b2bmd1e79r11keqh74x foreign key (business_id) references business
alter table if exists term add constraint FKrqu2q2u1jjojxvhloy7bfoqae foreign key (account_id) references account
alter table if exists term add constraint FK7c6aibok2quvl826hnoerqw3j foreign key (employee_id) references employee
alter table if exists term add constraint FKi9aj2wqr53w1xd1l64do8yup6 foreign key (offer_id) references offer

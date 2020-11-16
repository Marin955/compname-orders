create sequence s_business start 1 increment 1
create sequence s_service start 1 increment 1
create sequence s_term start 1 increment 1
create sequence s_users start 1 increment 1
create table business (id int8 not null, address varchar(255), city varchar(255), created timestamp, created_by varchar(255), latitude float4, longitude float4, mail varchar(255), name varchar(255), oib int8, phone varchar(255), postal_code int4, rating float4, website varchar(255), primary key (id))
create table service (id int8 not null, duration varchar(255), name varchar(255), business_id int8 not null, primary key (id))
create table term (id int8 not null, from timestamp, to timestamp, service_id int8 not null, user_id int8 not null, primary key (id))
create table user (id int8 not null, created timestamp, first_name varchar(255), last_name varchar(255), mail varchar(255), password varchar(255), phone varchar(255), strikes int4, primary key (id))
alter table if exists service add constraint FK22lnxqxohc8ofdjmfl0qcanoj foreign key (business_id) references business
alter table if exists term add constraint FKdpf2xpku0bpao3ljcp06941vg foreign key (service_id) references service
alter table if exists term add constraint FKktl98gic60ehb8miresv21f12 foreign key (user_id) references user
create sequence s_business start 1 increment 1
create sequence s_city start 1 increment 1
create sequence s_service start 1 increment 1
create sequence s_term start 1 increment 1
create sequence s_users start 1 increment 1
create table business (id int8 not null, address varchar(255), created timestamp, created_by varchar(255), latitude float4, longitude float4, mail varchar(255), min_interval varchar(255), name varchar(255), oib int8, phone varchar(255), rating float4, website varchar(255), city_id int8 not null, primary key (id))
create table city (id int8 not null, name varchar(255), postal_code varchar(255), primary key (id))
create table service (id int8 not null, created timestamp, created_by varchar(255), duration varchar(255), name varchar(255), price float4, business_id int8 not null, primary key (id))
create table term (id int8 not null, from timestamp, to timestamp, service_id int8 not null, user_id int8 not null, primary key (id))
create table user (id int8 not null, created timestamp, first_name varchar(255), last_name varchar(255), mail varchar(255), password varchar(255), phone varchar(255), strikes int4, primary key (id))
alter table if exists business add constraint FKj03ss55615qnbwb7m5lbxr98c foreign key (city_id) references city
alter table if exists service add constraint FK22lnxqxohc8ofdjmfl0qcanoj foreign key (business_id) references business
alter table if exists term add constraint FKdpf2xpku0bpao3ljcp06941vg foreign key (service_id) references service
alter table if exists term add constraint FKktl98gic60ehb8miresv21f12 foreign key (user_id) references user
create sequence s_business start 1 increment 1
create sequence s_city start 1 increment 1
create sequence s_service start 1 increment 1
create sequence s_term start 1 increment 1
create sequence s_users start 1 increment 1
create table business (id int8 not null, address varchar(255), created timestamp, created_by varchar(255), latitude float4, longitude float4, mail varchar(255), min_interval varchar(255), name varchar(255), oib int8, phone varchar(255), rating float4, website varchar(255), city_id int8 not null, primary key (id))
create table city (id int8 not null, name varchar(255), postal_code varchar(255), primary key (id))
create table service (id int8 not null, created timestamp, created_by varchar(255), duration varchar(255), name varchar(255), price float4, business_id int8 not null, primary key (id))
create table term (id int8 not null, from timestamp, to timestamp, service_id int8 not null, user_id int8 not null, primary key (id))
create table user (id int8 not null, created timestamp, first_name varchar(255), last_name varchar(255), mail varchar(255), password varchar(255), phone varchar(255), strikes int4, primary key (id))
alter table if exists business add constraint FKj03ss55615qnbwb7m5lbxr98c foreign key (city_id) references city
alter table if exists service add constraint FK22lnxqxohc8ofdjmfl0qcanoj foreign key (business_id) references business
alter table if exists term add constraint FKdpf2xpku0bpao3ljcp06941vg foreign key (service_id) references service
alter table if exists term add constraint FKktl98gic60ehb8miresv21f12 foreign key (user_id) references user
create sequence s_business start 1 increment 1
create sequence s_city start 1 increment 1
create sequence s_service start 1 increment 1
create sequence s_term start 1 increment 1
create sequence s_users start 1 increment 1
create table business (id int8 not null, address varchar(255), created timestamp, created_by varchar(255), latitude float4, longitude float4, mail varchar(255), min_interval varchar(255), name varchar(255), oib int8, phone varchar(255), rating float4, website varchar(255), city_id int8 not null, primary key (id))
create table city (id int8 not null, name varchar(255), postal_code varchar(255), primary key (id))
create table service (id int8 not null, created timestamp, created_by varchar(255), duration varchar(255), name varchar(255), price float4, business_id int8 not null, primary key (id))
create table term (id int8 not null, from timestamp, to timestamp, service_id int8 not null, user_id int8 not null, primary key (id))
create table user (id int8 not null, created timestamp, first_name varchar(255), last_name varchar(255), mail varchar(255), password varchar(255), phone varchar(255), strikes int4, primary key (id))
alter table if exists business add constraint FKj03ss55615qnbwb7m5lbxr98c foreign key (city_id) references city
alter table if exists service add constraint FK22lnxqxohc8ofdjmfl0qcanoj foreign key (business_id) references business
alter table if exists term add constraint FKdpf2xpku0bpao3ljcp06941vg foreign key (service_id) references service
alter table if exists term add constraint FKktl98gic60ehb8miresv21f12 foreign key (user_id) references user
create sequence s_business start 1 increment 1
create sequence s_city start 1 increment 1
create sequence s_service start 1 increment 1
create sequence s_term start 1 increment 1
create sequence s_users start 1 increment 1
create table business (id int8 not null, address varchar(255), created timestamp, created_by varchar(255), latitude float4, longitude float4, mail varchar(255), min_interval varchar(255), name varchar(255), oib int8, phone varchar(255), rating float4, website varchar(255), city_id int8 not null, primary key (id))
create table city (id int8 not null, name varchar(255), postal_code varchar(255), primary key (id))
create table service (id int8 not null, created timestamp, created_by varchar(255), duration varchar(255), name varchar(255), price float4, business_id int8 not null, primary key (id))
create table term (id int8 not null, from timestamp, to timestamp, service_id int8 not null, user_id int8 not null, primary key (id))
create table user (id int8 not null, created timestamp, first_name varchar(255), last_name varchar(255), mail varchar(255), password varchar(255), phone varchar(255), strikes int4, primary key (id))
alter table if exists business add constraint FKj03ss55615qnbwb7m5lbxr98c foreign key (city_id) references city
alter table if exists service add constraint FK22lnxqxohc8ofdjmfl0qcanoj foreign key (business_id) references business
alter table if exists term add constraint FKdpf2xpku0bpao3ljcp06941vg foreign key (service_id) references service
alter table if exists term add constraint FKktl98gic60ehb8miresv21f12 foreign key (user_id) references user
create sequence s_business start 1 increment 1
create sequence s_city start 1 increment 1
create sequence s_service start 1 increment 1
create sequence s_term start 1 increment 1
create sequence s_users start 1 increment 1
create table business (id int8 not null, address varchar(255), created timestamp, created_by varchar(255), latitude float4, longitude float4, mail varchar(255), min_interval varchar(255), name varchar(255), oib int8, phone varchar(255), rating float4, website varchar(255), city_id int8 not null, primary key (id))
create table city (id int8 not null, name varchar(255), postal_code varchar(255), primary key (id))
create table service (id int8 not null, created timestamp, created_by varchar(255), duration varchar(255), name varchar(255), price float4, business_id int8 not null, primary key (id))
create table term (id int8 not null, from timestamp, to timestamp, service_id int8 not null, user_id int8 not null, primary key (id))
create table user (id int8 not null, created timestamp, first_name varchar(255), last_name varchar(255), mail varchar(255), password varchar(255), phone varchar(255), strikes int4, primary key (id))
alter table if exists business add constraint FKj03ss55615qnbwb7m5lbxr98c foreign key (city_id) references city
alter table if exists service add constraint FK22lnxqxohc8ofdjmfl0qcanoj foreign key (business_id) references business
alter table if exists term add constraint FKdpf2xpku0bpao3ljcp06941vg foreign key (service_id) references service
alter table if exists term add constraint FKktl98gic60ehb8miresv21f12 foreign key (user_id) references user

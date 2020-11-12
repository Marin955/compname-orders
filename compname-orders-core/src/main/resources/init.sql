create schema public;

comment on schema public is 'standard public schema';

alter schema public owner to postgres;

create sequence s_business;

alter sequence s_business owner to postgres;

create sequence s_service;

alter sequence s_service owner to postgres;

create sequence s_term;

alter sequence s_term owner to postgres;

create sequence s_users;

alter sequence s_users owner to postgres;

create table business
(
    id                      bigint       not null
        constraint pk_business_id
            primary key,
    oib                     bigint      not null,
    name                    varchar(256) not null,
    created                 timestamp   not null,
    created_by               varchar(64) not null,
    city                    varchar(256) not null,
    postal_code              int         not null,
    address                 varchar(512) not null,
    longitude               float4      not null,
    latitude                float4      not null,
    phone                   varchar(64),
    mail                    varchar(256),
    website                 varchar(256),
    rating                  float4,
    min_interval            varchar(32)
);

alter table business
    owner to postgres;

create unique index uk_business_oib
    on business (oib);


create unique index uk_business_id
    on business (id);

create table service
(
    id          bigint       not null
        constraint pk_service_id
            primary key,
    business_id bigint      not null
        constraint fk_service_business_id
            references business
            on delete cascade,
    name        varchar(256)    not null,
    duration    varchar(32)
);

alter table service
    owner to postgres;

create unique index uk_service_business_id_name
    on service (business_id, name);

create unique index uk_service_id
    on service (id);

create table "user"
(
    id          bigint       not null
        constraint pk_user_id
            primary key,
    created     timestamp   not null,
    first_name   varchar(256)    not null,
    last_name    varchar(256)    not null,
    mail        varchar(512),
    password    varchar(512)    not null,
    phone       varchar(64)     not null,
    strikes     int             not null
);

alter table "user"
    owner to postgres;

create unique index uk_user_id
    on "user" (id);

create table term
(
    id          bigint          not null
        constraint pk_term_id
            primary key,
    service_id  bigint          not null
        constraint fk_term_service_id
            references service
            on delete cascade,
    user_id     bigint          not null
        constraint fk_term_user_id
            references "user"
            on delete cascade,

    "from"        timestamp       not null,
    "to"          timestamp       not null
);

alter table term
    owner to postgres;

create unique index uk_term_id
    on term (id);
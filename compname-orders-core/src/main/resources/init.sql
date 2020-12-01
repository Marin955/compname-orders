create schema public;

comment on schema public is 'standard public schema';

alter schema public owner to postgres;

create sequence s_business;

alter sequence s_business owner to postgres;

create sequence s_offer;

alter sequence s_offer owner to postgres;

create sequence s_term;

alter sequence s_term owner to postgres;

create sequence s_users;

alter sequence s_users owner to postgres;

create sequence s_city;

alter sequence s_city owner to postgres;

create table extendedCity
(
    id                      bigint       not null
        constraint pk_city_id
            primary key,
    name                    varchar(256) not null,
    postal_code             int
);

alter table extendedCity
    owner to postgres;

create unique index uk_city_name
    on extendedCity (name);

create table business
(
    id                      bigint       not null
        constraint pk_business_id
            primary key,
    oib                     bigint      not null,
    name                    varchar(256) not null,
    created                 timestamp   not null,
    created_by              varchar(64) not null,
    city_id                 bigint      not null
        constraint fk_business_city_id
            references extendedCity
            on delete cascade,
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

create table offer
(
    id          bigint       not null
        constraint pk_offer_id
            primary key,
    business_id bigint      not null
        constraint fk_offer_business_id
            references business
            on delete cascade,
    name        varchar(256)    not null,
    created                 timestamp   not null,
    created_by               varchar(64) not null,
    price               float4,
    duration    varchar(32)
);

alter table offer
    owner to postgres;

create unique index uk_offer_business_id_name
    on offer (business_id, name);

create unique index uk_offer_id
    on offer (id);

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
    offer_id  bigint          not null
        constraint fk_term_offer_id
            references offer
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
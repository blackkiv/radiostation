--liquibase formatted sql
--changeset lagolini:01

create table host
(
    id           uuid primary key default gen_random_uuid(),
    name         text not null,
    cv           json not null,
    starting_day date,
    invited      bool not null    default false
);

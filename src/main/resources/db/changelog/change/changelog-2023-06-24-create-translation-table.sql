--liquibase formatted sql
--changeset lagolini:01

create table translation
(
    id       uuid primary key default gen_random_uuid(),
    duration numeric not null
);

create table translation_part
(
    id                uuid primary key default gen_random_uuid(),
    translation_id    uuid    not null,
    host_id           uuid    not null,
    type              text    not null,
    duration          numeric not null,
    translation_order int     not null,
    data              jsonb   not null,
    constraint fk_translation foreign key (translation_id) references translation (id) on delete cascade,
    constraint fk_host foreign key (host_id) references host (id) on delete cascade
);

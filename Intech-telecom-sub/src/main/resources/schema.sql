create table purchase
(
    id bigint generated by default as identity
        constraint purchase_pkey primary key,
    message_id bigint,
    msisdn     bigint,
    timestamp  bigint
);

create table subscription
(
    id bigint generated by default as identity
        constraint purchase_pkey primary key,
    message_id bigint,
    msisdn     bigint,
    timestamp  bigint
);
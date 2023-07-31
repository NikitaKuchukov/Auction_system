-- liquibase formatted sql


-- changeset test:1
CREATE TABLE bid
(
    id          SERIAL PRIMARY KEY,
    bidder_name VARCHAR(255) not null ,
    bid_date    timestamp not null,
    lot         INT
);
-- liquibase formatted sql


-- changeset test:1
CREATE TABLE lot
(
    id          SERIAL PRIMARY KEY,
    status      VARCHAR(10) DEFAULT 'CREATED' NOT NULL,
    title       VARCHAR(64) CHECK ( LENGTH(title) > 1 ),
    description VARCHAR(4096) CHECK ( LENGTH(description) > 1 ),
    start_price INT CHECK ( start_price > 1 ),
    bid_price   INT CHECK ( bid_price > 1 ),
    bid_list    INT REFERENCES bid (id)

);
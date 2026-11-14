--liquibase formatted sql

--changeset training:002
ALTER TABLE payment_cards
    RENAME COLUMN experation_date TO expiration_date;
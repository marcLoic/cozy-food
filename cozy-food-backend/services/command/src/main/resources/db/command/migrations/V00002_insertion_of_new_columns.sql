--liquibase formatted sql

--changeset dtn1999:adding_of_columns_deleted_created_at_updated_at
--comment: Insertion of new columns

ALTER TABLE command
    ADD COLUMN deleted BOOLEAN DEFAULT FALSE,
    ADD COLUMN created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    ADD COLUMN updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP;

--rollback ALTER TABLE command DROP COLUMN deleted, DROP COLUMN create_at, DROP COLUMN updated_at;


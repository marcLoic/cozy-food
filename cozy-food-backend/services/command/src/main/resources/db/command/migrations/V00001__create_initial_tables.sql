--liquibase formatted sql

--changeset dtn1999:create_initial_tables
DROP TABLE IF EXISTS COMMAND;

--comment: Table command

CREATE TABLE COMMAND
(
    id                      BIGSERIAL    NOT NULL,
    description             VARCHAR(255) NOT NULL,
    quantity                INTEGER NOT NULL,
    date_of_command         TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    account_id              BIGSERIAL       NOT NULL,

--  Constraints
    PRIMARY KEY (id)
);

--rollback DROP TABLE COMMAND;


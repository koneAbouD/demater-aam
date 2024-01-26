CREATE TABLE IF NOT EXISTS marital_status (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(255) NOT NULL UNIQUE,
    name                    VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE marital_status_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE marital_status ADD CONSTRAINT UC_marital_status_code UNIQUE (code);
ALTER TABLE marital_status ADD CONSTRAINT UC_marital_status_name UNIQUE (name);
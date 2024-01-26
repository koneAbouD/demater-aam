CREATE TABLE IF NOT EXISTS account_type (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(255) NOT NULL UNIQUE,
    name                    VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE account_type_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE account_type ADD CONSTRAINT UC_account_type_code UNIQUE (code);
ALTER TABLE account_type ADD CONSTRAINT UC_account_type_name UNIQUE (name);
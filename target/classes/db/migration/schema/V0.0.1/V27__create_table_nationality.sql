CREATE TABLE IF NOT EXISTS nationality (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(255) NOT NULL UNIQUE,
    name                    VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE nationality_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE nationality ADD CONSTRAINT UC_nationality_code UNIQUE (code);
ALTER TABLE nationality ADD CONSTRAINT UC_nationality_name UNIQUE (name);
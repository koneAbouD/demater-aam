CREATE TABLE IF NOT EXISTS legal_capacity (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(255) NOT NULL UNIQUE,
    name                    VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE legal_capacity_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE legal_capacity ADD CONSTRAINT UC_legal_capacity_code UNIQUE (code);
ALTER TABLE legal_capacity ADD CONSTRAINT UC_legal_capacity_name UNIQUE (name);
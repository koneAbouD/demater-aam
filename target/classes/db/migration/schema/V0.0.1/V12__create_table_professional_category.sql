CREATE TABLE IF NOT EXISTS professional_category (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(255) NOT NULL UNIQUE,
    name                    VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE professional_category_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE professional_category ADD CONSTRAINT UC_professional_category_code UNIQUE (code);
ALTER TABLE professional_category ADD CONSTRAINT UC_professional_category_name UNIQUE (name);
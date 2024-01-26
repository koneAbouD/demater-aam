CREATE TABLE IF NOT EXISTS category_professional (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(255) NOT NULL UNIQUE,
    name                    VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE category_professional_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE category_professional ADD CONSTRAINT UC_category_professional_code UNIQUE (code);
ALTER TABLE category_professional ADD CONSTRAINT UC_category_professional_name UNIQUE (name);
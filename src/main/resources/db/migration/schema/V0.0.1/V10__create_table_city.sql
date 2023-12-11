CREATE TABLE IF NOT EXISTS city (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(255) NOT NULL,
    designation             VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE city_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE city ADD CONSTRAINT UC_city_code UNIQUE (code);
ALTER TABLE city ADD CONSTRAINT UC_city_designation UNIQUE (designation);
CREATE TABLE IF NOT EXISTS position (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(10) NOT NULL UNIQUE,
    designation             VARCHAR(255) NOT NULL UNIQUE,
    description             TEXT,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE position_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE position ADD CONSTRAINT UC_position_code UNIQUE (code);
ALTER TABLE position ADD CONSTRAINT UC_position_designation UNIQUE (designation);

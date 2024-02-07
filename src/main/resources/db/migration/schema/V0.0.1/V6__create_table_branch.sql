CREATE TABLE IF NOT EXISTS branch (
    id                      INT8 NOT NULL PRIMARY KEY,
    code                    VARCHAR(255) NOT NULL UNIQUE,
    name                    VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE branch_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE branch ADD CONSTRAINT UC_branch_code UNIQUE (code);
ALTER TABLE branch ADD CONSTRAINT UC_branch_name UNIQUE (name);
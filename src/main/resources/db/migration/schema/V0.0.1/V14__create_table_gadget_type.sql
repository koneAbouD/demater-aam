CREATE TABLE IF NOT EXISTS gadget_type (
    id                      INT8 NOT NULL PRIMARY KEY,
    designation             VARCHAR(255) NOT NULL UNIQUE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE SEQUENCE gadget_type_id_seq MINVALUE 1 START WITH 1 INCREMENT BY 1;
ALTER TABLE gadget_type ADD CONSTRAINT UC_gadget_type_designation UNIQUE (designation);

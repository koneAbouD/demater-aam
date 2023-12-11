CREATE TABLE IF NOT EXISTS gadget (
    id                          uuid NOT NULL PRIMARY KEY,
    designation                 VARCHAR(255) NOT NULL,
    gadget_type_id              INT8 NOT NULL,
    description                 TEXT,
    details                     TEXT,
    total_number                INT8 DEFAULT 0,
    remaining_number            INT8 DEFAULT 0,
    is_available                BOOLEAN NOT NULL DEFAULT TRUE,
    created_timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE gadget ADD CONSTRAINT FK_gadget_on_gadget_type FOREIGN KEY (gadget_type_id) REFERENCES gadget_type (id);
ALTER TABLE gadget ADD CONSTRAINT UC_gadget_on_designation UNIQUE (designation);

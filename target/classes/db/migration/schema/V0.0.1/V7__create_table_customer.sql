CREATE TABLE IF NOT EXISTS customer (
    id                      uuid NOT NULL PRIMARY KEY,
    first_name              VARCHAR(255) NOT NULL,
    last_names              VARCHAR(255) NOT NULL,
    mather_full_names       VARCHAR(255) NOT NULL,
    num_telephone           VARCHAR(255) NOT NULL,
    email                   VARCHAR(255) NOT NULL,
    code                    VARCHAR(255) NOT NULL,
    level_student           VARCHAR(255) NOT NULL,
    nationality_id          INT8 NOT NULL,
    language_id             INT8 NOT NULL,
    address_id              uuid NOT NULL,
    legal_capacity_id       INT8 NOT NULL,
    customer_type_id        INT8 NOT NULL,
    family_status_id        INT8 NOT NULL,
    marital_status_id       INT8 NOT NULL,
    is_activate             BOOLEAN NOT NULL DEFAULT TRUE,
    is_delete               BOOLEAN NOT NULL DEFAULT FALSE,
    activation_date         TIMESTAMP WITHOUT TIME ZONE,
    delete_date             TIMESTAMP WITHOUT TIME ZONE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE customer ADD CONSTRAINT UC_customer_code UNIQUE (code);
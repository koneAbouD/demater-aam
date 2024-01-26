CREATE TABLE IF NOT EXISTS employer (
    id                      uuid NOT NULL PRIMARY KEY,
    name                    VARCHAR(255) NOT NULL,
    num_telephone           VARCHAR(255) NOT NULL,
    email                   VARCHAR(255) NOT NULL,
    address                 VARCHAR(255) NOT NULL,
    employer_type_id        INT8 NOT NULL,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
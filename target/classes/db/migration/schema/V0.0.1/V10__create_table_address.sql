CREATE TABLE IF NOT EXISTS address (
    id                      uuid NOT NULL PRIMARY KEY,
    type                    VARCHAR(255) NOT NULL,
    city                    VARCHAR(255) NOT NULL,
    county                  VARCHAR(255) NOT NULL,
    description             VARCHAR(255) NOT NULL,
    postal_code             VARCHAR(255) NOT NULL,
    country_id              INT8 NOT NULL,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
CREATE TABLE IF NOT EXISTS account (
    id                      uuid NOT NULL PRIMARY KEY,
    business_key            VARCHAR(255) NOT NULL,
    designation             VARCHAR(255) NOT NULL,
    code                    VARCHAR(255) NOT NULL,
    status                  VARCHAR(255) NOT NULL,
    account_type_id         INT8 NOT NULL,
    customer_id             uuid NOT NULL,
    branch_id               INT8 NOT NULL,
    is_activate             BOOLEAN NOT NULL DEFAULT TRUE,
    is_delete               BOOLEAN NOT NULL DEFAULT FALSE,
    activation_date         TIMESTAMP WITHOUT TIME ZONE,
    delete_date             TIMESTAMP WITHOUT TIME ZONE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE account ADD CONSTRAINT UC_account_business_key UNIQUE (business_key);
ALTER TABLE account ADD CONSTRAINT UC_account_code UNIQUE (code);
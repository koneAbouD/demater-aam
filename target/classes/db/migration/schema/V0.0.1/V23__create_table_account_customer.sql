CREATE TABLE IF NOT EXISTS account_customer (
    account_id                          uuid NOT NULL,
    customer_id                         uuid NOT NULL,
    created_timestamp                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE account_customer ADD CONSTRAINT FK_account_customer_on_account FOREIGN KEY (account_id) REFERENCES account (id);
ALTER TABLE account_customer ADD CONSTRAINT FK_account_customer_on_document FOREIGN KEY (customer_id) REFERENCES customer (id);


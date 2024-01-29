CREATE TABLE IF NOT EXISTS customer_profession (
    customer_id                         uuid NOT NULL,
    profession_id                       uuid NOT NULL,
    created_timestamp                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE customer_profession ADD CONSTRAINT FK_customer_profession_on_customer FOREIGN KEY (customer_id) REFERENCES customer (id);
ALTER TABLE customer_profession ADD CONSTRAINT FK_customer_profession_on_profession FOREIGN KEY (profession_id) REFERENCES profession (id);


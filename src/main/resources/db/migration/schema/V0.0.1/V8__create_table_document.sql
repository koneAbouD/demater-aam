CREATE TABLE IF NOT EXISTS document (
    id                      uuid NOT NULL PRIMARY KEY,
    business_key            VARCHAR(255) NOT NULL,
    designation             VARCHAR(255) NOT NULL,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE document ADD CONSTRAINT UC_document_business_key UNIQUE (business_key);
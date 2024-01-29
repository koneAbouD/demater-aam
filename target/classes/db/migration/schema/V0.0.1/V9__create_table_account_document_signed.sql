CREATE TABLE IF NOT EXISTS account_document_signed (
    account_id                          uuid NOT NULL,
    document_id                         uuid NOT NULL,
    created_timestamp                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE account_document_signed ADD CONSTRAINT FK_account_document_signed_on_account FOREIGN KEY (account_id) REFERENCES account (id);
ALTER TABLE account_document_signed ADD CONSTRAINT FK_account_document_signed_on_document FOREIGN KEY (document_id) REFERENCES document (id);


CREATE TABLE IF NOT EXISTS users (
    id                      uuid NOT NULL PRIMARY KEY,
    login                   VARCHAR(255) NOT NULL,
    first_name              VARCHAR(255) NOT NULL,
    last_name               VARCHAR(255) NOT NULL,
    email                   VARCHAR(255) NOT NULL,
    is_valid                BOOLEAN NOT NULL DEFAULT FALSE,
    password                VARCHAR(255) NOT NULL,
    confirmation_token      TEXT NOT NULL,
    access_token            TEXT,
    refresh_token           TEXT,
    is_activate             BOOLEAN NOT NULL DEFAULT FALSE,
    activation_date         TIMESTAMP WITHOUT TIME ZONE,
    expiration_date         TIMESTAMP WITHOUT TIME ZONE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE users ADD CONSTRAINT UC_users_login UNIQUE (login);
ALTER TABLE users ADD CONSTRAINT UC_users_email UNIQUE (email);
ALTER TABLE users ADD CONSTRAINT UC_users_confirmation_token UNIQUE (confirmation_token);
CREATE TABLE IF NOT EXISTS profession (
    id                          uuid NOT NULL PRIMARY KEY,
    designation                 VARCHAR(255) NOT NULL,
    hire_date                   DATE NOT NULL,
    income                      FLOAT NOT NULL,
    employer_id                 uuid NOT NULL,
    professional_category_id    INT8 NOT NULL,
    created_timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
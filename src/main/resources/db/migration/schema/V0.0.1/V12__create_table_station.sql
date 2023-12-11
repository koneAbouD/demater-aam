CREATE TABLE IF NOT EXISTS station (
    id                      uuid NOT NULL PRIMARY KEY,
    designation             VARCHAR(255) NOT NULL,
    city_id                 INT8 NOT NULL,
    address                 VARCHAR(255) NOT NULL,
    cost_center             VARCHAR(255) NOT NULL,
    status                  VARCHAR(30) NOT NULL,
    is_deleted              BOOLEAN NOT NULL DEFAULT FALSE,
    created_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp       TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE station ADD CONSTRAINT FK_station_on_city FOREIGN KEY (city_id) REFERENCES city (id);
ALTER TABLE station ADD CONSTRAINT UC_station_on_designation_city UNIQUE (designation, city_id);

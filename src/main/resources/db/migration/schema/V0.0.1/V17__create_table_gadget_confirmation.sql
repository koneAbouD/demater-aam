CREATE TABLE IF NOT EXISTS gadget_confirmation (
    id                          uuid NOT NULL PRIMARY KEY,
    station_gadget_id           uuid NOT NULL,
    gadget_number_received      INT8 NOT NULL DEFAULT 0,
    integration_date            TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    status                      VARCHAR(20) NOT NULL,
    confirmation_date           TIMESTAMP WITHOUT TIME ZONE,
    user_id                     uuid,
    created_timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE gadget_confirmation ADD CONSTRAINT FK_gadget_confirmation_on_station_gadget FOREIGN KEY (station_gadget_id) REFERENCES station_gadget (id);
ALTER TABLE gadget_confirmation ADD CONSTRAINT FK_gadget_confirmation_on_user FOREIGN KEY (user_id) REFERENCES users (id);

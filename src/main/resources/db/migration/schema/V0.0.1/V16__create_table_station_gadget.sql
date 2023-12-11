CREATE TABLE IF NOT EXISTS station_gadget (
    id                                  uuid NOT NULL PRIMARY KEY,
    station_id                          uuid NOT NULL,
    gadget_id                           uuid NOT NULL,
    gadget_number                       INT8 NOT NULL DEFAULT 0,
    created_timestamp                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_timestamp                   TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP
);
ALTER TABLE station_gadget ADD CONSTRAINT FK_station_gadget_on_station FOREIGN KEY (station_id) REFERENCES station (id);
ALTER TABLE station_gadget ADD CONSTRAINT FK_station_gadget_on_gadget FOREIGN KEY (gadget_id) REFERENCES gadget (id);
ALTER TABLE station_gadget ADD CONSTRAINT UC_station_gadget_station_gadget UNIQUE (station_id, gadget_id);


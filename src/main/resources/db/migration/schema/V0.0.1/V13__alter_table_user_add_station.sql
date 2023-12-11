ALTER TABLE users ADD COLUMN station_id uuid;
ALTER TABLE users ADD CONSTRAINT FK_users_on_station FOREIGN KEY (station_id) REFERENCES station (id);

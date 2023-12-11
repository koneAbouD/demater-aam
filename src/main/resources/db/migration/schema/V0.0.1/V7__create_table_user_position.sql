CREATE TABLE IF NOT EXISTS user_position (
      user_id                           uuid NOT NULL,
      position_id                       INT8 NOT NULL,
      created_timestamp                 TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
      updated_timestamp                 TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
      CONSTRAINT pk_user_position       PRIMARY KEY (user_id, position_id)
);
ALTER TABLE user_position ADD CONSTRAINT fk_user_position_on_user FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE user_position ADD CONSTRAINT fk_user_position_on_position FOREIGN KEY (position_id) REFERENCES position (id);

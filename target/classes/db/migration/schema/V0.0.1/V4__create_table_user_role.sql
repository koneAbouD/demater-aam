CREATE TABLE IF NOT EXISTS user_role (
      user_id                     uuid NOT NULL,
      role_id                     INT8 NOT NULL,
      created_timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
      updated_timestamp           TIMESTAMP WITHOUT TIME ZONE NOT NULL DEFAULT CURRENT_TIMESTAMP,
      CONSTRAINT pk_user_role     PRIMARY KEY (user_id, role_id)
);
ALTER TABLE user_role ADD CONSTRAINT fk_user_role_on_user FOREIGN KEY (user_id) REFERENCES users (id);
ALTER TABLE user_role ADD CONSTRAINT fk_user_role_on_role FOREIGN KEY (role_id) REFERENCES roles (id);

INSERT INTO legal_capacity (id, code, name)
VALUES
    (nextval('legal_capacity_id_seq'), '1', 'Capable'),
    (nextval('legal_capacity_id_seq'), '2', 'Incapable majeur'),
    (nextval('legal_capacity_id_seq'), '3', 'Mineur'),
    (nextval('legal_capacity_id_seq'), '4', 'Mineur émancipé'),
    (nextval('legal_capacity_id_seq'), '5', 'Indéterminé');
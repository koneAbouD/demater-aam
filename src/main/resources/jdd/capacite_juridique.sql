INSERT INTO capacite_juridique (id, code, name)
VALUES
    (nextval('capacite_juridique_id_seq'), '', ''),
    (nextval('capacite_juridique_id_seq'), '1', 'Capable'),
    (nextval('capacite_juridique_id_seq'), '2', 'Incapable majeur'),
    (nextval('capacite_juridique_id_seq'), '3', 'Mineur'),
    (nextval('capacite_juridique_id_seq'), '4', 'Mineur émancipé'),
    (nextval('capacite_juridique_id_seq'), '5', 'Indéterminé');
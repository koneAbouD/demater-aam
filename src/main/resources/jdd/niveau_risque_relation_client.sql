INSERT INTO niveau_risque_relation_client (id, code, name)
VALUES
    (nextval('niveau_risque_relation_client_id_seq'), '', ''),
    (nextval('niveau_risque_relation_client_id_seq'), '01', 'Excellent'),
    (nextval('niveau_risque_relation_client_id_seq'), '02', 'BON CLIENT'),
    (nextval('niveau_risque_relation_client_id_seq'), '03', 'NORMAL'),
    (nextval('niveau_risque_relation_client_id_seq'), '04', 'CLIENT A SUVEILLER'),
    (nextval('niveau_risque_relation_client_id_seq'), '05', 'MAUVAIS CLIENT');
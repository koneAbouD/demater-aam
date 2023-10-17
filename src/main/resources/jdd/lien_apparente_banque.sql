INSERT INTO lien_apparente_banque (id, code, name)
VALUES
    (nextval('lien_apparente_banque_id_seq'), '', ''),
    (nextval('lien_apparente_banque_id_seq'), '1', 'Actionnaire détenant individuel'),
    (nextval('lien_apparente_banque_id_seq'), '2', 'Membre organe délibérant'),
    (nextval('lien_apparente_banque_id_seq'), '3', 'Membre organe exécutif'),
    (nextval('lien_apparente_banque_id_seq'), '4', 'Commissaire aux comptes'),
    (nextval('lien_apparente_banque_id_seq'), '5', 'Personnel de direction'),
    (nextval('lien_apparente_banque_id_seq'), '6', 'Cadre moyen et supérieur'),
    (nextval('lien_apparente_banque_id_seq'), '7', "Personnel d'exécution"),
    (nextval('lien_apparente_banque_id_seq'), '8', 'Autres parties liées'),
    (nextval('lien_apparente_banque_id_seq'), '9', 'Aucun lien avec la banque');

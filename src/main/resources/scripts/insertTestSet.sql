INSERT INTO jeu (titre, description, reference, tarifJournee, ageMin, duree) VALUES
('Catan', 'Jeu de stratégie où les joueurs collectent des ressources et construisent des colonies.', 'REF001', 15.50, 10, 90),
('Dixit', 'Jeu d’ambiance et d’imagination basé sur des cartes illustrées.', 'REF002', 10.00, 8, 30),
('Pandemic', 'Jeu coopératif où les joueurs travaillent ensemble pour arrêter une pandémie.', 'REF003', 20.00, 12, 60),
('7 Wonders', 'Jeu de stratégie avec des cartes et des civilisations antiques.', 'REF004', 18.00, 10, 45),
('Time’s Up', 'Jeu d’ambiance où les joueurs font deviner des personnages célèbres.', 'REF005', 12.00, 8, 40);

INSERT INTO jeu_genre (numeroJeu, numeroGenre)
SELECT j.numeroJeu, g.numeroGenre
FROM jeu j
JOIN genre g ON g.libelle = 'jeu de plateau'
WHERE j.titre = 'Catan';

INSERT INTO jeu_genre (numeroJeu, numeroGenre)
SELECT j.numeroJeu, g.numeroGenre
FROM jeu j
JOIN genre g ON g.libelle = 'jeu d’ambiance'
WHERE j.titre = 'Dixit';

INSERT INTO jeu_genre (numeroJeu, numeroGenre)
SELECT j.numeroJeu, g.numeroGenre
FROM jeu j
JOIN genre g ON g.libelle = 'coopératif'
WHERE j.titre = 'Pandemic';

INSERT INTO jeu_genre (numeroJeu, numeroGenre)
SELECT j.numeroJeu, g.numeroGenre
FROM jeu j
JOIN genre g ON g.libelle = 'jeu de plateau'
WHERE j.titre = '7 Wonders';

INSERT INTO jeu_genre (numeroJeu, numeroGenre)
SELECT j.numeroJeu, g.numeroGenre
FROM jeu j
JOIN genre g ON g.libelle = 'jeu d’ambiance'
WHERE j.titre = 'Time’s Up';

INSERT INTO client (nom, prenom, email, rue, codepostal, ville, telephone) VALUES
('Dupont', 'Jean', 'jean.dupont@example.com', '12 rue des Lilas', '75001', 'Paris', '0123456789'),
('Martin', 'Claire', 'claire.martin@example.com', '34 avenue de la République', '69001', 'Lyon', '0456789012'),
('Bernard', 'Luc', 'luc.bernard@example.com', '56 boulevard Haussmann', '33000', 'Bordeaux', '0654321098'),
('Petit', 'Sophie', 'sophie.petit@example.com', '78 rue de la Paix', '13001', 'Marseille', '0743210987'),
('Durand', 'Paul', 'paul.durand@example.com', '90 place Bellecour', '31000', 'Toulouse', '0678901234'),
('Leroy', 'Julie', 'julie.leroy@example.com', '45 chemin des Fleurs', '44000', 'Nantes', '0556677889'),
('Moreau', 'Thomas', 'thomas.moreau@example.com', '67 allée des Chênes', '67000', 'Strasbourg', '0498765432'),
('Simon', 'Emma', 'emma.simon@example.com', '89 impasse du Soleil', '59000', 'Lille', '0387654321'),
('Michel', 'Lucas', 'lucas.michel@example.com', '23 place de la Victoire', '80000', 'Amiens', '0765432198'),
('Roux', 'Alice', 'alice.roux@example.com', '101 rue Saint-Lazare', '34000', 'Montpellier', '0658901234');

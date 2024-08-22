create database atletik_db;


USE atletik_db;

INSERT INTO discipline (name, approx_duration) VALUES ('100m Sprint', 10);
INSERT INTO discipline (name, approx_duration) VALUES ('Long Jump', 20);
INSERT INTO discipline (name, approx_duration) VALUES ('High Jump', 15);
INSERT INTO discipline (name, approx_duration) VALUES ('Pole Vault', 25);
INSERT INTO discipline (name, approx_duration) VALUES ('Shot Put', 30);
INSERT INTO discipline (name, approx_duration) VALUES ('Javelin Throw', 35);
INSERT INTO discipline (name, approx_duration) VALUES ('Discus Throw', 30);
INSERT INTO discipline (name, approx_duration) VALUES ('Hammer Throw', 40);
INSERT INTO discipline (name, approx_duration) VALUES ('400m Hurdles', 45);
INSERT INTO discipline (name, approx_duration) VALUES ('1500m Run', 150);


INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Straight', 'Synthetic', 100, '6', 1);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Sand', 30, '0', 2);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Grass', 20, '0', 3);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Grass', 20, '0', 4);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Oval', 'Grass', 15, '0', 5);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Grass', 50, '0', 6);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Oval', 'Grass', 25, '0', 7);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Oval', 'Grass', 40, '0', 8);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 9);
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 1500, '8', 10);


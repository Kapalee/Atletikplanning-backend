-- Create the database
CREATE DATABASE atletik_db;

-- Use the database
USE atletik_db;

-- Insert disciplines
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
-- New disciplines
INSERT INTO discipline (name, approx_duration) VALUES ('Triple Jump', 25);
INSERT INTO discipline (name, approx_duration) VALUES ('200m Sprint', 20);
INSERT INTO discipline (name, approx_duration) VALUES ('800m Run', 90);
INSERT INTO discipline (name, approx_duration) VALUES ('400m Relay', 40);
INSERT INTO discipline (name, approx_duration) VALUES ('Steeplechase', 180);

-- Insert tracks
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

-- New tracks associated with multiple disciplines
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Straight', 'Synthetic', 200, '8', 11);  -- Triple Jump
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Straight', 'Synthetic', 200, '8', 12);  -- 200m Sprint
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 13);      -- 800m Run
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 14);      -- 400m Relay
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 3000, '8', 15);     -- Steeplechase

-- Tracks shared by multiple disciplines
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 12); -- 200m Sprint
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 13); -- 800m Run
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 14); -- 400m Relay

-- TimeSlots
INSERT INTO time_slot (start_time, end_time, date) VALUES (900, 1000, '2023-10-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1000, 1100, '2023-10-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1100, 1200, '2023-10-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1200, 1300, '2023-10-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1300, 1400, '2023-10-01');
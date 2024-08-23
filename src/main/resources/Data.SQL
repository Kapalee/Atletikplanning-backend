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
INSERT INTO discipline (name, approx_duration) VALUES ('400m Relay', 40);
INSERT INTO discipline (name, approx_duration) VALUES ('1500m Run', 150);
INSERT INTO discipline (name, approx_duration) VALUES ('200m Sprint', 20);
INSERT INTO discipline (name, approx_duration) VALUES ('800m Run', 90);

-- Track Type, Shape, Surface, Length, Lanes, Discipline ID
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Straight', 'Synthetic', 100, '6', 1); -- 100m Sprint
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Sand', 30, '0', 2); -- Long Jump
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Grass', 20, '0', 3); -- High Jump
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Grass', 20, '0', 4); -- Pole Vault
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Oval', 'Grass', 15, '0', 5); -- Shot Put
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Grass', 50, '0', 6); -- Javelin Throw
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 7); -- 400m Relay
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 1500, '8', 8); -- 1500m Run
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Straight', 'Synthetic', 200, '8', 9); -- 200m Sprint
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 10); -- 800m Run

-- Additional Tracks for multiple disciplines
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Straight', 'Synthetic', 200, '8', 9); -- 200m Sprint
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 10); -- 800m Run
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Track', 'Oval', 'Synthetic', 400, '8', 7); -- 400m Relay
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Straight', 'Grass', 50, '0', 6); -- Javelin Throw
INSERT INTO track (type, shape, surface, length, lanes, discipline_id) VALUES ('Field', 'Oval', 'Grass', 15, '0', 5); -- Shot Put

-- Timeslot format: Start Time, End Time, Date
INSERT INTO time_slot (start_time, end_time, date) VALUES (900, 1000, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1000, 1100, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1100, 1200, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1200, 1300, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1300, 1400, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1400, 1500, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1500, 1600, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1600, 1700, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1700, 1800, '2024-09-01');
INSERT INTO time_slot (start_time, end_time, date) VALUES (1800, 1900, '2024-09-01');

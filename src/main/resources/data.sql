INSERT INTO user(user_id, name, email) VALUES (1, 'Debbie Harry', 'blondie@privatestock.com');
INSERT INTO event (event_id, name, location, cost, date) VALUES (2, 'party', 'my house', 3.50, '20200101');
INSERT INTO user_event(user_id, event_id) VALUES (1, 2);
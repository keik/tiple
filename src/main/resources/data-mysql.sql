INSERT INTO user (id, name, email, password) VALUES ("alice", "Alice", "alice@example.net", "alice");
INSERT INTO user (id, name, email, password) VALUES ("bob", "Bob", "bob@example.net", "bob");
INSERT INTO user (id, name, email, password) VALUES ("carol", "Carol", "carol@example.net", "carol");

INSERT INTO question (title, content, created_by) VALUES ("What is JavaScript?", "some contents.", "alice");
INSERT INTO question (title, content, created_by) VALUES ("What is Node?",       "some contents.", "bob");
INSERT INTO question (title, content, created_by) VALUES ("What is Java?",       "some contents.", "carol");

INSERT INTO tag (name) VALUES ("javascript");
INSERT INTO tag (name) VALUES ("node");
INSERT INTO tag (name) VALUES ("java");

INSERT INTO question_tag (question_id, tag_id) VALUES ("1", "1");
INSERT INTO question_tag (question_id, tag_id) VALUES ("2", "1");
INSERT INTO question_tag (question_id, tag_id) VALUES ("2", "2");
INSERT INTO question_tag (question_id, tag_id) VALUES ("3", "3");

INSERT INTO answer (answer_for, content, created_by) VALUES ("1", "I don''t know.",     "bob");
INSERT INTO answer (answer_for, content, created_by) VALUES ("2", "I don''t know.",     "alice");
INSERT INTO answer (answer_for, content, created_by) VALUES ("2", "I don''t know too.", "carol");
INSERT INTO answer (answer_for, content, created_by) VALUES ("3", "I don''t know",      "bob");
INSERT INTO answer (answer_for, content, created_by) VALUES ("3", "I don''t know too.", "alice");
INSERT INTO answer (answer_for, content, created_by) VALUES ("3", "I know.",            "carol");

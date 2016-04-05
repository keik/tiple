SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS
  user,
  question,
  tag,
  question_tag,
  answer,
  vote_for_question,
  vote_for_answer;
SET FOREIGN_KEY_CHECKS=1;

CREATE TABLE user (
  id       VARCHAR(32)  NOT NULL,
  name     VARCHAR(255),
  email    VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE question (
  id          INTEGER        NOT NULL AUTO_INCREMENT,
  title       VARCHAR(255)   NOT NULL,
  content     VARCHAR(10000) NOT NULL,
  views_count INTEGER        DEFAULT 0 NOT NULL,
  created_by  VARCHAR(32)    NOT NULL,
  created_at  DATETIME       DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (created_by) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE tag (
  id   INTEGER      NOT NULL AUTO_INCREMENT,
  name VARCHAR(255) NOT NULL UNIQUE,
  PRIMARY KEY (id)
);

CREATE TABLE question_tag (
  id          INTEGER NOT NULL AUTO_INCREMENT,
  question_id INTEGER NOT NULL,
  tag_id      INTEGER NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE answer (
  id          INTEGER        NOT NULL AUTO_INCREMENT,
  answer_for  INTEGER        NOT NULL,
  content     VARCHAR(10000) NOT NULL,
  created_by  VARCHAR(32)    NOT NULL,
  created_at  DATETIME       DEFAULT CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (answer_for) REFERENCES question(id) ON DELETE CASCADE,
  FOREIGN KEY (created_by) REFERENCES user(id) ON DELETE CASCADE
);

CREATE TABLE vote_for_question (
  id         INTEGER     NOT NULL AUTO_INCREMENT,
  vote_for   INTEGER     NOT NULL,
  created_by VARCHAR(32) NOT NULL,
  value      INTEGER     NOT NULL,
  FOREIGN KEY (vote_for)   REFERENCES question(id) ON DELETE CASCADE,
  FOREIGN KEY (created_by) REFERENCES user(id)     ON DELETE CASCADE,
  UNIQUE (vote_for, created_by),
  PRIMARY KEY (id)
);

CREATE TABLE vote_for_answer (
  id         INTEGER     NOT NULL AUTO_INCREMENT,
  vote_for   INTEGER     NOT NULL,
  created_by VARCHAR(32) NOT NULL,
  value      INTEGER     NOT NULL,
  FOREIGN KEY (vote_for)   REFERENCES answer(id) ON DELETE CASCADE,
  FOREIGN KEY (created_by) REFERENCES user(id)   ON DELETE CASCADE,
  UNIQUE (vote_for, created_by),
  PRIMARY KEY (id)
);

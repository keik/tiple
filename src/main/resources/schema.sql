CREATE TABLE IF NOT EXISTS user (
  id VARCHAR(32) NOT NULL,
  name VARCHAR(255) NOT NULL UNIQUE,
  email VARCHAR(255) NOT NULL UNIQUE,
  password VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
);

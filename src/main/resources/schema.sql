CREATE TABLE employee (
    id      int AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(128) NOT NULL,
    phone   VARCHAR(128),
    address VARCHAR(256)
);

CREATE TABLE users (
    username VARCHAR(128) PRIMARY KEY,
    password VARCHAR(500) NOT NULL,
    enabled BOOLEAN NOT NULL
);

CREATE TABLE authorities (
    username VARCHAR(50) NOT NULL,
    authority VARCHAR(50) NOT NULL,
    CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);

CREATE UNIQUE INDEX ix_auth_username ON authorities (username, authority);
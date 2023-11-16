CREATE TABLE employee (
    id      int AUTO_INCREMENT PRIMARY KEY,
    name    VARCHAR(128) NOT NULL,
    phone   VARCHAR(128),
    address VARCHAR(256)
);

create table users(username varchar_ignorecase(50) not null primary key,password varchar_ignorecase(500) not null,enabled boolean not null);
create table authorities (username varchar_ignorecase(50) not null,authority varchar_ignorecase(50) not null,constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);
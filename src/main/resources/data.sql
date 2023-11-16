INSERT INTO employee(name, phone, address) VALUES('홍길동', '010-1111-1111', '경기도 수원시 영통구 삼성로 129');
INSERT INTO employee(name, phone, address) VALUES('홍길순', '010-1111-1112', '경기도 수원시 영통구 삼성로 129');
INSERT INTO employee(name, phone, address) VALUES('홍길철', '010-1111-1113', '서울시 영등포구 여의대로 128 LG트윈타워');
INSERT INTO employee(name, phone, address) VALUES('홍길자', '010-1111-1114', '서울시 영등포구 여의대로 128 LG트윈타워');

INSERT INTO users(username, password, enabled) VALUES('user1', '$2a$12$GByM3ieI3XW7EEwJnKP/HO/nRnOQxCbC7py/G7x.nGd1GJjsQzXZS', true);
INSERT INTO users(username, password, enabled) VALUES('user2', '$2a$12$GByM3ieI3XW7EEwJnKP/HO/nRnOQxCbC7py/G7x.nGd1GJjsQzXZS', true);
INSERT INTO users(username, password, enabled) VALUES('user3', '$2a$12$GByM3ieI3XW7EEwJnKP/HO/nRnOQxCbC7py/G7x.nGd1GJjsQzXZS', true);
INSERT INTO authorities(username, authority) VALUES('user1', 'ROLE_EMPLOYEE');
INSERT INTO authorities(username, authority) VALUES('user1', 'ROLE_PRODUCT');
INSERT INTO authorities(username, authority) VALUES('user2', 'ROLE_PRODUCT');
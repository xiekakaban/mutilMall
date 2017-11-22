/***create */

CREATE TABLE tb_user
(
  id VARCHAR(50) PRIMARY KEY NOT NULL,
  username VARCHAR(100) NOT NULL UNIQUE ,
  phone VARCHAR(20),
  sex VARCHAR(1),
  pwd VARCHAR(100) NOT NULL,
  avator VARCHAR(50) DEFAULT 'default.jpg',
  birthday DATETIME,
  location VARCHAR(20),
  email VARCHAR(200),
  create_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  last_modify_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
  extern_info LONGTEXT
);

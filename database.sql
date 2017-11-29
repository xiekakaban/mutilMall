create table tb_user
(
  id int auto_increment
    primary key,
  username varchar(100) not null,
  pwd varchar(50) not null,
  avatar varchar(50) default 'default.jpg' null,
  email varchar(100) not null,
  phone varchar(20) null,
  location varchar(20) null,
  last_modify_time datetime default CURRENT_TIMESTAMP not null,
  create_time datetime default CURRENT_TIMESTAMP not null,
  constraint tb_user_username_uindex
  unique (username)
)
;

INSERT INTO multi_mall.tb_user (username, pwd, avatar, email, phone, location, last_modify_time, create_time) VALUES ('xiekakaban', 'testuser', '''default.jpg''', 'ruantianbo@163.com', '15158041141', null, '2017-11-29 13:39:36', '2017-11-29 13:39:36');
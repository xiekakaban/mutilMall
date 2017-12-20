create table tb_category
(
  id int auto_increment
    primary key,
  title varchar(100) not null,
  description varchar(200) null,
  content text null,
  create_time datetime not null,
  last_modify_time datetime not null,
  constraint category_title_uindex
  unique (title)
)
;

create table tb_category_tag
(
  id int auto_increment
    primary key,
  tag_name varchar(100) not null,
  category_id int null,
  create_time datetime not null,
  last_modify_time datetime not null,
  constraint tb_category_tag_tag_name_uindex
  unique (tag_name),
  constraint tb_category_tag_tb_category_id_fk
  foreign key (category_id) references tb_category (id)
    on update cascade on delete cascade
)
;

create index tb_category_tag_tb_category_id_fk
  on tb_category_tag (category_id)
;

create table tb_product
(
  id int auto_increment
    primary key,
  title varchar(200) not null,
  price double not null,
  content text null,
  is_tao_bao varchar(2) null,
  link varchar(300) null,
  category_id int null,
  create_time datetime not null,
  last_modify_time datetime not null,
  constraint tb_product_title_uindex
  unique (title),
  constraint tb_product_tb_category_id_fk
  foreign key (category_id) references tb_category (id)
    on update cascade on delete cascade
)
;

create index tb_product_tb_category_id_fk
  on tb_product (category_id)
;

create table tb_product_tag
(
  id int auto_increment
    primary key,
  tag_name varchar(20) not null,
  product_id int not null,
  create_time datetime not null,
  last_modify_time datetime not null,
  constraint tb_product_tag_tb_product_id_fk
  foreign key (product_id) references tb_product (id)
    on update cascade on delete cascade
)
;

create index tb_product_tag_tb_product_id_fk
  on tb_product_tag (product_id)
;

create table tb_user
(
  id int auto_increment
    primary key,
  username varchar(100) not null,
  pwd varchar(50) not null,
  avatar varchar(50) not null,
  email varchar(100) not null,
  phone varchar(20) null,
  location varchar(20) null,
  last_modify_time datetime not null,
  create_time datetime not null,
  constraint tb_user_username_uindex
  unique (username),
  constraint tb_user_email_uindex
  unique (email)
)
;


INSERT INTO multi_mall.tb_category (title, description, content, create_time, last_modify_time) VALUES ('手机', '这里没有内容', '这里没有简介', '2017-12-20 18:12:47', '2017-12-20 18:12:50');
INSERT INTO multi_mall.tb_user (username, pwd, avatar, email, phone, location, last_modify_time, create_time) VALUES ('tianyeling', 'nihaoma', 'nihao.jpg', 'tianyeling@163.com', '13645857110', null, '2017-12-13 16:52:51', '2017-12-13 15:49:22');
INSERT INTO multi_mall.tb_product (title, price, content, is_tao_bao, link, category_id, create_time, last_modify_time) VALUES ('一加3手机荣耀登场，走过路过不要错过,+99换赠酸枝保护套', 0, '看看不要钱', 'y', 'www.google.com', 1, '2017-12-20 18:12:36', '2017-12-20 18:12:41');
INSERT INTO multi_mall.tb_category_tag (tag_name, category_id, create_time, last_modify_time) VALUES ('2017新款', 1, '2017-12-20 13:22:13', '2017-12-20 13:22:19');
INSERT INTO multi_mall.tb_category_tag (tag_name, category_id, create_time, last_modify_time) VALUES ('8848钛金属手机', 1, '2017-12-20 15:01:20', '2017-12-20 15:01:20');


use testdb;

CREATE TABLE player (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(100) NOT NULL,
  no varchar(100) NOT NULL,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into player (name,no) values('James','23');
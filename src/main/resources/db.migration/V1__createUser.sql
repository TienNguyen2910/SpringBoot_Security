CREATE TABLE IF NOT EXISTS `user`(
   userid int AUTO_INCREMENT primary key,
   username varchar(40) null,
   email varchar(20) not null,
   password varchar(50) not null
);
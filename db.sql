CREATE TABLE User_Dictionary (
  user_id       int(11) NOT NULL, 
  dictionary_id int(11) NOT NULL, 
  PRIMARY KEY (user_id, 
  dictionary_id));
CREATE TABLE Dictionary (
  id         int(11) NOT NULL AUTO_INCREMENT, 
  name       varchar(30), 
  owner      int(11) NOT NULL, 
  language_1 varchar(100) NOT NULL, 
  language_2 varchar(100) NOT NULL, 
  max_score  float, 
  best_time  time, 
  PRIMARY KEY (id));
CREATE TABLE `User` (
  id           int(11) NOT NULL AUTO_INCREMENT, 
  first_name   varchar(50), 
  second_name  varchar(50), 
  nick         varchar(50), 
  email        varchar(100), 
  password     varchar(100), 
  sign_up_date date, 
  status       varchar(50) NOT NULL, 
  PRIMARY KEY (id));
ALTER TABLE Dictionary ADD INDEX FKDictionary640034 (owner), ADD CONSTRAINT FKDictionary640034 FOREIGN KEY (owner) REFERENCES `User` (id);
ALTER TABLE User_Dictionary ADD INDEX FKUser_Dicti617124 (dictionary_id), ADD CONSTRAINT FKUser_Dicti617124 FOREIGN KEY (dictionary_id) REFERENCES Dictionary (id);
ALTER TABLE User_Dictionary ADD INDEX FKUser_Dicti811741 (user_id), ADD CONSTRAINT FKUser_Dicti811741 FOREIGN KEY (user_id) REFERENCES `User` (id);
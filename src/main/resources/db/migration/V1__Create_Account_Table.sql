CREATE TABLE account(
  id BIGINT NOT NULL AUTO_INCREMENT,
  email varchar(45) NOT NULL,
  full_name varchar(45) NOT NULL,
  password  varchar(45) NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY email_UNIQUE  (`email`));


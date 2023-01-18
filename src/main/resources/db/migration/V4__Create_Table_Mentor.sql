CREATE TABLE mentor(
  id BIGINT NOT NULL AUTO_INCREMENT,
  mentor_rank varchar(45) NOT NULL,
 PRIMARY KEY (`id`),
 UNIQUE KEY mentor_rank_UNIQUE  (`mentor_rank`));
CREATE TABLE student(
  id BIGINT NOT NULL AUTO_INCREMENT,
   student_level varchar(45) NOT NULL,
 PRIMARY KEY (`id`),
  UNIQUE KEY student_level_UNIQUE  (`student_level`));
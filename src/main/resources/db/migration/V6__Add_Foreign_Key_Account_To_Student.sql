ALTER TABLE student
ADD CONSTRAINT FK_student_account
FOREIGN KEY (account) REFERENCES account (id);
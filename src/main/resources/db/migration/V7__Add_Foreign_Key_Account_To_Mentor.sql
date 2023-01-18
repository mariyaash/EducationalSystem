ALTER TABLE mentor
ADD CONSTRAINT FK_mentor_account
FOREIGN KEY (account) REFERENCES account (id);
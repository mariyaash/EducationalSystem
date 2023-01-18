ALTER TABLE task
ADD CONSTRAINT FK_task_mentor
FOREIGN KEY (mentor_id) REFERENCES mentor (id);
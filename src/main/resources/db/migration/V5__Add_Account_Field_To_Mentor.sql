ALTER TABLE mentor
ADD account BIGINT UNIQUE AFTER mentor_rank;
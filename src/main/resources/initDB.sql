DROP TABLE IF EXISTS students1;
DROP SEQUENCE IF EXISTS glob_seq_stud1;

CREATE SEQUENCE glob_seq_stud1 START 1000;

CREATE TABLE students1 (
  id          INTEGER PRIMARY KEY DEFAULT nextval('glob_seq_stud1'),
  age         INTEGER,
  name        VARCHAR NOT NULL,
  createdDate TIMESTAMP           DEFAULT now(),
  isAdmin     BOOL                DEFAULT FALSE
)
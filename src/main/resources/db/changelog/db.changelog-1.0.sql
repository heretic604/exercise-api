CREATE SCHEMA IF NOT EXISTS "public";

CREATE
SEQUENCE "public".exercise_seq START
WITH 1 INCREMENT BY 1;

CREATE TABLE "public".exercise
(
    exercise_id   serial NOT NULL,
    exercise_name varchar(100),
    set_count     integer,
    repetition    integer,
    exercise_date date,
    CONSTRAINT pk_exercise PRIMARY KEY (exercise_id)
);

COMMENT ON TABLE "public".exercise IS 'Упражнения';

COMMENT ON COLUMN "public".exercise.exercise_id IS 'ID упражнения';
COMMENT ON COLUMN "public".exercise.exercise_name IS 'Название упражнения';
COMMENT ON COLUMN "public".exercise.set_count IS 'Количество подходов';
COMMENT ON COLUMN "public".exercise.repetition IS 'Количество повторений в одном подходе';
COMMENT ON COLUMN "public".exercise.exercise_date IS 'Дата выполнения';
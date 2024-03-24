CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE IF NOT EXISTS "public".strength_exercise
(
    strength_exercise_id   bigserial NOT NULL,
    strength_exercise_name varchar(100),
    set_count     integer,
    repetition    integer,
    strength_exercise_date date,
    CONSTRAINT pk_exercise PRIMARY KEY (strength_exercise_id)
);

COMMENT ON TABLE "public".strength_exercise IS 'Силовые упражнения';

COMMENT ON COLUMN "public".strength_exercise.strength_exercise_id IS 'ID силового упражнения';
COMMENT ON COLUMN "public".strength_exercise.strength_exercise_name IS 'Название силового упражнения';
COMMENT ON COLUMN "public".strength_exercise.set_count IS 'Количество подходов';
COMMENT ON COLUMN "public".strength_exercise.repetition IS 'Количество повторений в одном подходе';
COMMENT ON COLUMN "public".strength_exercise.strength_exercise_date IS 'Дата выполнения силового упражнения';
CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE IF NOT EXISTS "public".exercise
(
    exercise_id bigserial NOT NULL,
    exercise_name_id bigint  NOT NULL,
    set_count        integer NOT NULL,
    repetition       integer NOT NULL,
    exercise_date    date    NOT NULL,
    CONSTRAINT pk_exercise PRIMARY KEY (exercise_id)
);

CREATE TABLE IF NOT EXISTS "public".exercise_name
(
    exercise_name_id bigserial NOT NULL,
    exercise_name varchar(100) UNIQUE NOT NULL,
    CONSTRAINT pk_exercise_name PRIMARY KEY (exercise_name_id)
);

ALTER TABLE "public".exercise
    ADD CONSTRAINT fk_exercise_name FOREIGN KEY (exercise_name_id) REFERENCES "public".exercise_name (exercise_name_id);

COMMENT ON TABLE "public".exercise IS 'Силовые упражнения';
COMMENT ON COLUMN "public".exercise.exercise_id IS 'ID силового упражнения';
COMMENT ON COLUMN "public".exercise.exercise_name_id IS 'Название силового упражнения';
COMMENT ON COLUMN "public".exercise.set_count IS 'Количество подходов';
COMMENT ON COLUMN "public".exercise.repetition IS 'Количество повторений в одном подходе';
COMMENT ON COLUMN "public".exercise.exercise_date IS 'Дата выполнения силового упражнения';

COMMENT ON TABLE "public".exercise_name IS 'Названия силовых упражнений';
COMMENT ON COLUMN "public".exercise_name.exercise_name_id IS 'ID названия силового упражнения';
COMMENT ON COLUMN "public".exercise_name.exercise_name IS 'Название силового упражнения';
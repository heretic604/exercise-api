CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE IF NOT EXISTS "public".strength_exercise
(
    strength_exercise_id bigserial NOT NULL,
    strength_exercise_name_id bigint  NOT NULL,
    set_count                 integer NOT NULL,
    repetition                integer NOT NULL,
    strength_exercise_date    date    NOT NULL,
    CONSTRAINT pk_strength_exercise PRIMARY KEY (strength_exercise_id)
);

CREATE TABLE IF NOT EXISTS "public".strength_exercise_name
(
    strength_exercise_name_id bigserial NOT NULL,
    strength_exercise_name varchar(100) UNIQUE NOT NULL,
    CONSTRAINT pk_strength_exercise_name PRIMARY KEY (strength_exercise_name_id)
);

ALTER TABLE "public".strength_exercise ADD CONSTRAINT fk_strength_exercise_name FOREIGN KEY (strength_exercise_name_id) REFERENCES "public".strength_exercise_name (strength_exercise_name_id);

COMMENT ON TABLE "public".strength_exercise IS 'Силовые упражнения';
COMMENT ON COLUMN "public".strength_exercise.strength_exercise_id IS 'ID силового упражнения';
COMMENT ON COLUMN "public".strength_exercise.strength_exercise_name_id IS 'Название силового упражнения';
COMMENT ON COLUMN "public".strength_exercise.set_count IS 'Количество подходов';
COMMENT ON COLUMN "public".strength_exercise.repetition IS 'Количество повторений в одном подходе';
COMMENT ON COLUMN "public".strength_exercise.strength_exercise_date IS 'Дата выполнения силового упражнения';

COMMENT ON TABLE "public".strength_exercise_name IS 'Названия силовых упражнений';
COMMENT ON COLUMN "public".strength_exercise_name.strength_exercise_name_id IS 'ID названия силового упражнения';
COMMENT ON COLUMN "public".strength_exercise_name.strength_exercise_name IS 'Название силового упражнения';

CREATE SCHEMA IF NOT EXISTS "public";

CREATE TABLE IF NOT EXISTS "public".exercise
(
    exercise_id BIGSERIAL NOT NULL,
    exercise_name_id BIGINT  NOT NULL,
    set_count        INTEGER NOT NULL,
    repetition       INTEGER NOT NULL,
    exercise_date    DATE    NOT NULL,
    CONSTRAINT pk_exercise PRIMARY KEY (exercise_id)
);

CREATE TABLE IF NOT EXISTS "public".exercise_name
(
    exercise_name_id bigserial NOT NULL,
    exercise_name VARCHAR(100) UNIQUE NOT NULL,
    CONSTRAINT pk_exercise_name PRIMARY KEY (exercise_name_id)
);

CREATE TABLE IF NOT EXISTS "public".jogging
(
    jogging_id bigserial NOT NULL,
    jogging_date        DATE          NOT NULL,
    meters              INTEGER       NOT NULL,
    jogging_time        TIME          NOT NULL,
    meters_per_minute   DOUBLE precision NOT NULL,
    kilometers_per_hour DOUBLE precision NOT NULL,
    CONSTRAINT pk_jogging PRIMARY KEY (jogging_id)
);

ALTER TABLE "public".exercise
    ADD CONSTRAINT fk_exercise_name FOREIGN KEY (exercise_name_id) REFERENCES "public".exercise_name (exercise_name_id);

COMMENT ON TABLE "public".exercise IS 'Exercises table';
COMMENT ON TABLE "public".exercise_name IS 'Exercises name table';
COMMENT ON TABLE "public".jogging IS 'Jogging table';
-- Created by Redgate Data Modeler (https://datamodeler.redgate-platform.com)
-- Last modification date: 2025-12-13 08:58:38.79

-- tables
-- Table: category
CREATE TABLE category
(
    id   int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    name varchar(100)                                    NOT NULL,
    CONSTRAINT id PRIMARY KEY (id)
);

-- Table: equipment_type
CREATE TABLE equipment_type
(
    id   int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    name varchar(100)                                    NOT NULL,
    CONSTRAINT equipment_type_pk PRIMARY KEY (id)
);

-- Table: exercise
CREATE TABLE exercise
(
    id                int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    name              varchar(100)                                    NOT NULL,
    description       longvarchar(5000)                               NULL,
    category_id       int                                             NOT NULL,
    muscle_group_id   int                                             NOT NULL,
    equipment_type_id int                                             NOT NULL,
    created_at        timestamp                                       NOT NULL,
    CONSTRAINT exercise_pk PRIMARY KEY (id)
);

-- Table: exercise_set
CREATE TABLE exercise_set
(
    id                  int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    workout_exercise_id int                                             NOT NULL,
    set_type_id         int                                             NOT NULL,
    set_number          int                                             NOT NULL,
    weight_kg           decimal(5, 2)                                   NULL,
    reps                int                                             NOT NULL,
    rpe                 int                                             NULL,
    notes               longvarchar(2000)                               NULL,
    completed           boolean                                         NOT NULL,
    CONSTRAINT exercise_set_pk PRIMARY KEY (id)
);

-- Table: muscle_group
CREATE TABLE muscle_group
(
    id   int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    name varchar(100)                                    NOT NULL,
    CONSTRAINT muscle_group_pk PRIMARY KEY (id)
);

-- Table: set_type
CREATE TABLE set_type
(
    id   int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    name varchar(100)                                    NOT NULL,
    CONSTRAINT set_type_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id         int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    username   varchar(50)                                     NOT NULL,
    email      varchar(100)                                    NOT NULL,
    password   varchar(255)                                    NOT NULL,
    created_at timestamp                                       NOT NULL,
    updated_at timestamp                                       NOT NULL,
    CONSTRAINT username UNIQUE (username),
    CONSTRAINT email UNIQUE (email),
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: workout
CREATE TABLE workout
(
    id               int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    user_id          int                                             NOT NULL,
    name             varchar(100)                                    NOT NULL,
    "date"           date                                            NULL,
    start_time       time                                            NULL,
    end_time         time                                            NULL,
    duration_minutes int                                             NULL,
    notes            longvarchar(2000)                               NULL,
    created_at       timestamp                                       NOT NULL,
    CONSTRAINT workout_pk PRIMARY KEY (id)
);

-- Table: workout_exercise
CREATE TABLE workout_exercise
(
    id          int GENERATED ALWAYS AS IDENTITY (START WITH 1) NOT NULL,
    workout_id  int                                             NOT NULL,
    exercise_id int                                             NOT NULL,
    order_index int                                             NOT NULL,
    notes       longvarchar(2000)                               NOT NULL,
    CONSTRAINT workout_exercise_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: exercise_category (table: exercise)
ALTER TABLE exercise
    ADD CONSTRAINT exercise_category
        FOREIGN KEY (category_id)
            REFERENCES category (id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT;

-- Reference: exercise_equipment_type (table: exercise)
ALTER TABLE exercise
    ADD CONSTRAINT exercise_equipment_type
        FOREIGN KEY (equipment_type_id)
            REFERENCES equipment_type (id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT;

-- Reference: exercise_muscle_group (table: exercise)
ALTER TABLE exercise
    ADD CONSTRAINT exercise_muscle_group
        FOREIGN KEY (muscle_group_id)
            REFERENCES muscle_group (id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT;

-- Reference: exercise_set_set_type (table: exercise_set)
ALTER TABLE exercise_set
    ADD CONSTRAINT exercise_set_set_type
        FOREIGN KEY (set_type_id)
            REFERENCES set_type (id)
            ON DELETE RESTRICT
            ON UPDATE RESTRICT;

-- Reference: exerciseset_workoutexercise (table: exercise_set)
ALTER TABLE exercise_set
    ADD CONSTRAINT exerciseset_workoutexercise
        FOREIGN KEY (workout_exercise_id)
            REFERENCES workout_exercise (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

-- Reference: user_workout (table: workout)
ALTER TABLE workout
    ADD CONSTRAINT user_workout
        FOREIGN KEY (user_id)
            REFERENCES "user" (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

-- Reference: workoutexercise_exercise (table: workout_exercise)
ALTER TABLE workout_exercise
    ADD CONSTRAINT workoutexercise_exercise
        FOREIGN KEY (exercise_id)
            REFERENCES exercise (id)
            ON DELETE RESTRICT
            ON UPDATE CASCADE;

-- Reference: workoutexercise_workout (table: workout_exercise)
ALTER TABLE workout_exercise
    ADD CONSTRAINT workoutexercise_workout
        FOREIGN KEY (workout_id)
            REFERENCES workout (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;

-- End of file.


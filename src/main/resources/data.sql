-- Lookup table inserts (must be inserted first due to foreign key constraints)

-- category table inserts
INSERT INTO category (name)
VALUES ('Strength');
INSERT INTO category (name)
VALUES ('Cardio');
INSERT INTO category (name)
VALUES ('Flexibility');

-- muscle_group table inserts
INSERT INTO muscle_group (name)
VALUES ('Legs');
INSERT INTO muscle_group (name)
VALUES ('Chest');
INSERT INTO muscle_group (name)
VALUES ('Back');
INSERT INTO muscle_group (name)
VALUES ('Shoulders');
INSERT INTO muscle_group (name)
VALUES ('Full Body');
INSERT INTO muscle_group (name)
VALUES ('Core');
insert into muscle_group (name)
values ('Arms');

-- equipment_type table inserts
INSERT INTO equipment_type (name)
VALUES ('Barbell');
INSERT INTO equipment_type (name)
VALUES ('Bodyweight');
INSERT INTO equipment_type (name)
values ('Dumbbell');

-- set_type table inserts
INSERT INTO set_type (name)
VALUES ('Warmup');
INSERT INTO set_type (name)
VALUES ('Working');
INSERT INTO set_type (name)
values ('Drop set')

-- user table inserts
    INSERT
INTO "user" (username, email, password, created_at, updated_at)
VALUES ('john.stone', 'john@stone.com', 'john123', '2024-08-11 08:23:30.000000', '2025-12-11 08:26:39.000000');
INSERT INTO "user" (username, email, password, created_at, updated_at)
VALUES ('maria.stone', 'maria@stone.com', 'maria123', '2023-12-11 08:23:53.000000', '2025-12-11 08:26:41.000000');
INSERT INTO "user" (username, email, password, created_at, updated_at)
VALUES ('peter.jack', 'peter@jack.com', 'peter123', '2022-11-11 08:23:58.000000', '2025-12-11 08:26:42.000000');
INSERT INTO "user" (username, email, password, created_at, updated_at)
VALUES ('user', 'user@user.com', 'user123', '2020-12-11 08:23:24.000000', '2025-12-11 08:26:43.000000');

-- exercise table inserts (using foreign key IDs)
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Squat', 'Lower hips from standing position, then stand back up with barbell on upper back.', 1, 1, 1,
        '2025-12-11 08:46:31.000000');
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Bench press', 'Lie on bench, lower barbell to chest, press back up.', 1, 2, 1, '2025-12-11 08:46:33.000000');
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Deadlift', 'Lift loaded barbell from ground to hip level, engaging posterior chain.', 1, 3, 1,
        '2025-12-11 08:46:34.000000');
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Pull-up', 'Hang from bar and pull yourself up until chin is above bar.', 1, 3, 2,
        '2025-12-11 08:46:35.000000');
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Overhead press', 'Press barbell from shoulder level to overhead while standing.', 1, 4, 1,
        '2025-12-11 08:46:36.000000');
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Jumping jacks', 'Jump while spreading legs and raising arms overhead, then return to start.', 2, 5, 2,
        '2025-12-11 08:46:37.000000');
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Mountain climbers', 'In plank position, alternate driving knees toward chest rapidly.', 2, 6, 2,
        '2025-12-11 08:46:38.000000');
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Burpee', 'Drop to plank, do a push-up, jump feet to hands, then jump up explosively.', 2, 5, 2,
        '2025-12-11 08:46:39.000000');
INSERT INTO exercise (name, description, category_id, muscle_group_id, equipment_type_id, created_at)
VALUES ('Hanging leg raises', 'Hang from bar with straight arms and raise legs up toward chest or parallel to ground.',
        1, 6, 2, '2025-12-11 08:46:40.000000');

-- workout table inserts
INSERT INTO workout (user_id, name, "date", start_time, end_time, duration_minutes, notes, created_at)
VALUES (1, 'Operator: Week 2 (80%)', '2025-07-17', '06:26:00', '07:45:00', 79, 'Felt strong today, all sets completed',
        '2025-07-17 06:26:00.000000');
INSERT INTO workout (user_id, name, "date", start_time, end_time, duration_minutes, notes, created_at)
VALUES (2, 'HIIT Cardio Session', '2025-10-12', '18:30:00', '19:15:00', 45, 'Intense cardio, good session',
        '2025-10-10 19:15:00.000000');
INSERT INTO workout (user_id, name, "date", start_time, end_time, duration_minutes, notes, created_at)
VALUES (3, '5/3/1: Week 3 (95%)', '2025-12-09', '17:00:00', '18:20:00', 80, 'PR on bench press! Shoulders feeling good',
        '2025-12-09 17:00:00.000000');
INSERT INTO workout (user_id, name, "date", start_time, end_time, duration_minutes, notes, created_at)
VALUES (3, 'Core Strength', '2025-12-11', '12:00:00', '12:35:00', 35, 'Quick lunch workout',
        '2025-12-11 12:35:00.000000');
INSERT INTO workout (user_id, name, "date", start_time, end_time, duration_minutes, notes, created_at)
VALUES (1, 'Operator: Week 1 (70%)', '2025-07-10', '06:30:00', '07:40:00', 70,
        'First week back after deload, felt easier', '2025-07-10 06:30:00.000000');
INSERT INTO workout (user_id, name, "date", start_time, end_time, duration_minutes, notes, created_at)
VALUES (1, 'Conditioning Day', '2025-12-08', '07:00:00', '07:50:00', 50,
        'High rep bodyweight circuits, heart rate stayed elevated', '2025-12-08 07:50:00.000000');

-- workout_exercise table inserts
-- Workout 1: Operator Week 2 (80%) - john.stone
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (1, 1, 1, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (1, 2, 2, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (1, 3, 3, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (1, 4, 4, '');

-- Workout 2: HIIT Cardio Session - maria.stone
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (2, 6, 1, '4 rounds');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (2, 8, 2, '4 rounds');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (2, 7, 3, '4 rounds');

-- Workout 3: 5/3/1 Week 3 (95%) - peter.jack
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (3, 2, 1, 'Hit PR!');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (3, 5, 2, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (3, 4, 3, '');

-- Workout 4: Core Strength - peter.jack
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (4, 9, 1, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (4, 7, 2, '');

-- Workout 5: Operator Week 1 (70%) - john.stone
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (5, 1, 1, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (5, 2, 2, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (5, 3, 3, '');

-- Workout 6: Conditioning Day - john.stone
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (6, 8, 1, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (6, 4, 2, '');
INSERT INTO workout_exercise (workout_id, exercise_id, order_index, notes)
VALUES (6, 9, 3, '');

-- exercise_set table inserts (using set_type_id)
-- Workout 1, Exercise 1: Squat (workout_exercise_id = 1)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (1, 1, 1, 20.00, 10, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (1, 1, 2, 50.00, 5, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (1, 1, 3, 60.00, 3, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (1, 2, 1, 85.00, 5, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (1, 2, 2, 85.00, 5, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (1, 2, 3, 85.00, 5, 9, '', true);

-- Workout 1, Exercise 2: Bench Press (workout_exercise_id = 2)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (2, 1, 1, 20.00, 10, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (2, 1, 2, 40.00, 5, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (2, 2, 1, 70.00, 5, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (2, 2, 2, 70.00, 5, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (2, 2, 3, 70.00, 5, 9, '', true);

-- Workout 1, Exercise 3: Deadlift (workout_exercise_id = 3)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (3, 1, 1, 60.00, 5, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (3, 1, 2, 100.00, 3, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (3, 2, 1, 120.00, 5, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (3, 2, 2, 120.00, 5, 9, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (3, 2, 3, 120.00, 5, 9, '', true);

-- Workout 1, Exercise 4: Pull-up (workout_exercise_id = 4)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (4, 2, 1, NULL, 12, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (4, 2, 2, NULL, 11, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (4, 2, 3, NULL, 10, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (4, 2, 4, NULL, 9, 9, '', true);

-- Workout 2, Exercise 1: Jumping jacks (workout_exercise_id = 5)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (5, 2, 1, NULL, 50, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (5, 2, 2, NULL, 50, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (5, 2, 3, NULL, 45, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (5, 2, 4, NULL, 40, 9, '', true);

-- Workout 2, Exercise 2: Burpee (workout_exercise_id = 6)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (6, 2, 1, NULL, 15, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (6, 2, 2, NULL, 15, 9, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (6, 2, 3, NULL, 12, 9, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (6, 2, 4, NULL, 10, 10, '', true);

-- Workout 2, Exercise 3: Mountain climbers (workout_exercise_id = 7)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (7, 2, 1, NULL, 30, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (7, 2, 2, NULL, 30, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (7, 2, 3, NULL, 25, 9, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (7, 2, 4, NULL, 20, 9, '', true);

-- Workout 3, Exercise 1: Bench Press (workout_exercise_id = 8)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (8, 1, 1, 20.00, 10, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (8, 1, 2, 40.00, 5, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (8, 1, 3, 60.00, 3, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (8, 2, 1, 90.00, 3, 9, 'New PR!', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (8, 2, 2, 90.00, 3, 10, '', true);

-- Workout 3, Exercise 2: Overhead press (workout_exercise_id = 9)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (9, 1, 1, 20.00, 10, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (9, 2, 1, 50.00, 8, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (9, 2, 2, 50.00, 8, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (9, 2, 3, 50.00, 7, 9, '', true);

-- Workout 3, Exercise 3: Pull-up (workout_exercise_id = 10)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (10, 2, 1, NULL, 10, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (10, 2, 2, NULL, 9, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (10, 2, 3, NULL, 8, 9, '', true);

-- Workout 4, Exercise 1: Hanging leg raises (workout_exercise_id = 11)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (11, 2, 1, NULL, 12, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (11, 2, 2, NULL, 10, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (11, 2, 3, NULL, 8, 9, '', true);

-- Workout 4, Exercise 2: Mountain climbers (workout_exercise_id = 12)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (12, 2, 1, NULL, 40, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (12, 2, 2, NULL, 35, 9, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (12, 2, 3, NULL, 30, 9, '', true);

-- Workout 5, Exercise 1: Squat (workout_exercise_id = 13)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (13, 1, 1, 20.00, 10, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (13, 1, 2, 40.00, 5, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (13, 2, 1, 70.00, 5, 6, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (13, 2, 2, 70.00, 5, 6, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (13, 2, 3, 70.00, 5, 7, '', true);

-- Workout 5, Exercise 2: Bench Press (workout_exercise_id = 14)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (14, 1, 1, 20.00, 10, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (14, 2, 1, 60.00, 5, 6, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (14, 2, 2, 60.00, 5, 6, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (14, 2, 3, 60.00, 5, 7, '', true);

-- Workout 5, Exercise 3: Deadlift (workout_exercise_id = 15)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (15, 1, 1, 60.00, 5, NULL, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (15, 2, 1, 95.00, 5, 6, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (15, 2, 2, 95.00, 5, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (15, 2, 3, 95.00, 5, 7, '', true);

-- Workout 6, Exercise 1: Burpee (workout_exercise_id = 16)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (16, 2, 1, NULL, 20, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (16, 2, 2, NULL, 20, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (16, 2, 3, NULL, 18, 9, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (16, 2, 4, NULL, 15, 9, '', true);

-- Workout 6, Exercise 2: Pull-up (workout_exercise_id = 17)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (17, 2, 1, NULL, 15, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (17, 2, 2, NULL, 12, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (17, 2, 3, NULL, 10, 9, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (17, 2, 4, NULL, 8, 9, '', true);

-- Workout 6, Exercise 3: Hanging leg raises (workout_exercise_id = 18)
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (18, 2, 1, NULL, 15, 7, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (18, 2, 2, NULL, 12, 8, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (18, 2, 3, NULL, 10, 9, '', true);
INSERT INTO exercise_set (workout_exercise_id, set_type_id, set_number, weight_kg, reps, rpe, notes, completed)
VALUES (18, 2, 4, NULL, 8, 9, 'Grip gave out', true);

-- user table inserts
INSERT INTO PUBLIC."user" (USERNAME, EMAIL, PASSWORD, CREATED_AT, UPDATED_AT) VALUES ('john.stone', 'john@stone.com', 'john123', '2024-08-11 08:23:30.000000', '2025-12-11 08:26:39.000000');
INSERT INTO PUBLIC."user" (USERNAME, EMAIL, PASSWORD, CREATED_AT, UPDATED_AT) VALUES ('maria.stone', 'maria@stone.com', 'maria123', '2023-12-11 08:23:53.000000', '2025-12-11 08:26:41.000000');
INSERT INTO PUBLIC."user" (USERNAME, EMAIL, PASSWORD, CREATED_AT, UPDATED_AT) VALUES ('peter.jack', 'peter@jack.com', 'peter123', '2022-11-11 08:23:58.000000', '2025-12-11 08:26:42.000000');
INSERT INTO PUBLIC."user" (USERNAME, EMAIL, PASSWORD, CREATED_AT, UPDATED_AT) VALUES ('user', 'user@user.com', 'user123', '2020-12-11 08:23:24.000000', '2025-12-11 08:26:43.000000');

-- exercise table inserts
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Squat', 'Lower hips from standing position, then stand back up with barbell on upper back.', 'STRENGTH', 'LEGS', 'BARBELL', '2025-12-11 08:46:31.000000');
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Becnh press', 'Lie on bench, lower barbell to chest, press back up.', 'STRENGTH', 'CHEST', 'BARBELL', '2025-12-11 08:46:33.000000');
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Deadlift', 'Lift loaded barbell from ground to hip level, engaging posterior chain.', 'STRENGTH', 'BACK', 'BARBELL', '2025-12-11 08:46:34.000000');
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Pull-up', 'Hang from bar and pull yourself up until chin is above bar.', 'STRENGTH', 'BACK', 'BODYWEIGHT', '2025-12-11 08:46:35.000000');
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Overhead press', 'Press barbell from shoulder level to overhead while standing.', 'STRENGTH', 'SHOULDERS', 'BARBELL', '2025-12-11 08:46:36.000000');
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Jumping jacks', 'Jump while spreading legs and raising arms overhead, then return to start.', 'CARDIO', 'FULL_BODY', 'BODYWEIGHT', '2025-12-11 08:46:37.000000');
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Mountain climbers', 'In plank position, alternate driving knees toward chest rapidly.', 'CARDIO', 'CORE', 'BODYWEIGHT', '2025-12-11 08:46:38.000000');
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Burpee', 'Drop to plank, do a push-up, jump feet to hands, then jump up explosively.', 'CARDIO', 'FULL_BODY', 'BODYWEIGHT', '2025-12-11 08:46:39.000000');
INSERT INTO PUBLIC.EXERCISE (NAME, DESCRIPTION, CATEGORY, MUSCLE_GROUP, EQUIPMENT_TYPE, CREATED_AT) VALUES ('Hanging leg raises', 'Hang from bar with straight arms and raise legs up toward chest or parallel to ground.', 'STRENGTH', 'CORE', 'BODYWEIGHT', '2025-12-11 08:46:40.000000');

-- workout table inserts
INSERT INTO PUBLIC.WORKOUT (USER_ID, NAME, "date", START_TIME, END_TIME, DURATION_MINUTES, NOTES, CREATED_AT) VALUES (1, 'Operator: Week 2 (80%)', '2025-07-17', '06:26:00', '07:45:00', 79, 'Felt strong today, all sets completed', '2025-07-17 06:26:00.000000');
INSERT INTO PUBLIC.WORKOUT (USER_ID, NAME, "date", START_TIME, END_TIME, DURATION_MINUTES, NOTES, CREATED_AT) VALUES (2, 'HIIT Cardio Session', '2025-10-12', '18:30:00', '19:15:00', 45, 'Intense cardio, good session', '2025-10-10 19:15:00.000000');
INSERT INTO PUBLIC.WORKOUT (USER_ID, NAME, "date", START_TIME, END_TIME, DURATION_MINUTES, NOTES, CREATED_AT) VALUES (3, '5/3/1: Week 3 (95%)', '2025-12-09', '17:00:00', '18:20:00', 80, 'PR on bench press! Shoulders feeling good', '2025-12-09 17:00:00.000000');
INSERT INTO PUBLIC.WORKOUT (USER_ID, NAME, "date", START_TIME, END_TIME, DURATION_MINUTES, NOTES, CREATED_AT) VALUES (3, 'Core Strength', '2025-12-11', '12:00:00', '12:35:00', 35, 'Quick lunch workout', '2025-12-11 12:35:00.000000');
INSERT INTO PUBLIC.WORKOUT (USER_ID, NAME, "date", START_TIME, END_TIME, DURATION_MINUTES, NOTES, CREATED_AT) VALUES (1, 'Operator: Week 1 (70%)', '2025-07-10', '06:30:00', '07:40:00', 70, 'First week back after deload, felt easier', '2025-07-10 06:30:00.000000');
INSERT INTO PUBLIC.WORKOUT (USER_ID, NAME, "date", START_TIME, END_TIME, DURATION_MINUTES, NOTES, CREATED_AT) VALUES (1, 'Conditioning Day', '2025-12-08', '07:00:00', '07:50:00', 50, 'High rep bodyweight circuits, heart rate stayed elevated', '2025-12-08 07:50:00.000000');

-- workoutexercise table inserts
-- Workout 1: Operator Week 2 (80%) - john.stone
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (1, 1, 1, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (1, 2, 2, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (1, 3, 3, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (1, 4, 4, '');

-- Workout 2: HIIT Cardio Session - maria.stone
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (2, 6, 1, '4 rounds');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (2, 8, 2, '4 rounds');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (2, 7, 3, '4 rounds');

-- Workout 3: 5/3/1 Week 3 (95%) - peter.jack
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (3, 2, 1, 'Hit PR!');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (3, 5, 2, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (3, 4, 3, '');

-- Workout 4: Core Strength - peter.jack
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (4, 9, 1, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (4, 7, 2, '');

-- Workout 5: Operator Week 1 (70%) - john.stone
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (5, 1, 1, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (5, 2, 2, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (5, 3, 3, '');

-- Workout 6: Conditioning Day - john.stone
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (6, 8, 1, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (6, 4, 2, '');
INSERT INTO workoutexercise (workout_id, exercise_id, order_index, notes) VALUES (6, 9, 3, '');

-- exerciseset table inserts
-- Workout 1, Exercise 1: Squat (workout_exercise_id = 1)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (1, 'WARMUP', 1, 20.00, 10, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (1, 'WARMUP', 2, 50.00, 5, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (1, 'WARMUP', 3, 60.00, 3, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (1, 'WORKING', 1, 85.00, 5, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (1, 'WORKING', 2, 85.00, 5, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (1, 'WORKING', 3, 85.00, 5, 9, '', true);

-- Workout 1, Exercise 2: Bench Press (workout_exercise_id = 2)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (2, 'WARMUP', 1, 20.00, 10, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (2, 'WARMUP', 2, 40.00, 5, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (2, 'WORKING', 1, 70.00, 5, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (2, 'WORKING', 2, 70.00, 5, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (2, 'WORKING', 3, 70.00, 5, 8, '', true);

-- Workout 1, Exercise 3: Deadlift (workout_exercise_id = 3)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (3, 'WARMUP', 1, 60.00, 5, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (3, 'WARMUP', 2, 80.00, 3, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (3, 'WORKING', 1, 110.00, 5, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (3, 'WORKING', 2, 110.00, 5, 9, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (3, 'WORKING', 3, 110.00, 5, 9, '', true);

-- Workout 1, Exercise 4: Pull-up (workout_exercise_id = 4)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (4, 'WORKING', 1, NULL, 8, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (4, 'WORKING', 2, NULL, 7, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (4, 'WORKING', 3, NULL, 6, 9, '', true);

-- Workout 2, Exercise 1: Jumping jacks (workout_exercise_id = 5)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (5, 'WORKING', 1, NULL, 50, 6, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (5, 'WORKING', 2, NULL, 50, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (5, 'WORKING', 3, NULL, 50, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (5, 'WORKING', 4, NULL, 50, 9, '', true);

-- Workout 2, Exercise 2: Burpee (workout_exercise_id = 6)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (6, 'WORKING', 1, NULL, 15, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (6, 'WORKING', 2, NULL, 15, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (6, 'WORKING', 3, NULL, 12, 9, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (6, 'WORKING', 4, NULL, 10, 10, 'Almost failed', true);

-- Workout 2, Exercise 3: Mountain climbers (workout_exercise_id = 7)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (7, 'WORKING', 1, NULL, 30, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (7, 'WORKING', 2, NULL, 30, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (7, 'WORKING', 3, NULL, 25, 9, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (7, 'WORKING', 4, NULL, 20, 9, '', true);

-- Workout 3, Exercise 1: Bench Press (workout_exercise_id = 8)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (8, 'WARMUP', 1, 20.00, 10, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (8, 'WARMUP', 2, 40.00, 5, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (8, 'WARMUP', 3, 60.00, 3, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (8, 'WORKING', 1, 90.00, 3, 9, 'New PR!', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (8, 'WORKING', 2, 90.00, 3, 10, '', true);

-- Workout 3, Exercise 2: Overhead press (workout_exercise_id = 9)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (9, 'WARMUP', 1, 20.00, 10, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (9, 'WORKING', 1, 50.00, 8, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (9, 'WORKING', 2, 50.00, 8, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (9, 'WORKING', 3, 50.00, 7, 9, '', true);

-- Workout 3, Exercise 3: Pull-up (workout_exercise_id = 10)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (10, 'WORKING', 1, NULL, 10, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (10, 'WORKING', 2, NULL, 9, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (10, 'WORKING', 3, NULL, 8, 9, '', true);

-- Workout 4, Exercise 1: Hanging leg raises (workout_exercise_id = 11)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (11, 'WORKING', 1, NULL, 12, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (11, 'WORKING', 2, NULL, 10, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (11, 'WORKING', 3, NULL, 8, 9, '', true);

-- Workout 4, Exercise 2: Mountain climbers (workout_exercise_id = 12)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (12, 'WORKING', 1, NULL, 40, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (12, 'WORKING', 2, NULL, 35, 9, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (12, 'WORKING', 3, NULL, 30, 9, '', true);

-- Workout 5, Exercise 1: Squat (workout_exercise_id = 13)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (13, 'WARMUP', 1, 20.00, 10, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (13, 'WARMUP', 2, 40.00, 5, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (13, 'WORKING', 1, 70.00, 5, 6, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (13, 'WORKING', 2, 70.00, 5, 6, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (13, 'WORKING', 3, 70.00, 5, 7, '', true);

-- Workout 5, Exercise 2: Bench Press (workout_exercise_id = 14)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (14, 'WARMUP', 1, 20.00, 10, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (14, 'WORKING', 1, 60.00, 5, 6, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (14, 'WORKING', 2, 60.00, 5, 6, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (14, 'WORKING', 3, 60.00, 5, 7, '', true);

-- Workout 5, Exercise 3: Deadlift (workout_exercise_id = 15)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (15, 'WARMUP', 1, 60.00, 5, NULL, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (15, 'WORKING', 1, 95.00, 5, 6, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (15, 'WORKING', 2, 95.00, 5, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (15, 'WORKING', 3, 95.00, 5, 7, '', true);

-- Workout 6, Exercise 1: Burpee (workout_exercise_id = 16)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (16, 'WORKING', 1, NULL, 20, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (16, 'WORKING', 2, NULL, 20, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (16, 'WORKING', 3, NULL, 18, 9, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (16, 'WORKING', 4, NULL, 15, 9, '', true);

-- Workout 6, Exercise 2: Pull-up (workout_exercise_id = 17)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (17, 'WORKING', 1, NULL, 15, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (17, 'WORKING', 2, NULL, 12, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (17, 'WORKING', 3, NULL, 10, 9, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (17, 'WORKING', 4, NULL, 8, 9, '', true);

-- Workout 6, Exercise 3: Hanging leg raises (workout_exercise_id = 18)
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (18, 'WORKING', 1, NULL, 15, 7, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (18, 'WORKING', 2, NULL, 12, 8, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (18, 'WORKING', 3, NULL, 10, 9, '', true);
INSERT INTO exerciseset (workout_exercise_id, set_type, set_number, weight_kg, reps, rpe, notes, completed) VALUES (18, 'WORKING', 4, NULL, 8, 9, 'Grip gave out', true);
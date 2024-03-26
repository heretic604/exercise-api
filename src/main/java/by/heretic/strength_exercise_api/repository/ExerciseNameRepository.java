package by.heretic.strength_exercise_api.repository;

import by.heretic.strength_exercise_api.domain.entity.ExerciseName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseNameRepository extends JpaRepository<ExerciseName, Long> {

    Boolean existsExerciseNameByExerciseName(String exerciseName);

}
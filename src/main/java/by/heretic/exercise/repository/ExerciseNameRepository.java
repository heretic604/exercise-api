package by.heretic.exercise.repository;

import by.heretic.exercise.domain.entity.ExerciseName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseNameRepository extends JpaRepository<ExerciseName, Long> {

    Boolean existsExerciseNameByExerciseName(String exerciseName);

}
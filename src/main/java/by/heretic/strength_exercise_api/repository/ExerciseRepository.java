package by.heretic.strength_exercise_api.repository;

import by.heretic.strength_exercise_api.domain.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
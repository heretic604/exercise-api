package by.heretic.exercise.repository;

import by.heretic.exercise.domain.entity.Exercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {
}
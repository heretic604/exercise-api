package by.heretic.coach.repository.exercise.strength;

import by.heretic.coach.domain.entity.exercise.strength.StrengthExercise;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StrengthExerciseRepository extends JpaRepository<StrengthExercise, Long> {
}
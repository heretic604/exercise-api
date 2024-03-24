package by.heretic.coach.repository;

import by.heretic.coach.domain.entity.ExerciseName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExerciseNameRepository extends JpaRepository<ExerciseName, Long> {
}
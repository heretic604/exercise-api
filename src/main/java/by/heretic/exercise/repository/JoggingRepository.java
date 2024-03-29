package by.heretic.exercise.repository;

import by.heretic.exercise.domain.entity.Jogging;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JoggingRepository extends JpaRepository<Jogging, Long> {
}
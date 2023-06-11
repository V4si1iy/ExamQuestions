package course.work.examquestions.repository;

import course.work.examquestions.model.MathQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MathQuestionRepository extends JpaRepository<MathQuestion, Long> {
}

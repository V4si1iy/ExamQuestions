package course.work.examquestions.repository;

import course.work.examquestions.model.JavaQuestion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JavaQuestionRepository extends JpaRepository<JavaQuestion, Long> {
}

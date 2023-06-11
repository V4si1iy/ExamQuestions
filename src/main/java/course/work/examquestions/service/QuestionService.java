package course.work.examquestions.service;

import course.work.examquestions.model.JavaQuestion;
import course.work.examquestions.model.QuestionDTO;
import org.aspectj.weaver.patterns.TypePatternQuestions;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface QuestionService {
    QuestionDTO add(QuestionDTO question);
    void remove(QuestionDTO question);
    Collection<QuestionDTO> getAll();
    QuestionDTO getRandomQuestion();
    Long getSize();
}

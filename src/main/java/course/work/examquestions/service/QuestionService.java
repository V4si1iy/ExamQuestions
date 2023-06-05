package course.work.examquestions.service;

import course.work.examquestions.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface QuestionService {
    Question add(String question, String answer);
    Question remove(Question question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
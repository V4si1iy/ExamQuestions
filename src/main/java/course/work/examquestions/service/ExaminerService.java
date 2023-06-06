package course.work.examquestions.service;

import course.work.examquestions.model.Question;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface ExaminerService {
    public Collection<Question> getQuestions(int amount);
}

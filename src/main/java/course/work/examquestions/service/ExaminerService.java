package course.work.examquestions.service;

import course.work.examquestions.exception.OverRequest;
import course.work.examquestions.model.JavaQuestion;
import course.work.examquestions.model.QuestionDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;
@Service
public interface ExaminerService {
    public Collection<QuestionDTO> getQuestions(int amount) throws OverRequest;
}

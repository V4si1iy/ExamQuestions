package course.work.examquestions.service;

import course.work.examquestions.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class ExaminerServiceImpl implements ExaminerService{
    QuestionService questionRepository;
    Set<Question> questions = new HashSet<>();
    @Override
    public Collection<Question> getQuestions(int amount) {

        while (questions.size() < amount)
        {
           questions.add(questionRepository.getRandomQuestion());
        }
        return questions;
    }
}

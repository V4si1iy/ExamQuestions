package course.work.examquestions.service;

import course.work.examquestions.model.Question;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class JavaQuestionService implements QuestionService {
    private Set<Question> questions = new HashSet<>();

    @Override
    public Question add(String question, String answer) {
        return add(new Question(question, answer));
    }

    private Question add(Question question) {
        questions.add(question);
        return questions.stream().toList().get(questions.size() - 1);
    }

    @Override
    public Question remove(Question question) {
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        Random rnd = new Random();
        return questions.stream().toList().get(rnd.nextInt(questions.size()));
    }
}

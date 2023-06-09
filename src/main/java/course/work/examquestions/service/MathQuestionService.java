package course.work.examquestions.service;

import course.work.examquestions.model.JavaQuestion;
import course.work.examquestions.model.MathQuestion;
import course.work.examquestions.model.QuestionDTO;
import course.work.examquestions.repository.MathQuestionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
@Service

@Component("math")
public class MathQuestionService implements QuestionService {
    MathQuestionRepository repository;
    Random rnd = new Random();

    public MathQuestionService(MathQuestionRepository repository) {
        this.repository = repository;
    }

    @Override
    public QuestionDTO add(QuestionDTO question) {

        return toDTO(repository.save(fromDTO(question)));
    }

    @Override
    public void remove(QuestionDTO question) {

        repository.delete(fromDTO(question));
    }

    @Override
    public Collection<QuestionDTO> getAll() {
        List<QuestionDTO> value = new ArrayList<>();
        List<MathQuestion> result = repository.findAll();
        for (int i = 0; i < result.size(); i++) {
            value.add(toDTO(result.get(i)));
        }
        return value;

    }

    @Override
    public QuestionDTO getRandomQuestion() {

        return toDTO(repository.findById(rnd.nextLong(repository.findAll().size())).get());
    }

    @Override
    public Long getSize() {

        return (long) repository.findAll().size();
    }

    private MathQuestion fromDTO(QuestionDTO question) {
        MathQuestion value = new MathQuestion();
        value.setQuestion(question.getQuestion());
        value.setAnswer(question.getAnswer());
        value.setId(question.getId());
        return value;
    }

    private QuestionDTO toDTO(MathQuestion question) {
        return new QuestionDTO(question.getId(), question.getQuestion(), question.getAnswer());
    }
}

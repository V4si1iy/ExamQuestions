package course.work.examquestions.service;

import course.work.examquestions.exception.OverRequest;
import course.work.examquestions.model.QuestionDTO;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    Random rnd = new Random();
    @Qualifier("java")
    QuestionService serviceJava;
    @Qualifier("math")
    QuestionService serviceMath;

    public ExaminerServiceImpl(QuestionService java, QuestionService math) {
        this.serviceJava = java;
        this.serviceMath = math;
    }


    @Override
    public Collection<QuestionDTO> getQuestions(int amount) throws OverRequest {
        Set<QuestionDTO> questionsJava = new HashSet<>();
        Set<QuestionDTO> questionsMath = new HashSet<>();
        long random;
        random = rnd.nextLong(amount + 1);
        if (serviceJava.getSize() + serviceMath.getSize() < amount) {
            throw new OverRequest();
        }
        if (random > serviceJava.getSize() || amount - random > serviceMath.getSize()) {
            if (serviceMath.getSize() > serviceJava.getSize()) {
                random = serviceJava.getSize();
            } else {
                random = amount - serviceMath.getSize();
            }
        }
        while (questionsMath.size() < amount - random) {
            questionsMath.add(serviceMath.getRandomQuestion());
        }
        while (questionsJava.size() < random) {
            questionsJava.add(serviceJava.getRandomQuestion());
        }
        return Stream.of(questionsMath, questionsJava)
                .parallel()
                .flatMap(x -> x.stream())
                .collect(Collectors.toSet());
    }
}

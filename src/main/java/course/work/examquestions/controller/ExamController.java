package course.work.examquestions.controller;

import course.work.examquestions.model.Question;
import course.work.examquestions.service.ExaminerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;

@Controller
@RequiredArgsConstructor
public class ExamController {
    ExaminerService service;
    @GetMapping("{amountQuestions}")
    public ResponseEntity<Collection<Question>> getQuestions(@PathVariable int amountQuestions)
    {
        if(amountQuestions <= 0)
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(service.getQuestions(amountQuestions));
    }
}

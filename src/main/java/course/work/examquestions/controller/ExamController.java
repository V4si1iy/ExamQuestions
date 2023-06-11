package course.work.examquestions.controller;

import course.work.examquestions.exception.OverRequest;
import course.work.examquestions.model.JavaQuestion;
import course.work.examquestions.model.QuestionDTO;
import course.work.examquestions.service.ExaminerService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


import java.util.Collection;

@Controller
@AllArgsConstructor
public class ExamController {
    ExaminerService service;
    @GetMapping("/{amountQuestions}")
    public ResponseEntity<Collection<QuestionDTO>> getQuestions(@PathVariable int amountQuestions) throws OverRequest {
        if(amountQuestions <= 0) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(service.getQuestions(amountQuestions));
    }
}

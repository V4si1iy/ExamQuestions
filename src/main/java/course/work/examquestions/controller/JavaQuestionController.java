package course.work.examquestions.controller;

import course.work.examquestions.model.Question;
import course.work.examquestions.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/java")
@RequiredArgsConstructor
public class JavaQuestionController {
    QuestionService service;

    @PostMapping("/add")
    public ResponseEntity<Question> addQuestions(@RequestBody String question, @RequestBody String answer) {
        if (question == null || answer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.add(question, answer));
    }

    @GetMapping()
    public ResponseEntity<Collection<Question>> getQuestions() {
        return ResponseEntity.ok(service.getAll());
    }
    @DeleteMapping("/remove/{question}")
    public ResponseEntity<Question> removeQuestion(@PathVariable Question question) {
        return ResponseEntity.ok(service.remove(question));
    }

}

package course.work.examquestions.controller;

import course.work.examquestions.model.QuestionDTO;
import course.work.examquestions.service.QuestionService;
import lombok.AllArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
@Controller
@RequestMapping("/math")
public class MathQuestionController {
    QuestionService service;

    public MathQuestionController(QuestionService math) {
        this.service = math;
    }

    @PostMapping("/add")
    public ResponseEntity<QuestionDTO> addQuestions(@RequestBody QuestionDTO question) {
        if (question == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(service.add(question));
    }

    @GetMapping()
    public ResponseEntity<Collection<QuestionDTO>> getQuestions() {
        return ResponseEntity.ok(service.getAll());
    }
    @DeleteMapping("/remove")
    public ResponseEntity removeQuestion(@RequestBody QuestionDTO question) {
        service.remove(question);
        return ResponseEntity.ok("Вопрос удален");
    }
}

package course.work.examquestions.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@Data
@AllArgsConstructor
public class Question {
    private String question;
     private String answer;
}

package course.work.examquestions.model;


import lombok.AllArgsConstructor;
import lombok.Data;
@AllArgsConstructor
@Data
public class QuestionDTO {
    Long id;
    private String question;
    private String answer;
}

package course.work.examquestions.service;

import course.work.examquestions.exception.OverRequest;
import course.work.examquestions.model.QuestionDTO;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {
    @Mock
    JavaQuestionService mockJava;
    @Mock
    MathQuestionService mockMath;
    @InjectMocks
    ExaminerServiceImpl out;

    private final static QuestionDTO QUESTION_TEST = new QuestionDTO(1l,"TEST1", "TEST2");

    @Test
    @DisplayName("Полная проверка метода getQuestions")
    public void test1() throws OverRequest {
        assertThrows(OverRequest.class, ()-> out.getQuestions(20));

    }

}

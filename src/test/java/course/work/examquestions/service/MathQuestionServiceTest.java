package course.work.examquestions.service;

import course.work.examquestions.model.JavaQuestion;
import course.work.examquestions.model.MathQuestion;
import course.work.examquestions.model.QuestionDTO;
import course.work.examquestions.repository.MathQuestionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceTest {
    @Mock
    private MathQuestionRepository storageMock;
    @InjectMocks
    private MathQuestionService out;

    private final static QuestionDTO QUESTION_TEST = new QuestionDTO(1l,"TEST1", "TEST2");
    private final static MathQuestion MATH_QUESTION_TEST = new MathQuestion();
    @BeforeAll
    public static void fill(){
        MATH_QUESTION_TEST.setQuestion("TEST1");
        MATH_QUESTION_TEST.setAnswer("TEST2");
        MATH_QUESTION_TEST.setId(1l);
    }


    @Test
    @DisplayName("Проверка методов add, getAll на отклик")
    public void test1()
    {

        when(storageMock.save(any())).thenReturn(MATH_QUESTION_TEST);

        assertEquals(QUESTION_TEST , out.add(QUESTION_TEST));

        final List<MathQuestion> TEST_LIST = List.of(MATH_QUESTION_TEST, MATH_QUESTION_TEST, MATH_QUESTION_TEST);
        final List<QuestionDTO> EXCEPTED_LIST = List.of(QUESTION_TEST, QUESTION_TEST,QUESTION_TEST);
        when(storageMock.findAll()).thenReturn(TEST_LIST);

        assertEquals(EXCEPTED_LIST , out.getAll());

    }

}

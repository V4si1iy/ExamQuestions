package course.work.examquestions.service;

import course.work.examquestions.model.JavaQuestion;
import course.work.examquestions.model.QuestionDTO;
import course.work.examquestions.repository.JavaQuestionRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceTest {
    @Mock
    private JavaQuestionRepository storageMock;
    @InjectMocks
    private JavaQuestionService out;

    private final static QuestionDTO QUESTION_TEST = new QuestionDTO(1l,"TEST1", "TEST2");
    private final static JavaQuestion JAVA_QUESTION_TEST = new JavaQuestion();
    @BeforeAll
    public static void fill(){
        JAVA_QUESTION_TEST.setQuestion("TEST1");
        JAVA_QUESTION_TEST.setAnswer("TEST2");
        JAVA_QUESTION_TEST.setId(1l);
    }


    @Test
    @DisplayName("Проверка методов add, getAll на отклик")
    public void test1()
    {

     when(storageMock.save(any())).thenReturn(JAVA_QUESTION_TEST);

     assertEquals(QUESTION_TEST , out.add(QUESTION_TEST));

     final List<JavaQuestion> TEST_LIST = List.of(JAVA_QUESTION_TEST, JAVA_QUESTION_TEST,JAVA_QUESTION_TEST);
     final List<QuestionDTO> EXCEPTED_LIST = List.of(QUESTION_TEST, QUESTION_TEST,QUESTION_TEST);
      when(storageMock.findAll()).thenReturn(TEST_LIST);

      assertEquals(EXCEPTED_LIST , out.getAll());

    }

}

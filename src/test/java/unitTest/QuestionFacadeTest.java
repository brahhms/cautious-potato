package unitTest;

import domain.Question;
import eis.QuestionFacade;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import org.mockito.runners.MockitoJUnitRunner;

/**
 *
 * @author abraham
 */
@RunWith(MockitoJUnitRunner.class)
public class QuestionFacadeTest extends AbstractTestFacade<Question> {

    @InjectMocks
    private QuestionFacade questionFacade;

    List<Question> ls;
    Question question;

    public QuestionFacadeTest() {
        super(Question.class);
        this.question = new Question(1);
        this.ls = new ArrayList<>();
        this.ls.add(question);
        this.ls.add(new Question());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<Question> result = questionFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<Question> result = questionFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        questionFacade.create(question);
        verify(getEm(), times(1)).persist(question);

    }

    @Test
    public void testEdit() {
        questionFacade.edit(question);
        verify(getEm(), times(1)).merge(question);

    }

    @Test
    public void testRemove() {
        questionFacade.remove(question);
        verify(getEm(), times(1)).remove(getEm().merge(question));

    }

    @Test
    public void testFind() {
        mockResult(question);
        Question result = questionFacade.find(question.getId());

        System.out.println(result.toString());
        assertEquals(question, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = questionFacade.count();

        assertNotNull(result);
    }
    
}

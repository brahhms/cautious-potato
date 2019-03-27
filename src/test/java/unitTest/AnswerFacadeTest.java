package unitTest;

import domain.Answer;
import eis.AnswerFacade;
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
public class AnswerFacadeTest extends AbstractTestFacade<Answer> {

    @InjectMocks
    private AnswerFacade answerFacade;

    List<Answer> ls;
    Answer answer;

    public AnswerFacadeTest() {
        super(Answer.class);
        this.answer = new Answer(1);
        this.ls = new ArrayList<>();
        this.ls.add(answer);
        this.ls.add(new Answer());
    }

    @Before
    public void setUp() {
        mockQuery();
    }

    @Test
    public void testRange() {
        mockResult(ls);
        List<Answer> result = answerFacade.findRange(new int[2]);

        assertEquals(ls, result);
    }

    @Test
    public void testFindAll() {
        mockResult(ls);
        List<Answer> result = answerFacade.findAll();

        assertNotNull(result);
        assertEquals(ls, result);
    }

    @Test
    public void testCreate() {
        answerFacade.create(answer);
        verify(getEm(), times(1)).persist(answer);

    }

    @Test
    public void testEdit() {
        answerFacade.edit(answer);
        verify(getEm(), times(1)).merge(answer);

    }

    @Test
    public void testRemove() {
        answerFacade.remove(answer);
        verify(getEm(), times(1)).remove(getEm().merge(answer));

    }

    @Test
    public void testFind() {
        mockResult(answer);
        Answer result = answerFacade.find(answer.getId());

        System.out.println(result.toString());
        assertEquals(answer, result);
    }

    @Test
    public void testCount() {
        mockResult(5L);
        int result = answerFacade.count();

        assertNotNull(result);
    }
    
}

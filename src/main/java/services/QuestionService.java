package services;

import domain.Post;
import eis.PostFacade;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author abraham
 */
@Local
public interface QuestionService {

    public List<Post> getAllQuestions();
    
    public void createQuestion();
    
    public void deleteQuestion();
    
    public void setPostFacade(PostFacade postFacade);
}

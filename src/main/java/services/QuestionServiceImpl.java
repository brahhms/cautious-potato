
package services;

import domain.Post;
import eis.PostFacadeLocal;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author abraham
 */
@Stateless
public class QuestionServiceImpl implements QuestionService{
    
    @Inject
    PostFacadeLocal postFacade;
    

    @Override
    public List<Post> getAllQuestions() {
        return postFacade.findAll();
    }

    @Override
    public void createQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteQuestion() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

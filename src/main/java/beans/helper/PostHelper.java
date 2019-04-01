package beans.helper;

import domain.Post;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.QuestionService;
import services.QuestionServiceImpl;


/**
 *
 * @author abraham
 */
@Named
@ViewScoped
public class PostHelper implements Serializable {

    @Inject
    QuestionService questionService;

    private List<Post> questions;

    @PostConstruct
    public void init() {
        questions = questionService.getAllQuestions();
    }

    public List<Post> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Post> questions) {
        this.questions = questions;
    }

    public void setQuestionService(QuestionServiceImpl questionService) {
        this.questionService = questionService;
    }

}

package beans.helper;

import domain.Post;
import domain.PostType;
import domain.Usuario;
import eis.PostFacade;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class QuestionHelper implements Serializable {

    private int id;
    private Post question;
    private Post answer;
    
    private final int ANSWER_TYPE = 2;

    @Inject
    private PostFacade service;
    
    @PostConstruct
    public void init(){
        question = new Post();
        answer = new Post();
    }

    public void newAnswer() {
        answer.setPostTypeId(new PostType(ANSWER_TYPE));
        answer.setParentId(question);
        answer.setOwnerDisplayName("naruto");
        answer.setOwnerUserId(new Usuario(1));
        service.create(answer);
        question.getPostChildren().add(answer);
    }


    public Post getAnswer() {
        return answer;
    }

    public void setAnswer(Post answer) {
        this.answer = answer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
        question = service.find(id);
    }

    public Post getQuestion() {
        return question;
    }

}

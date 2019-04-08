package beans.helper;


import domain.Post;
import eis.PostFacade;
import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class QuestionHelper implements Serializable {

    private List<Post> answers;
    private Post question;
    private int id = 1;
    
    @Inject
    private PostFacade service;

    @PostConstruct
    public void init() {
        //answerId = 2
        //esto borralo despues de probar
        question = service.find(id);
        answers = service.findPostByParentId(id);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Post> getAnswers() {
        return answers;
    }

    public Post getQuestion() {
        return question;
    }




}

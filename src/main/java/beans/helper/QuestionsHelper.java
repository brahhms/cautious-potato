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
public class QuestionsHelper implements Serializable {

    private List<Post> questions;

    @Inject
    private PostFacade service;

    @PostConstruct
    public void init() {
        //questionId = 1
        questions = service.findPostByType(1);
    }

    public List<Post> getQuestions() {
        return questions;
    }



}

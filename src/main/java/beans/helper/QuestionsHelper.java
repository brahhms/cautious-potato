package beans.helper;


import domain.Post;
import eis.PostFacade;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;

import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class QuestionsHelper {

    private List<Post> questions;

    @Inject
    private PostFacade service;

    @PostConstruct
    public void init() {
        //questionId = 1
        questions = service.findPostByType(1);
    }

    public List<Post> getQuestions() {
        questions = service.findPostByType(1);
        return questions;
    }



}

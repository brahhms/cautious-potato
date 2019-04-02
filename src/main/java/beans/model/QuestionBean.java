package beans.model;

import domain.Post;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import services.QuestionService;

/**
 *
 * @author abraham
 */
@Named
@RequestScoped
public class QuestionBean {

    @Inject
    QuestionService questionService;

    private int id ;
    private String body;
    private String ownerDisplayName;
    private String title;
    private List<Post> tagList;
    private String ownerUserId;

    public QuestionBean() {
    }

    public QuestionBean(int id, String body, String ownerDisplayName, String title, List<Post> tagList, String ownerUserId) {
        this.id = id;
        this.body = body;
        this.ownerDisplayName = ownerDisplayName;
        this.title = title;
        this.tagList = tagList;
        this.ownerUserId = ownerUserId;
    }
    

    public void setQuestionService(QuestionService questionService) {
        this.questionService = questionService;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getOwnerDisplayName() {
        return ownerDisplayName;
    }

    public void setOwnerDisplayName(String ownerDisplayName) {
        this.ownerDisplayName = ownerDisplayName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Post> getTagList() {
        return tagList;
    }

    public void setTagList(List<Post> tagList) {
        this.tagList = tagList;
    }

    public String getOwnerUserId() {
        return ownerUserId;
    }

    public void setOwnerUserId(String ownerUserId) {
        this.ownerUserId = ownerUserId;
    }
    
    

}

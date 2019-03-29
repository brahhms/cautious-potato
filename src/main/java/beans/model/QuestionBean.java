
package beans.model;


import domain.Post;
import domain.Tag;
import java.util.Date;
import java.util.List;
import javax.inject.Named;

/**
 *
 * @author abraham
 */
@Named
public class QuestionBean {
    private String title;
    private String body;
    private Date creationDate;
    private Integer ownerId;
    private String ownerName;
    private Integer acceptedAnswerId;
    private List<Tag> tagList;
    private List<Post> answersList;

    public String getTitle() {
        return title;
    }

    public QuestionBean() {
    }

    public QuestionBean(String title, String body, Integer ownerId, List<Tag> tagList) {
        this.title = title;
        this.body = body;
        this.ownerId = ownerId;
        this.tagList = tagList;
    }

  
    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Integer getAcceptedAnswerId() {
        return acceptedAnswerId;
    }

    public void setAcceptedAnswerId(Integer acceptedAnswerId) {
        this.acceptedAnswerId = acceptedAnswerId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<Tag> getTagList() {
        return tagList;
    }

    public void setTagList(List<Tag> tagList) {
        this.tagList = tagList;
    }

    public List<Post> getAnswersList() {
        return answersList;
    }

    public void setAnswersList(List<Post> answersList) {
        this.answersList = answersList;
    }
    
    
    
}

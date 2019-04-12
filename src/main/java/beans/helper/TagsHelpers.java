package beans.helper;

import domain.Tag;
import eis.TagFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author abraham
 */
@Named
@ViewScoped
public class TagsHelpers implements Serializable{
    
    @Inject
    TagFacade service;
    
    private List<Tag> tags;

    @PostConstruct
    public void init(){
        tags = service.findAll();
    }
    
    public List<Tag> completeTag(String query) {
        List<Tag> allTags = service.findAll();
        List<Tag> filteredTags = new ArrayList<>();
         
        for (int i = 0; i < allTags.size(); i++) {
            Tag t = allTags.get(i);
            if(t.getName().toLowerCase().contains(query)) {
                filteredTags.add(t);
            }
        }
         
        return filteredTags;
    }
    
    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }
    
    
    
}

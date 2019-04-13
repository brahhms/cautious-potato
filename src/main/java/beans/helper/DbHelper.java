package beans.helper;

import eis.DBService;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import javax.inject.Named;
import javax.persistence.metamodel.EntityType;

@Named
@RequestScoped
public class DbHelper implements Serializable{

    @Inject
    private DBService service;
    
    private List<String> entities;
    private EntityType<?> ent;
    private List records;
    private String entityName; 

    
    @PostConstruct
    public void init() {
        entities = service.getTables();
    }


    public List<String> getEntities() {
        return entities;
    }

    public void setEntities(List<String> entities) {
        this.entities = entities;
    }

    public EntityType<?> getEnt() {
        return ent;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
        ent = service.getEntity(entityName);
        records = service.findAll(ent.getJavaType());
    }


    



}

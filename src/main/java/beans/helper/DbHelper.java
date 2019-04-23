package beans.helper;

import eis.DBService;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import javax.inject.Named;
import javax.persistence.metamodel.Attribute;
import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.SingularAttribute;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;

@Named
@ViewScoped
public class DbHelper implements Serializable {

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
        //findAll de la clase enviada como parametro
        records = service.findAll(ent.getJavaType());
    }

    public void onRowEdit(RowEditEvent event) {
       

        FacesMessage msg = new FacesMessage("Object Edited", event.getObject().toString());
        FacesContext.getCurrentInstance().addMessage(null, msg);
        
        DataTable table = (DataTable) event.getSource();
        service.edit(table.getRowData());
    }


}

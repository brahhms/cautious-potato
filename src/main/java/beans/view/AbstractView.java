package beans.view;

import eis.AbstractFacade;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.metamodel.SingularAttribute;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.LazyDataModel;

/**
 *
 * @author abraham
 * @param <T>
 */

public abstract class AbstractView<T> implements Serializable{

    protected T object;
    LazyDataModel<T> lazyModel;

    public void init(T object) {
        this.object = object;
        this.lazyModel = buildModel();
    }

    public void newRecord() {
        facade().create(object);       
        clearObject();
    }

    public void removeRecord() {
        facade().remove(object);
        clearObject();

    }

    public void updateRecord() {
        facade().edit(object);
        clearObject();
    }

    protected List getRecords(int first, int pageSize) {
            return facade().findRange(new int[]{first, pageSize});
    }

    protected LazyDataModel buildModel() {
        return new LazyDataModel<T>() {
            @Override
            public Object getRowKey(T entity) {
                return rowKey(entity);
            }

            @Override
            public T getRowData(String rowKey) {
                return getRData(rowKey);
            }

            @Override
            public List<T> load(int first, int pageSize, String sortField, org.primefaces.model.SortOrder sortOrder, Map<String, Object> filters) {
                this.setRowCount(facade().count());
                return getRecords(first, first+pageSize);
            }
        };
    }

    public LazyDataModel<T> getLazyModel() {
        return lazyModel;
    }

    protected abstract AbstractFacade facade();

    protected abstract Object rowKey(T entity);

    protected abstract T getRData(String rowKey);

    public abstract T getObject();

    public void setObject(T object) {
        this.object = object;
    }

    public void clearObject() {
        try {
            this.object = (T) object.getClass().newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(AbstractView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void onRowSelect(SelectEvent event) {
        this.object = (T) event.getObject();
    }

    public Set<SingularAttribute> getAttributes() {
        return facade().getAttributes();
    }

}

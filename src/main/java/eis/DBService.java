package eis;

import domain.Post;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 *
 * @author abraham
 */
@Stateless
public class DBService {

    @PersistenceContext(unitName = "potatoPU")
    private EntityManager em;

    public List<String> getTables() {
        List<String> tables = new ArrayList<>();
        for (EntityType<?> entity : em.getMetamodel().getEntities()) {
            tables.add(entity.getName());
        }
        return tables;
    }

    public EntityType<?> getEntity(String entityName) {

        for (EntityType<?> entity : em.getMetamodel().getEntities()) {
            if (entity.getName().equals(entityName)) {
                return entity;
            }
        }
        return null;
    }

    public List findAll(Class entityClass) {
        javax.persistence.criteria.CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return em.createQuery(cq).getResultList();
    }

    public void edit(Object rowData) {
        em.merge(rowData);
    }

}

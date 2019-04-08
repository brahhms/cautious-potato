package eis;

import domain.Post;
import domain.PostType;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author abraham
 */
@Stateless
public class PostFacade extends AbstractFacade<Post> {

    @PersistenceContext(unitName = "potatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PostFacade() {
        super(Post.class);
    }

    public List<Post> findPostByType(int id) {
        TypedQuery tq = em.createNamedQuery("Post.findByPostTypeId", Post.class);
        tq.setParameter("postTypeId", new PostType(id));

        return tq.getResultList();
    }

    public List<Post> findPostByParentId(int id) {
        TypedQuery tq = em.createNamedQuery("Post.findByParentId", Post.class);
        tq.setParameter("parentId", new Post(id));

        return tq.getResultList();
    }

}

package org.bloogging.integration.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.bloogging.entities.*;


@Stateless
public class PostDAO extends AbstractDAO<Post>{
    @PersistenceContext
    private EntityManager em;

    public PostDAO() {
        super(Post.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
   public List<Post> findPostByDate(Date date){
       Query query = getEntityManager().createQuery(
              "select Post from Post post"
              +" where post.date= :dateP");
        /*
        No se puede colocar directamente el objeto porque inyectaría el objeto
        y no es conveniente colocar un string porque no podemos dejar abierto 
        que nos metan un valor por string, ya que dicho string podrían poner
        una subquery que devirtuaría todo
        */
        
      query.setParameter("daterP",date);
      return query.getResultList();
    }

}

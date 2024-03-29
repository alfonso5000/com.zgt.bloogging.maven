package org.bloogging.integration.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.bloogging.entities.*;

@Stateless
public class AuthorDAO extends AbstractDAO<Author>{
    @PersistenceContext
    private EntityManager em;

    public AuthorDAO() {
        super(Author.class);
    }

      
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
   
            
    public List<Post> findPostByAuthor(Author author){
        Query query = getEntityManager().createQuery(
                "select Post from Post post"
                +" where post.author= :authorP");
        /*
        No se puede colocar directamente el objeto porque inyectaría el objeto
        y no es conveniente colocar un string porque no podemos dejar abierto 
        que nos metan un valor por string, ya que dicho string podrían poner
        una subquery que devirtuaría todo
        */
        
        query.setParameter("authorP",author);
        return query.getResultList();
    }
}

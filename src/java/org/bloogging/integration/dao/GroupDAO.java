package org.bloogging.integration.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.bloogging.entities.Author;
import org.bloogging.entities.Group;


@Stateless
public class GroupDAO extends AbstractDAO<Group>{
    @PersistenceContext(unitName="BlooggingPU")
    private EntityManager em;

    public GroupDAO() {
        super(Group.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
    public List<Author> findAuthorByGroup(Group group){
        Query query = getEntityManager().createQuery(
                "select author from Author author"
                +" where author.group= :groupP");
        /*
        No se puede colocar directamente el objeto porque inyectaría el objeto
        y no es conveniente colocar un string porque no podemos dejar abierto 
        que nos metan un valor por string, ya que dicho string podrían poner
        una subquery que devirtuaría todo
        */
        
        query.setParameter("groupP",group);
        return query.getResultList();
    }
    
    
}

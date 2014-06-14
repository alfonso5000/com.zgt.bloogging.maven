
package org.bloogging.integration.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.bloogging.entities.*;

@Stateless
public class TagDAO extends AbstractDAO<Tag>{
    @PersistenceContext(unitName="BlooggingPU")
    private EntityManager em;

    public TagDAO() {
        super(Tag.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

  
    
}

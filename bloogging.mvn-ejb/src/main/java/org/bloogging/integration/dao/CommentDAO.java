package org.bloogging.integration.dao;

import java.util.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.bloogging.entities.*;

@Stateless
public class CommentDAO extends AbstractDAO<Comment>{
    @PersistenceContext
    private EntityManager em;

  
    public CommentDAO() {
        super(Comment.class);
    }

       
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
    
}

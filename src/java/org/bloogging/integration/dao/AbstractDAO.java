package org.bloogging.integration.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

public abstract class AbstractDAO<T> {
    private Class entity;
    
    protected AbstractDAO(Class entity){
        this.entity = entity;
    }
    
    public abstract EntityManager getEntityManager();
    
    public void create(T newEntity){
        getEntityManager().persist(newEntity);
    }
    
    public void update(T newEntity){
        getEntityManager().merge(newEntity);
    }
    
     public void delete(T oldEntity){
        getEntityManager().remove(oldEntity);
    }
     
     public T findByPK(Object id){
        return (T) getEntityManager().find(entity,id);
    }
     
    public List<T> getAll(){
        Query query =getEntityManager().createQuery(
                "select obj from T obj");
        return query.getResultList();
    } 
}

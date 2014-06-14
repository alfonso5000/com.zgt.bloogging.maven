package org.bloogging.integration.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.bloogging.entities.Post;

@Stateless
public class BlooggingDAO {
    @PersistenceContext(unitName="BlooggingPU")
    private EntityManager em;
    
    public void createPost(Post post) {
        em.persist(post);
    }
    
    public Post findPostByPK(Integer id) throws Exception{
        Post postF=em.find(Post.class, id);
        if (postF== null) 
            throw new Exception("Post: "+id+" not found!!");
        return postF;
    }
}

package org.bloogging.svc;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.bloogging.entities.*;
import org.bloogging.integration.dao.*;


@Stateless
public class BlooggingModel {
    //@PersistenceContext(unitName="BlooggingPU")
    //private EntityManager em;
    @EJB
    private AuthorDAO authorDAO;
    @EJB
    private GroupDAO groupDAO;
    @EJB
    private PostDAO postDAO;
    @EJB
    private CommentDAO commentDAO;
    
/*
    @Override
    public EntityManager getEntityManager() {
        return em;
    }
  */  
     public void createGroup(Group group)throws Exception{
        
         if (groupDAO.findByPK(group.getName()) == null){
             System.out.println("No encontrado");
             groupDAO.create(group);
         }
         else
             throw new Exception("Grupo duplicado");
             
       }

     
     public void createAuthor(Author author){
         
         if (groupDAO.findByPK(author.getGroup().getName()) == null)
             groupDAO.create(author.getGroup());
        authorDAO.create(author);
     }
     
     public void createPost(Post post){
         
         if (groupDAO.findByPK(post.getAuthor().getGroup().getName()) == null)
             groupDAO.create(post.getAuthor().getGroup());
         
         if (authorDAO.findByPK(post.getAuthor().getUsername()) == null)
             authorDAO.create(post.getAuthor());

        postDAO.create(post);
     }
     
     public void anadirComment(Comment comment){
       if (postDAO.findByPK(comment.getPost().getPostId()) != null)
             commentDAO.create(comment);
     }
}

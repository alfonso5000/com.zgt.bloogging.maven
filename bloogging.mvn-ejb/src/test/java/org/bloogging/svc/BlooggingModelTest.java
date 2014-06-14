package org.bloogging.svc;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.UserTransaction;
import org.bloogging.entities.*;
import org.bloogging.integration.dao.GroupDAO;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author student
 */
public class BlooggingModelTest {
    
    static EJBContainer container;
    //static EntityManagerFactory emf;

    
    public BlooggingModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NamingException {
        
        Map<String, Object> properties = new HashMap<String, Object>();  
        properties.put("org.glassfish.ejb.embedded.glassfish.configuration.file",   
            "./src/test/glassfish-resources/domain.xml");  
        container = EJBContainer.createEJBContainer(properties);          
       //EntityManagerFactory emf = Persistence.createEntityManagerFactory("BlooggingPU");
       //EntityManager em = (EntityManager) new InitialContext().lookup("java:comp/env/persistence/em");


    }
    
    @AfterClass
    public static void tearDownClass() {
        container.close();
    }
    
    @Before
    public void setUp() throws Exception {
        
//        BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");        
//        assertNotNull(instance);
//        EntityManager em = instance.getEntityManager();
//        assertNotNull(em);
//
//        em.getTransaction().begin();
//                
//        em.createQuery("delete from Comment").executeUpdate();
//        em.createQuery("delete from Post").executeUpdate();
//        em.createQuery("delete from Group").executeUpdate();
//        em.createQuery("delete from Author").executeUpdate();
//
//        em.getTransaction().commit();
        
    }
    
    @After
    public void tearDown() {
        
    }

    /**
     * Test of createGroup method, of class BlooggingModel.
     * @throws java.lang.Exception
     */
    
    @Test
    public void testCreateGroup() throws Exception {
        try{
            System.out.println("createGroup");
            Group group = new Group("grupo1" , "descripcion del grupo1");
            //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
            BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");
            instance.createGroup(group);
            //container.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        
    }

    /**
     * Test of createAuthor method, of class BlooggingModel.
     */
    @Test
    public void testCreateAuthor() throws Exception {
        System.out.println("createAuthor");
        Author author = new Author("Shakespeare","password",new Group("Shakespeare Group","Description"));
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");
        instance.createAuthor(author);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of createPost method, of class BlooggingModel.
     */
    @Test
    public void testCreatePost() throws Exception {
        System.out.println("createPost");
        Post post = new Post("Test Post","Contenido del Post",new Date(),
               new Author("miguel 2","miguel",new Group("authors","grupo de prueba")));
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");
        instance.createPost(post);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }

    /**
     * Test of anadirComment method, of class BlooggingModel.
     */
    @Test
    public void testAnadirComment() throws Exception {
        System.out.println("anadirComment");
        Post post = new Post("Test Post","Contenido del Post",new Date(),
               new Author("miguel","miguel",new Group("authors 2","grupo de prueba")));
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");
        instance.createPost(post);
        Comment comment = new Comment("This a comment","Smith","smith@gmail.com",5,post);
        instance.anadirComment(comment);
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

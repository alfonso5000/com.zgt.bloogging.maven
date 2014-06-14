package org.bloogging.svc;

import java.util.Date;
import javax.ejb.embeddable.EJBContainer;
import org.bloogging.entities.*;
import org.bloogging.integration.dao.GroupDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author student
 */
public class BlooggingModelTest {
    
    //static EJBContainer container;
    
    public BlooggingModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
      //container = javax.ejb.embeddable.EJBContainer.createEJBContainer();  
    }
    
    @AfterClass
    public static void tearDownClass() {
        //container.close();
    }
    
    @Before
    public void setUp() {
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
            EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
            BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");
            instance.createGroup(group);
            container.close();
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
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");
        instance.createAuthor(author);
        container.close();
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
               new Author("miguel","miguel",new Group("authors","grupo de prueba")));
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");
        instance.createPost(post);
        container.close();
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
               new Author("miguel","miguel",new Group("authors","grupo de prueba")));
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BlooggingModel instance = (BlooggingModel)container.getContext().lookup("java:global/classes/BlooggingModel");
        instance.createPost(post);
        Comment comment = new Comment("This a comment","Smith","smith@gmail.com",5,post);
        instance.anadirComment(comment);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

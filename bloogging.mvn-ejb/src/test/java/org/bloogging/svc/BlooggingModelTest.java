package org.bloogging.svc;

import java.util.Date;

import javax.ejb.EJB;

import org.bloogging.entities.*;
import org.bloogging.integration.dao.BlooggingDAO;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(Arquillian.class)
public class BlooggingModelTest {
 
	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addPackage(BlooggingDAO.class.getPackage())
				.addPackage(Author.class.getPackage())
				.addPackage(BlooggingModel.class.getPackage())
				.addPackage(BlooggingModelTestHelper.class.getPackage())
				.addAsResource("test-persistence.xml","META-INF/persistence.xml");
	}
	
    public BlooggingModelTest() {
    }
    
    
    @EJB
    BlooggingModelTestHelper blooggingModelTestHelper;
    
    @EJB
    BlooggingModel blooggingModel;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception {
        assertNotNull(blooggingModelTestHelper);
        blooggingModelTestHelper.clean();
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
        System.out.println("createGroup");
        Group group = new Group("grupo1" , "descripcion del grupo1");
        blooggingModel.createGroup(group);
    }

    /**
     * Test of createAuthor method, of class BlooggingModel.
     */
    @Test
    public void testCreateAuthor() throws Exception {
        System.out.println("createAuthor");
        Author author = new Author("Shakespeare","password",new Group("Shakespeare Group","Description"));
        blooggingModel.createAuthor(author);
    }

    /**
     * Test of createPost method, of class BlooggingModel.
     */
    @Test
    public void testCreatePost() throws Exception {
        System.out.println("createPost");
        Post post = new Post("Test Post","Contenido del Post",new Date(),
               new Author("miguel","miguel",new Group("authors","grupo de prueba")));
        blooggingModel.createPost(post);
    }

    /**
     * Test of anadirComment method, of class BlooggingModel.
     */
    @Test
    public void testAnadirComment() throws Exception {
        System.out.println("anadirComment");
        Post post = new Post("Test Post","Contenido del Post",new Date(),
               new Author("miguel","miguel",new Group("authors","grupo de prueba")));
        blooggingModel.createPost(post);
        Comment comment = new Comment("This a comment","Smith","smith@gmail.com",5,post);
        blooggingModel.anadirComment(comment);
    }
    
}

package org.bloogging.svc;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.annotation.Resource;
import javax.ejb.embeddable.EJBContainer;
import javax.inject.Inject;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.transaction.NotSupportedException;
import javax.transaction.UserTransaction;

import org.apache.commons.io.FileUtils;
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
    static Context ctx;

    public BlooggingModelTest() {
    }
    
    
    private static final String MODULE_NAME = "test";  
    private static final String TARGET_DIR = "target/" + MODULE_NAME;      
    
    
    private static File prepareModuleDirectory() throws IOException {  
        File result = new File(TARGET_DIR);  
        FileUtils.copyDirectory(new File("target/classes"), result);  
        FileUtils.copyDirectory(new File("target/test-classes"), result);  
        return result;  
    }
    
    @SuppressWarnings("unchecked")
	protected <T> T lookupBy(Class<T> type) throws NamingException {  
        return (T) ctx.lookup("java:global/" + MODULE_NAME + "/"  
                + type.getSimpleName());  
    }     
    
    
    @BeforeClass
    public static void setUpClass() throws Exception {
    	File target = prepareModuleDirectory();
    	Map<String, Object> properties = new HashMap<String,Object>();
    	properties.put(EJBContainer.MODULES, target);
        container = EJBContainer.createEJBContainer(properties);  
        ctx = container.getContext();
    }
    
    @AfterClass
    public static void tearDownClass() {
        container.close();
    }
    
    @Before
    public void setUp() throws Exception {
    	BlooggingModelTestHelper helper = lookupBy(BlooggingModelTestHelper.class);
        assertNotNull(helper);
        helper.clean();
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
            BlooggingModel instance = lookupBy(BlooggingModel.class);
            instance.createGroup(group);
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
        BlooggingModel instance = lookupBy(BlooggingModel.class);
        instance.createAuthor(author);
    }

    /**
     * Test of createPost method, of class BlooggingModel.
     */
    @Test
    public void testCreatePost() throws Exception {
        System.out.println("createPost");
        Post post = new Post("Test Post","Contenido del Post",new Date(),
               new Author("miguel","miguel",new Group("authors","grupo de prueba")));
        BlooggingModel instance = lookupBy(BlooggingModel.class);
        instance.createPost(post);
    }

    /**
     * Test of anadirComment method, of class BlooggingModel.
     */
    @Test
    public void testAnadirComment() throws Exception {
        System.out.println("anadirComment");
        Post post = new Post("Test Post","Contenido del Post",new Date(),
               new Author("miguel","miguel",new Group("authors","grupo de prueba")));
        BlooggingModel instance = lookupBy(BlooggingModel.class);
        instance.createPost(post);
        Comment comment = new Comment("This a comment","Smith","smith@gmail.com",5,post);
        instance.anadirComment(comment);
    }
    
}

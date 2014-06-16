/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bloogging.integration.dao;

import java.util.Date;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;

import org.apache.commons.io.FileUtils;
import org.bloogging.entities.Author;
import org.bloogging.entities.Group;
import org.bloogging.entities.Post;
import org.junit.After;
import org.junit.AfterClass;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.lang.IllegalArgumentException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author student
 */
public class BlooggingDAOTest {
    
    static EJBContainer container;
    static Context ctx;
    
    public BlooggingDAOTest() {
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
    public static void setUpClass() throws IOException {
    	File target = prepareModuleDirectory();
    	Map<String,Object> properties = new HashMap<String,Object>();
    	properties.put(EJBContainer.MODULES, target);
        container = EJBContainer.createEJBContainer(properties);
        ctx = container.getContext();
    }
    
    @AfterClass
    public static void tearDownClass() {
        container.close();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of createPost method, of class BlooggingDAO.
     */
    @Test
    public void testCreatePost() throws Exception {
        System.out.println("createPost");
        
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();

        Post post = new Post("Test Post","Contenido del Post",new Date(),
               new Author("miguel","miguel",new Group("authors","grupo de prueba")));
        BlooggingDAO instance = lookupBy(BlooggingDAO.class);
        instance.createPost(post);
  
    }

    /**
     * Test of findPostByPK method, of class BlooggingDAO.
     */
    @Test
    public void testFindPostByPK() throws Exception {
        System.out.println("findPostByPK");
        Integer id = new Integer(5);
        BlooggingDAO instance = lookupBy(BlooggingDAO.class);
        Post expResult = null;
        try{
            Post result = instance.findPostByPK(id);
            assertEquals(expResult, result);
            fail("Should have thrown an exception");
        }
        catch(Exception e){
            // ignore
        }
    }
    
}

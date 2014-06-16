/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bloogging.integration.dao;

import java.util.Date;
import javax.ejb.embeddable.EJBContainer;
import org.bloogging.entities.Author;
import org.bloogging.entities.Group;
import org.bloogging.entities.Post;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.IllegalArgumentException;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author student
 */
public class BlooggingDAOTest {
    
    static EJBContainer container;
    
    public BlooggingDAOTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        container = EJBContainer.createEJBContainer();          
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
        
        BlooggingDAO instance = (BlooggingDAO)container.getContext().lookup("java:global/ejb-app/classes/BlooggingDAO");
        instance.createPost(post);
        //container.close();
  
    }

    /**
     * Test of findPostByPK method, of class BlooggingDAO.
     */
    @Test
    public void testFindPostByPK() throws Exception {
        System.out.println("findPostByPK");
        Integer id = new Integer(5);
        //EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        BlooggingDAO instance = (BlooggingDAO)container.getContext().lookup("java:global/ejb-app/classes/BlooggingDAO");
        Post expResult = null;
        try{
            Post result = instance.findPostByPK(id);
            assertEquals(expResult, result);
            fail("Should have thrown an exception");
        }
        catch(Exception e){
            // ignore
        }
        //container.close();
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
}

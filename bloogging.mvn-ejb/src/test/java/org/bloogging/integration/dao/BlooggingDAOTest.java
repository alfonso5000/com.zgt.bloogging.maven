/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.bloogging.integration.dao;

import java.util.Date;

import javax.ejb.EJB;

import org.bloogging.entities.Author;
import org.bloogging.entities.Group;
import org.bloogging.entities.Post;
import org.bloogging.svc.BlooggingModel;
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

import java.io.IOException;

@RunWith(Arquillian.class)
public class BlooggingDAOTest {

	@Deployment
	public static Archive<?> createDeployment() {
		return ShrinkWrap
				.create(JavaArchive.class, "test.jar")
				.addPackage(BlooggingDAO.class.getPackage())
				.addPackage(Author.class.getPackage())
				.addPackage(BlooggingModel.class.getPackage())
				.addAsResource("test-persistence.xml","META-INF/persistence.xml");
	}
	
	
    public BlooggingDAOTest() {
    }

    @BeforeClass
    public static void setUpClass() throws IOException {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @EJB
    BlooggingDAO blooggingDAO;
    
    
    /**
     * Test of createPost method, of class BlooggingDAO.
     */
    @Test
    public void testCreatePost() throws Exception {
        System.out.println("createPost");
        Post post = new Post("Test Post","Contenido del Post",new Date(),
               new Author("miguel","miguel",new Group("authors","grupo de prueba")));

        blooggingDAO.createPost(post);
  
    }

    /**
     * Test of findPostByPK method, of class BlooggingDAO.
     */
    @Test
    public void testFindPostByPK() throws Exception {
        System.out.println("findPostByPK");
        Integer id = new Integer(5);
        Post expResult = null;
        try{
            Post result = blooggingDAO.findPostByPK(id);
            assertEquals(expResult, result);
            fail("Should have thrown an exception");
        }
        catch(Exception e){
            // ignore
        }
    }
    
}

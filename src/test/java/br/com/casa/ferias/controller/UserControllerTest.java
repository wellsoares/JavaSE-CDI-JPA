package br.com.casa.ferias.controller;

import br.com.casa.ferias.model.User;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author well
 */
public class UserControllerTest {

    public UserControllerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
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

    /**
     * Test of saveUser method, of class UserController.
     */
    @Test
    public void testSaveUser() {
        System.out.println("saveUser");
        User u = null;
        UserController instance = new UserController();
        instance.saveUser(u);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findAll method, of class UserController.
     */
    @Test
    public void testFindAll() {
        System.out.println("findAll");
        UserController instance = new UserController();
        List<User> expResult = null;
        List<User> result = instance.findAll();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getById method, of class UserController.
     */
    @Test
    public void testGetById() {

        Integer id = 1;
        UserController instance = new UserController();
        User expResult = new User(1);
        User result = instance.getById(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}

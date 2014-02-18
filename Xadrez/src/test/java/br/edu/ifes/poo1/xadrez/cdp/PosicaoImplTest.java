/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lincoln
 */
public class PosicaoImplTest {
    
    public PosicaoImplTest() {
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
     * Test of getId method, of class PosicaoImpl.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        PosicaoImpl instance = null;
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeca method, of class PosicaoImpl.
     */
    @Test
    public void testGetPeca() {
        System.out.println("getPeca");
        PosicaoImpl instance = null;
        Peca expResult = null;
        Peca result = instance.getPeca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeca method, of class PosicaoImpl.
     */
    @Test
    public void testSetPeca() {
        System.out.println("setPeca");
        Peca peca = null;
        PosicaoImpl instance = null;
        instance.setPeca(peca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existePeca method, of class PosicaoImpl.
     */
    @Test
    public void testExistePeca() {
        System.out.println("existePeca");
        PosicaoImpl instance = null;
        boolean expResult = false;
        boolean result = instance.existePeca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class PosicaoImpl.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        PosicaoImpl instance = null;
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

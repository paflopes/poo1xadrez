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
public class PosicaoTest {
    
    public PosicaoTest() {
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
     * Test of getId method, of class Posicao.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Posicao instance = new PosicaoImpl();
        String expResult = "";
        String result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPeca method, of class Posicao.
     */
    @Test
    public void testGetPeca() {
        System.out.println("getPeca");
        Posicao instance = new PosicaoImpl();
        Peca expResult = null;
        Peca result = instance.getPeca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPeca method, of class Posicao.
     */
    @Test
    public void testSetPeca() {
        System.out.println("setPeca");
        Peca peca = null;
        Posicao instance = new PosicaoImpl();
        instance.setPeca(peca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of existePeca method, of class Posicao.
     */
    @Test
    public void testExistePeca() {
        System.out.println("existePeca");
        Posicao instance = new PosicaoImpl();
        boolean expResult = false;
        boolean result = instance.existePeca();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class Posicao.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        Posicao instance = new PosicaoImpl();
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PosicaoImpl implements Posicao {

        public String getId() {
            return "";
        }

        public Peca getPeca() {
            return null;
        }

        public void setPeca(Peca peca) {
        }

        public boolean existePeca() {
            return false;
        }

        public Object clone() throws CloneNotSupportedException {
            return null;
        }
    }
    
}

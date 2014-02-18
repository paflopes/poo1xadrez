/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.util.List;
import java.util.Map;
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
public class TabuleiroTest {
    
    public TabuleiroTest() {
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
     * Test of getPosicao method, of class Tabuleiro.
     */
    @Test
    public void testGetPosicao() {
        System.out.println("getPosicao");
        String id = "";
        Tabuleiro instance = new Tabuleiro();
        Posicao expResult = null;
        Posicao result = instance.getPosicao(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosicaoRei method, of class Tabuleiro.
     */
    @Test
    public void testGetPosicaoRei() {
        System.out.println("getPosicaoRei");
        Cor cor = null;
        Tabuleiro instance = new Tabuleiro();
        Posicao expResult = null;
        Posicao result = instance.getPosicaoRei(cor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosicoes method, of class Tabuleiro.
     */
    @Test
    public void testGetPosicoes() {
        System.out.println("getPosicoes");
        Tabuleiro instance = new Tabuleiro();
        Map<String, Posicao> expResult = null;
        Map<String, Posicao> result = instance.getPosicoes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPecas method, of class Tabuleiro.
     */
    @Test
    public void testGetPecas() {
        System.out.println("getPecas");
        Cor cor = null;
        Tabuleiro instance = new Tabuleiro();
        List<Peca> expResult = null;
        List<Peca> result = instance.getPecas(cor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Tabuleiro.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Tabuleiro instance = new Tabuleiro();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

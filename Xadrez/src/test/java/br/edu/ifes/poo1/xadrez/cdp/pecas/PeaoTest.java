/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
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
public class PeaoTest {
    
    public PeaoTest() {
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
     * Test of moveuUmaVez method, of class Peao.
     */
    @Test
    public void testMoveuUmaVez() {
        System.out.println("moveuUmaVez");
        Peao instance = null;
        boolean expResult = false;
        boolean result = instance.moveuUmaVez();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicao method, of class Peao.
     */
    @Test
    public void testSetPosicao() {
        System.out.println("setPosicao");
        Posicao posicao = null;
        Peao instance = null;
        instance.setPosicao(posicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarMovimento method, of class Peao.
     */
    @Test
    public void testValidarMovimento() {
        System.out.println("validarMovimento");
        Posicao novaPosicao = null;
        Partida partida = null;
        Peao instance = null;
        boolean expResult = false;
        boolean result = instance.validarMovimento(novaPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarMovimentoCaptura method, of class Peao.
     */
    @Test
    public void testValidarMovimentoCaptura() {
        System.out.println("validarMovimentoCaptura");
        Posicao novaPosicao = null;
        Partida partida = null;
        Peao instance = null;
        boolean expResult = false;
        boolean result = instance.validarMovimentoCaptura(novaPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

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
public class ReiTest {
    
    public ReiTest() {
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
     * Test of validarMovimento method, of class Rei.
     */
    @Test
    public void testValidarMovimento() {
        System.out.println("validarMovimento");
        Posicao novaPosicao = null;
        Partida partida = null;
        Rei instance = null;
        boolean expResult = false;
        boolean result = instance.validarMovimento(novaPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarMovimentoCaptura method, of class Rei.
     */
    @Test
    public void testValidarMovimentoCaptura() {
        System.out.println("validarMovimentoCaptura");
        Posicao novaPosicao = null;
        Partida partida = null;
        Rei instance = null;
        boolean expResult = false;
        boolean result = instance.validarMovimentoCaptura(novaPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

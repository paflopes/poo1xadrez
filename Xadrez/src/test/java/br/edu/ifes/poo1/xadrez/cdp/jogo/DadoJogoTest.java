/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp.jogo;

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
public class DadoJogoTest {
    
    public DadoJogoTest() {
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
     * Test of getNome method, of class DadoJogo.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        DadoJogo instance = new DadoJogo();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class DadoJogo.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        DadoJogo instance = new DadoJogo();
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPontos method, of class DadoJogo.
     */
    @Test
    public void testGetPontos() {
        System.out.println("getPontos");
        DadoJogo instance = new DadoJogo();
        int expResult = 0;
        int result = instance.getPontos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPontos method, of class DadoJogo.
     */
    @Test
    public void testSetPontos() {
        System.out.println("setPontos");
        int pontos = 0;
        DadoJogo instance = new DadoJogo();
        instance.setPontos(pontos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

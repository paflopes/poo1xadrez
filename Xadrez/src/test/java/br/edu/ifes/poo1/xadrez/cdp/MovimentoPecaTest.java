/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import java.util.List;
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
public class MovimentoPecaTest {
    
    public MovimentoPecaTest() {
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
     * Test of isDiagonal method, of class MovimentoPeca.
     */
    @Test
    public void testIsDiagonal() {
        System.out.println("isDiagonal");
        Posicao posicaoAtual = null;
        Posicao novaPosicao = null;
        boolean expResult = false;
        boolean result = MovimentoPeca.isDiagonal(posicaoAtual, novaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isStraight method, of class MovimentoPeca.
     */
    @Test
    public void testIsStraight() {
        System.out.println("isStraight");
        Posicao posicaoAtual = null;
        Posicao novaPosicao = null;
        boolean expResult = false;
        boolean result = MovimentoPeca.isStraight(posicaoAtual, novaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isEnPassant method, of class MovimentoPeca.
     */
    @Test
    public void testIsEnPassant() {
        System.out.println("isEnPassant");
        Posicao posicaoAtual = null;
        Posicao novaPosicao = null;
        Partida partida = null;
        boolean expResult = false;
        boolean result = MovimentoPeca.isEnPassant(posicaoAtual, novaPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isXeque method, of class MovimentoPeca.
     */
    @Test
    public void testIsXeque() {
        System.out.println("isXeque");
        Posicao posicaoAtual = null;
        Posicao posicaoFinal = null;
        Partida partida = null;
        boolean expResult = false;
        boolean result = MovimentoPeca.isXeque(posicaoAtual, posicaoFinal, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isXequeMate method, of class MovimentoPeca.
     */
    @Test
    public void testIsXequeMate() {
        System.out.println("isXequeMate");
        Posicao posicaoAtual = null;
        Posicao posicaoFinal = null;
        Partida partida = null;
        boolean expResult = false;
        boolean result = MovimentoPeca.isXequeMate(posicaoAtual, posicaoFinal, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRoqueMaior method, of class MovimentoPeca.
     */
    @Test
    public void testIsRoqueMaior() {
        System.out.println("isRoqueMaior");
        Posicao posicaoAtual = null;
        Partida partida = null;
        boolean expResult = false;
        boolean result = MovimentoPeca.isRoqueMaior(posicaoAtual, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isRoqueMenor method, of class MovimentoPeca.
     */
    @Test
    public void testIsRoqueMenor() {
        System.out.println("isRoqueMenor");
        Posicao posicaoAtual = null;
        Partida partida = null;
        boolean expResult = false;
        boolean result = MovimentoPeca.isRoqueMenor(posicaoAtual, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of haPeca method, of class MovimentoPeca.
     */
    @Test
    public void testHaPeca() {
        System.out.println("haPeca");
        List<String> caminho = null;
        Partida partida = null;
        boolean expResult = false;
        boolean result = MovimentoPeca.haPeca(caminho, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caminhoReto method, of class MovimentoPeca.
     */
    @Test
    public void testCaminhoReto() {
        System.out.println("caminhoReto");
        Posicao posicaoAtual = null;
        Posicao novaPosicao = null;
        List<String> expResult = null;
        List<String> result = MovimentoPeca.caminhoReto(posicaoAtual, novaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of caminhoDiagonal method, of class MovimentoPeca.
     */
    @Test
    public void testCaminhoDiagonal() {
        System.out.println("caminhoDiagonal");
        Posicao posicaoAtual = null;
        Posicao novaPosicao = null;
        List<String> expResult = null;
        List<String> result = MovimentoPeca.caminhoDiagonal(posicaoAtual, novaPosicao);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

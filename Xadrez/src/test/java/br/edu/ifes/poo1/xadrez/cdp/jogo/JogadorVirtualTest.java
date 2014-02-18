/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
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
public class JogadorVirtualTest {
    
    public JogadorVirtualTest() {
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
     * Test of getJogada method, of class JogadorVirtual.
     */
    @Test
    public void testGetJogada() {
        System.out.println("getJogada");
        Partida partida = null;
        JogadorVirtual instance = new JogadorVirtual();
        Jogada expResult = null;
        Jogada result = instance.getJogada(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCor method, of class JogadorVirtual.
     */
    @Test
    public void testGetCor() {
        System.out.println("getCor");
        JogadorVirtual instance = new JogadorVirtual();
        Cor expResult = null;
        Cor result = instance.getCor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class JogadorVirtual.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        JogadorVirtual instance = new JogadorVirtual();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVitoria method, of class JogadorVirtual.
     */
    @Test
    public void testSetVitoria() {
        System.out.println("setVitoria");
        boolean vitoria = false;
        JogadorVirtual instance = new JogadorVirtual();
        instance.setVitoria(vitoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizaPontosJogador method, of class JogadorVirtual.
     */
    @Test
    public void testAtualizaPontosJogador() {
        System.out.println("atualizaPontosJogador");
        Posicao novaPosicao = null;
        JogadorVirtual instance = new JogadorVirtual();
        instance.atualizaPontosJogador(novaPosicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVitoria method, of class JogadorVirtual.
     */
    @Test
    public void testIsVitoria() {
        System.out.println("isVitoria");
        JogadorVirtual instance = new JogadorVirtual();
        boolean expResult = false;
        boolean result = instance.isVitoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSave method, of class JogadorVirtual.
     */
    @Test
    public void testSetSave() {
        System.out.println("setSave");
        boolean save = false;
        JogadorVirtual instance = new JogadorVirtual();
        instance.setSave(save);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPecasCapturadas method, of class JogadorVirtual.
     */
    @Test
    public void testSetPecasCapturadas() {
        System.out.println("setPecasCapturadas");
        Peca peca = null;
        JogadorVirtual instance = new JogadorVirtual();
        instance.setPecasCapturadas(peca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPecasCapturadas method, of class JogadorVirtual.
     */
    @Test
    public void testGetPecasCapturadas() {
        System.out.println("getPecasCapturadas");
        JogadorVirtual instance = new JogadorVirtual();
        String expResult = "";
        String result = instance.getPecasCapturadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

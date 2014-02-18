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
public class JogadorHumanoTest {
    
    public JogadorHumanoTest() {
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
     * Test of getNome method, of class JogadorHumano.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        JogadorHumano instance = null;
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNome method, of class JogadorHumano.
     */
    @Test
    public void testSetNome() {
        System.out.println("setNome");
        String nome = "";
        JogadorHumano instance = null;
        instance.setNome(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJogada method, of class JogadorHumano.
     */
    @Test
    public void testGetJogada() {
        System.out.println("getJogada");
        Partida partida = null;
        JogadorHumano instance = null;
        Jogada expResult = null;
        Jogada result = instance.getJogada(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJogada method, of class JogadorHumano.
     */
    @Test
    public void testSetJogada() {
        System.out.println("setJogada");
        Jogada jogada = null;
        JogadorHumano instance = null;
        instance.setJogada(jogada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJogadaAnterior method, of class JogadorHumano.
     */
    @Test
    public void testGetJogadaAnterior() {
        System.out.println("getJogadaAnterior");
        JogadorHumano instance = null;
        Jogada expResult = null;
        Jogada result = instance.getJogadaAnterior();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJogadaAnterior method, of class JogadorHumano.
     */
    @Test
    public void testSetJogadaAnterior() {
        System.out.println("setJogadaAnterior");
        Jogada jogadaAnterior = null;
        JogadorHumano instance = null;
        instance.setJogadaAnterior(jogadaAnterior);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPontos method, of class JogadorHumano.
     */
    @Test
    public void testGetPontos() {
        System.out.println("getPontos");
        JogadorHumano instance = null;
        int expResult = 0;
        int result = instance.getPontos();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPontos method, of class JogadorHumano.
     */
    @Test
    public void testSetPontos() {
        System.out.println("setPontos");
        int pontos = 0;
        JogadorHumano instance = null;
        instance.setPontos(pontos);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVitoria method, of class JogadorHumano.
     */
    @Test
    public void testIsVitoria() {
        System.out.println("isVitoria");
        JogadorHumano instance = null;
        boolean expResult = false;
        boolean result = instance.isVitoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVitoria method, of class JogadorHumano.
     */
    @Test
    public void testSetVitoria() {
        System.out.println("setVitoria");
        boolean vitoria = false;
        JogadorHumano instance = null;
        instance.setVitoria(vitoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCor method, of class JogadorHumano.
     */
    @Test
    public void testGetCor() {
        System.out.println("getCor");
        JogadorHumano instance = null;
        Cor expResult = null;
        Cor result = instance.getCor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizaPontosJogador method, of class JogadorHumano.
     */
    @Test
    public void testAtualizaPontosJogador() {
        System.out.println("atualizaPontosJogador");
        Posicao novaPosicao = null;
        JogadorHumano instance = null;
        instance.atualizaPontosJogador(novaPosicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSave method, of class JogadorHumano.
     */
    @Test
    public void testSetSave() {
        System.out.println("setSave");
        boolean save = false;
        JogadorHumano instance = null;
        instance.setSave(save);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSave method, of class JogadorHumano.
     */
    @Test
    public void testGetSave() {
        System.out.println("getSave");
        JogadorHumano instance = null;
        boolean expResult = false;
        boolean result = instance.getSave();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPecasCapturadas method, of class JogadorHumano.
     */
    @Test
    public void testSetPecasCapturadas() {
        System.out.println("setPecasCapturadas");
        Peca peca = null;
        JogadorHumano instance = null;
        instance.setPecasCapturadas(peca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPecasCapturadas method, of class JogadorHumano.
     */
    @Test
    public void testGetPecasCapturadas() {
        System.out.println("getPecasCapturadas");
        JogadorHumano instance = null;
        String expResult = "";
        String result = instance.getPecasCapturadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

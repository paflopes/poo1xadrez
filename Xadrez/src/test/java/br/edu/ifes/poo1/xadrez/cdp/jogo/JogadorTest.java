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
public class JogadorTest {
    
    public JogadorTest() {
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
     * Test of getNome method, of class Jogador.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Jogador instance = new JogadorImpl();
        String expResult = "";
        String result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJogada method, of class Jogador.
     */
    @Test
    public void testGetJogada() {
        System.out.println("getJogada");
        Partida partida = null;
        Jogador instance = new JogadorImpl();
        Jogada expResult = null;
        Jogada result = instance.getJogada(partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVitoria method, of class Jogador.
     */
    @Test
    public void testSetVitoria() {
        System.out.println("setVitoria");
        boolean vitoria = false;
        Jogador instance = new JogadorImpl();
        instance.setVitoria(vitoria);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCor method, of class Jogador.
     */
    @Test
    public void testGetCor() {
        System.out.println("getCor");
        Jogador instance = new JogadorImpl();
        Cor expResult = null;
        Cor result = instance.getCor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isVitoria method, of class Jogador.
     */
    @Test
    public void testIsVitoria() {
        System.out.println("isVitoria");
        Jogador instance = new JogadorImpl();
        boolean expResult = false;
        boolean result = instance.isVitoria();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of atualizaPontosJogador method, of class Jogador.
     */
    @Test
    public void testAtualizaPontosJogador() {
        System.out.println("atualizaPontosJogador");
        Posicao novaPosicao = null;
        Jogador instance = new JogadorImpl();
        instance.atualizaPontosJogador(novaPosicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setSave method, of class Jogador.
     */
    @Test
    public void testSetSave() {
        System.out.println("setSave");
        boolean save = false;
        Jogador instance = new JogadorImpl();
        instance.setSave(save);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPecasCapturadas method, of class Jogador.
     */
    @Test
    public void testSetPecasCapturadas() {
        System.out.println("setPecasCapturadas");
        Peca peca = null;
        Jogador instance = new JogadorImpl();
        instance.setPecasCapturadas(peca);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPecasCapturadas method, of class Jogador.
     */
    @Test
    public void testGetPecasCapturadas() {
        System.out.println("getPecasCapturadas");
        Jogador instance = new JogadorImpl();
        String expResult = "";
        String result = instance.getPecasCapturadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class JogadorImpl implements Jogador {

        public String getNome() {
            return "";
        }

        public Jogada getJogada(Partida partida) {
            return null;
        }

        public void setVitoria(boolean vitoria) {
        }

        public Cor getCor() {
            return null;
        }

        public boolean isVitoria() {
            return false;
        }

        public void atualizaPontosJogador(Posicao novaPosicao) {
        }

        public void setSave(boolean save) {
        }

        public void setPecasCapturadas(Peca peca) {
        }

        public String getPecasCapturadas() {
            return "";
        }
    }
    
}

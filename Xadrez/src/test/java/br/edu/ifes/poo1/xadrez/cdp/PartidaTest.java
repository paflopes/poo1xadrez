/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import java.util.Date;
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
public class PartidaTest {
    
    public PartidaTest() {
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
     * Test of getTurno method, of class Partida.
     */
    @Test
    public void testGetTurno() {
        System.out.println("getTurno");
        Partida instance = new Partida();
        String expResult = "";
        String result = instance.getTurno();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTurno method, of class Partida.
     */
    @Test
    public void testSetTurno() {
        System.out.println("setTurno");
        String turno = "";
        Partida instance = new Partida();
        instance.setTurno(turno);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVencedor method, of class Partida.
     */
    @Test
    public void testGetVencedor() {
        System.out.println("getVencedor");
        Partida instance = new Partida();
        String expResult = "";
        String result = instance.getVencedor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setVencedor method, of class Partida.
     */
    @Test
    public void testSetVencedor() {
        System.out.println("setVencedor");
        String vencedor = "";
        Partida instance = new Partida();
        instance.setVencedor(vencedor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getInicio method, of class Partida.
     */
    @Test
    public void testGetInicio() {
        System.out.println("getInicio");
        Partida instance = new Partida();
        Date expResult = null;
        Date result = instance.getInicio();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setInicio method, of class Partida.
     */
    @Test
    public void testSetInicio() {
        System.out.println("setInicio");
        Date inicio = null;
        Partida instance = new Partida();
        instance.setInicio(inicio);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFim method, of class Partida.
     */
    @Test
    public void testGetFim() {
        System.out.println("getFim");
        Partida instance = new Partida();
        Date expResult = null;
        Date result = instance.getFim();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFim method, of class Partida.
     */
    @Test
    public void testSetFim() {
        System.out.println("setFim");
        Date fim = null;
        Partida instance = new Partida();
        instance.setFim(fim);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isFinalizada method, of class Partida.
     */
    @Test
    public void testIsFinalizada() {
        System.out.println("isFinalizada");
        Partida instance = new Partida();
        boolean expResult = false;
        boolean result = instance.isFinalizada();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setFinalizada method, of class Partida.
     */
    @Test
    public void testSetFinalizada() {
        System.out.println("setFinalizada");
        boolean finalizada = false;
        Partida instance = new Partida();
        instance.setFinalizada(finalizada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJogadorBranco method, of class Partida.
     */
    @Test
    public void testGetJogadorBranco() {
        System.out.println("getJogadorBranco");
        Partida instance = new Partida();
        Jogador expResult = null;
        Jogador result = instance.getJogadorBranco();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJogadorBranco method, of class Partida.
     */
    @Test
    public void testSetJogadorBranco() {
        System.out.println("setJogadorBranco");
        Jogador jogadorBranco = null;
        Partida instance = new Partida();
        instance.setJogadorBranco(jogadorBranco);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getJogadorPreto method, of class Partida.
     */
    @Test
    public void testGetJogadorPreto() {
        System.out.println("getJogadorPreto");
        Partida instance = new Partida();
        Jogador expResult = null;
        Jogador result = instance.getJogadorPreto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setJogadorPreto method, of class Partida.
     */
    @Test
    public void testSetJogadorPreto() {
        System.out.println("setJogadorPreto");
        Jogador jogadorPreto = null;
        Partida instance = new Partida();
        instance.setJogadorPreto(jogadorPreto);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTabuleiro method, of class Partida.
     */
    @Test
    public void testGetTabuleiro() {
        System.out.println("getTabuleiro");
        Partida instance = new Partida();
        Tabuleiro expResult = null;
        Tabuleiro result = instance.getTabuleiro();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTabuleiro method, of class Partida.
     */
    @Test
    public void testSetTabuleiro() {
        System.out.println("setTabuleiro");
        Tabuleiro tabuleiro = null;
        Partida instance = new Partida();
        instance.setTabuleiro(tabuleiro);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciaPartida method, of class Partida.
     */
    @Test
    public void testIniciaPartida() {
        System.out.println("iniciaPartida");
        Partida instance = new Partida();
        instance.iniciaPartida();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of recomeçarPartida method, of class Partida.
     */
    @Test
    public void testRecomeçarPartida() {
        System.out.println("recome\u00e7arPartida");
        Partida instance = new Partida();
        instance.recomeçarPartida();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of encerrarPartida method, of class Partida.
     */
    @Test
    public void testEncerrarPartida() {
        System.out.println("encerrarPartida");
        String nome = "";
        Partida instance = new Partida();
        instance.encerrarPartida(nome);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

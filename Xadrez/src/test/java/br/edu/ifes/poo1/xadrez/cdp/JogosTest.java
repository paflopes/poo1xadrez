/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.jogo.DadoJogo;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import java.util.ArrayList;
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
public class JogosTest {
    
    public JogosTest() {
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
     * Test of getListDadoJogo method, of class Jogos.
     */
    @Test
    public void testGetListDadoJogo() {
        System.out.println("getListDadoJogo");
        Jogos instance = new Jogos();
        ArrayList<DadoJogo> expResult = null;
        ArrayList<DadoJogo> result = instance.getListDadoJogo();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPartidasFinalizadas method, of class Jogos.
     */
    @Test
    public void testGetListPartidasFinalizadas() {
        System.out.println("getListPartidasFinalizadas");
        Jogos instance = new Jogos();
        ArrayList<Partida> expResult = null;
        ArrayList<Partida> result = instance.getListPartidasFinalizadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPartidasNaoFinalizadas method, of class Jogos.
     */
    @Test
    public void testGetListPartidasNaoFinalizadas() {
        System.out.println("getListPartidasNaoFinalizadas");
        Jogos instance = new Jogos();
        ArrayList<Partida> expResult = null;
        ArrayList<Partida> result = instance.getListPartidasNaoFinalizadas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setlistPartidasFinalizadas method, of class Jogos.
     */
    @Test
    public void testSetlistPartidasFinalizadas() {
        System.out.println("setlistPartidasFinalizadas");
        ArrayList<Partida> listPartidasFinalizadas = null;
        Jogos instance = new Jogos();
        instance.setlistPartidasFinalizadas(listPartidasFinalizadas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setlistPartidasNaoFinalizadas method, of class Jogos.
     */
    @Test
    public void testSetlistPartidasNaoFinalizadas() {
        System.out.println("setlistPartidasNaoFinalizadas");
        ArrayList<Partida> listPartidasNaoFinalizadas = null;
        Jogos instance = new Jogos();
        instance.setlistPartidasNaoFinalizadas(listPartidasNaoFinalizadas);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setListDadosJogos method, of class Jogos.
     */
    @Test
    public void testSetListDadosJogos() {
        System.out.println("setListDadosJogos");
        Jogador jogador = null;
        List<DadoJogo> listaDadoJogo = null;
        Jogos instance = new Jogos();
        instance.setListDadosJogos(jogador, listaDadoJogo);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
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
public class JogoAplTest {
    
    public JogoAplTest() {
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
     * Test of fazerJogada method, of class JogoApl.
     */
    @Test
    public void testFazerJogada() throws Exception {
        System.out.println("fazerJogada");
        Jogador jogador = null;
        Partida partida = null;
        JogoApl instance = new JogoApl();
        instance.fazerJogada(jogador, partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosicao method, of class JogoApl.
     */
    @Test
    public void testGetPosicao() {
        System.out.println("getPosicao");
        String idPosicao = "";
        Partida partida = null;
        JogoApl instance = new JogoApl();
        Posicao expResult = null;
        Posicao result = instance.getPosicao(idPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

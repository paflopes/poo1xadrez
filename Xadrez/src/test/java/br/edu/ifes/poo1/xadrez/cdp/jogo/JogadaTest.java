/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
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
public class JogadaTest {
    
    public JogadaTest() {
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
     * Test of getPecaDesejada method, of class Jogada.
     */
    @Test
    public void testGetPecaDesejada() {
        System.out.println("getPecaDesejada");
        Cor cor = null;
        Jogada instance = new Jogada();
        Peca expResult = null;
        Peca result = instance.getPecaDesejada(cor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPecaDesejada method, of class Jogada.
     */
    @Test
    public void testSetPecaDesejada() {
        System.out.println("setPecaDesejada");
        Class pecaDesejada = null;
        Jogada instance = new Jogada();
        instance.setPecaDesejada(pecaDesejada);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosicaoInicial method, of class Jogada.
     */
    @Test
    public void testGetPosicaoInicial() {
        System.out.println("getPosicaoInicial");
        Jogada instance = new Jogada();
        Posicao expResult = null;
        Posicao result = instance.getPosicaoInicial();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicaoInicial method, of class Jogada.
     */
    @Test
    public void testSetPosicaoInicial() {
        System.out.println("setPosicaoInicial");
        Posicao posicaoInicial = null;
        Jogada instance = new Jogada();
        instance.setPosicaoInicial(posicaoInicial);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosicaoFinal method, of class Jogada.
     */
    @Test
    public void testGetPosicaoFinal() {
        System.out.println("getPosicaoFinal");
        Jogada instance = new Jogada();
        Posicao expResult = null;
        Posicao result = instance.getPosicaoFinal();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicaoFinal method, of class Jogada.
     */
    @Test
    public void testSetPosicaoFinal() {
        System.out.println("setPosicaoFinal");
        Posicao posicaoFinal = null;
        Jogada instance = new Jogada();
        instance.setPosicaoFinal(posicaoFinal);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOperacao method, of class Jogada.
     */
    @Test
    public void testGetOperacao() {
        System.out.println("getOperacao");
        Jogada instance = new Jogada();
        Operacao expResult = null;
        Operacao result = instance.getOperacao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setOperacao method, of class Jogada.
     */
    @Test
    public void testSetOperacao() {
        System.out.println("setOperacao");
        Operacao operacao = null;
        Jogada instance = new Jogada();
        instance.setOperacao(operacao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorHumano;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 20121bsi0414
 */
public class ControleGeralTest {
    
    public ControleGeralTest() {
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
     * Test of run method, of class ControleGeral.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        ControleGeral instance = new ControleGeral();
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarPrograma method, of class ControleGeral.
     */
    @Test
    public void testIniciarPrograma() throws Exception {
        System.out.println("iniciarPrograma");
        String escolha = "";
        ControleGeral instance = new ControleGeral();
        instance.iniciarPrograma(escolha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarPartida method, of class ControleGeral.
     */
    @Test
    public void testIniciarPartida() throws Exception {
        System.out.println("iniciarPartida");
        Partida partida = null;
        ControleGeral instance = new ControleGeral();
        instance.iniciarPartida(partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iniciarJogada method, of class ControleGeral.
     */
    @Test
    public void testIniciarJogada() throws Exception {
        System.out.println("iniciarJogada");
        JogadorHumano jogadorAtual = null;
        Jogador jogadorProx = null;
        ControleGeral instance = new ControleGeral();
        instance.iniciarJogada(jogadorAtual, jogadorProx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of cadastraJogador method, of class ControleGeral.
     */
    @Test
    public void testCadastraJogador() throws ClassNotFoundException {
        System.out.println("cadastraJogador");
        Cor cor = null;
        ControleGeral instance = new ControleGeral();
        Jogador expResult = null;
        Jogador result = instance.cadastraJogador(cor);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of criaJogada method, of class ControleGeral.
     */
    @Test
    public void testCriaJogada() throws ClassNotFoundException {
        System.out.println("criaJogada");
        String jogadaStr = "";
        ControleGeral instance = new ControleGeral();
        Jogada expResult = null;
        Jogada result = instance.criaJogada(jogadaStr);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of identificaOperacao method, of class ControleGeral.
     */
    @Test
    public void testIdentificaOperacao() throws ClassNotFoundException {
        System.out.println("identificaOperacao");
        String jogada = "";
        ControleGeral instance = new ControleGeral();
        Operacao expResult = null;
        Operacao result = instance.identificaOperacao(jogada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarEntrada method, of class ControleGeral.
     */
    @Test
    public void testValidarEntrada() throws ClassNotFoundException {
        System.out.println("validarEntrada");
        String entrada = "";
        ControleGeral instance = new ControleGeral();
        boolean expResult = false;
        boolean result = instance.validarEntrada(entrada);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of jogadas method, of class ControleGeral.
     */
    @Test
    public void testJogadas() throws Exception {
        System.out.println("jogadas");
        Partida partida = null;
        ControleGeral instance = new ControleGeral();
        instance.jogadas(partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of jogarJogador method, of class ControleGeral.
     */
    @Test
    public void testJogarJogador() throws Exception {
        System.out.println("jogarJogador");
        Partida partida = null;
        ControleGeral instance = new ControleGeral();
        instance.jogarJogador(partida);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}
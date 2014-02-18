/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
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
public class PecaTest {
    
    public PecaTest() {
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
     * Test of getPosicao method, of class Peca.
     */
    @Test
    public void testGetPosicao() {
        System.out.println("getPosicao");
        Peca instance = new PecaImpl();
        Posicao expResult = null;
        Posicao result = instance.getPosicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicao method, of class Peca.
     */
    @Test
    public void testSetPosicao() {
        System.out.println("setPosicao");
        Posicao posicao = null;
        Peca instance = new PecaImpl();
        instance.setPosicao(posicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicaoInicial method, of class Peca.
     */
    @Test
    public void testSetPosicaoInicial() {
        System.out.println("setPosicaoInicial");
        Posicao posicao = null;
        Peca instance = new PecaImpl();
        instance.setPosicaoInicial(posicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValor method, of class Peca.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        Peca instance = new PecaImpl();
        int expResult = 0;
        int result = instance.getValor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCor method, of class Peca.
     */
    @Test
    public void testGetCor() {
        System.out.println("getCor");
        Peca instance = new PecaImpl();
        Cor expResult = null;
        Cor result = instance.getCor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of jaMovimentou method, of class Peca.
     */
    @Test
    public void testJaMovimentou() {
        System.out.println("jaMovimentou");
        Peca instance = new PecaImpl();
        boolean expResult = false;
        boolean result = instance.jaMovimentou();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarMovimento method, of class Peca.
     */
    @Test
    public void testValidarMovimento() {
        System.out.println("validarMovimento");
        Posicao novaPosicao = null;
        Partida partida = null;
        Peca instance = new PecaImpl();
        boolean expResult = false;
        boolean result = instance.validarMovimento(novaPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarMovimentoCaptura method, of class Peca.
     */
    @Test
    public void testValidarMovimentoCaptura() {
        System.out.println("validarMovimentoCaptura");
        Posicao novaPosicao = null;
        Partida partida = null;
        Peca instance = new PecaImpl();
        boolean expResult = false;
        boolean result = instance.validarMovimentoCaptura(novaPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesenho method, of class Peca.
     */
    @Test
    public void testGetDesenho() {
        System.out.println("getDesenho");
        Peca instance = new PecaImpl();
        String expResult = "";
        String result = instance.getDesenho();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDesenho method, of class Peca.
     */
    @Test
    public void testSetDesenho() {
        System.out.println("setDesenho");
        String desenho = "";
        Peca instance = new PecaImpl();
        instance.setDesenho(desenho);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class Peca.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        Peca instance = new PecaImpl();
        NomePeca expResult = null;
        NomePeca result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class Peca.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        Peca instance = new PecaImpl();
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PecaImpl implements Peca {

        public Posicao getPosicao() {
            return null;
        }

        public void setPosicao(Posicao posicao) {
        }

        public void setPosicaoInicial(Posicao posicao) {
        }

        public int getValor() {
            return 0;
        }

        public Cor getCor() {
            return null;
        }

        public boolean jaMovimentou() {
            return false;
        }

        public boolean validarMovimento(Posicao novaPosicao, Partida partida) {
            return false;
        }

        public boolean validarMovimentoCaptura(Posicao novaPosicao, Partida partida) {
            return false;
        }

        public String getDesenho() {
            return "";
        }

        public void setDesenho(String desenho) {
        }

        public NomePeca getNome() {
            return null;
        }

        public Object clone() throws CloneNotSupportedException {
            return null;
        }
    }
    
}

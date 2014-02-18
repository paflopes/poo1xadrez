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
public class PecaImplTest {
    
    public PecaImplTest() {
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
     * Test of getPosicao method, of class PecaImpl.
     */
    @Test
    public void testGetPosicao() {
        System.out.println("getPosicao");
        PecaImpl instance = null;
        Posicao expResult = null;
        Posicao result = instance.getPosicao();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicao method, of class PecaImpl.
     */
    @Test
    public void testSetPosicao() {
        System.out.println("setPosicao");
        Posicao posicao = null;
        PecaImpl instance = null;
        instance.setPosicao(posicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPosicaoInicial method, of class PecaImpl.
     */
    @Test
    public void testSetPosicaoInicial() {
        System.out.println("setPosicaoInicial");
        Posicao posicao = null;
        PecaImpl instance = null;
        instance.setPosicaoInicial(posicao);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCor method, of class PecaImpl.
     */
    @Test
    public void testGetCor() {
        System.out.println("getCor");
        PecaImpl instance = null;
        Cor expResult = null;
        Cor result = instance.getCor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDesenho method, of class PecaImpl.
     */
    @Test
    public void testGetDesenho() {
        System.out.println("getDesenho");
        PecaImpl instance = null;
        String expResult = "";
        String result = instance.getDesenho();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDesenho method, of class PecaImpl.
     */
    @Test
    public void testSetDesenho() {
        System.out.println("setDesenho");
        String desenho = "";
        PecaImpl instance = null;
        instance.setDesenho(desenho);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNome method, of class PecaImpl.
     */
    @Test
    public void testGetNome() {
        System.out.println("getNome");
        PecaImpl instance = null;
        NomePeca expResult = null;
        NomePeca result = instance.getNome();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validarMovimentoCaptura method, of class PecaImpl.
     */
    @Test
    public void testValidarMovimentoCaptura() {
        System.out.println("validarMovimentoCaptura");
        Posicao novaPosicao = null;
        Partida partida = null;
        PecaImpl instance = null;
        boolean expResult = false;
        boolean result = instance.validarMovimentoCaptura(novaPosicao, partida);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of jaMovimentou method, of class PecaImpl.
     */
    @Test
    public void testJaMovimentou() {
        System.out.println("jaMovimentou");
        PecaImpl instance = null;
        boolean expResult = false;
        boolean result = instance.jaMovimentou();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of clone method, of class PecaImpl.
     */
    @Test
    public void testClone() throws Exception {
        System.out.println("clone");
        PecaImpl instance = null;
        Object expResult = null;
        Object result = instance.clone();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getValor method, of class PecaImpl.
     */
    @Test
    public void testGetValor() {
        System.out.println("getValor");
        PecaImpl instance = null;
        int expResult = 0;
        int result = instance.getValor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class PecaImplImpl extends PecaImpl {

        public PecaImplImpl() {
            super(null, null, 0);
        }

        @Override
        public boolean validarMovimento(Posicao novaPosicao, Partida partida) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
}

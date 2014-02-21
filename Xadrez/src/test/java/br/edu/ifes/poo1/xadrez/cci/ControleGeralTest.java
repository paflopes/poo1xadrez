/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class ControleGeralTest {

    private ControleGeral controle;

    @Before
    public void before() throws ClassNotFoundException, PartidaEncerradaException {
        this.controle = new ControleGeral();
    }

    @Test
    public void testIdentificaOperacao() {
        Assert.assertEquals(Operacao.MOVIMENTO, controle.identificaOperacao("2346"));
        Assert.assertEquals(Operacao.CAPTURA, controle.identificaOperacao("11x22"));
        Assert.assertEquals(Operacao.PROMOCAO, controle.identificaOperacao("11=D"));
        Assert.assertEquals(Operacao.RMAIOR, controle.identificaOperacao("O-O-O"));
        Assert.assertEquals(Operacao.RMENOR, controle.identificaOperacao("O-O"));
        Assert.assertEquals(Operacao.XEQUE, controle.identificaOperacao("4523+"));
        Assert.assertEquals(Operacao.XMATE, controle.identificaOperacao("4523#"));
    }

    @Test
    public void testCriaJogada() {
        Jogada jogada = controle.criaJogada("1122");

        Assert.assertEquals("11", jogada.getPosicaoInicial().getId());
        Assert.assertEquals("22", jogada.getPosicaoFinal().getId());
        Assert.assertEquals(Operacao.MOVIMENTO, jogada.getOperacao());

        jogada = controle.criaJogada("33x54");
        Assert.assertEquals("33", jogada.getPosicaoInicial().getId());
        Assert.assertEquals("54", jogada.getPosicaoFinal().getId());
        Assert.assertEquals(Operacao.CAPTURA, jogada.getOperacao());
    }

    @Test
    public void testValidarEntrada() {
        Assert.assertTrue(controle.validarEntrada("desistir"));
        Assert.assertTrue(controle.validarEntrada("empate"));
        Assert.assertTrue(controle.validarEntrada("O-O"));
        Assert.assertTrue(controle.validarEntrada("O-O-O"));
        Assert.assertFalse(controle.validarEntrada("abacate"));
        Assert.assertFalse(controle.validarEntrada("testw1"));
        Assert.assertFalse(controle.validarEntrada("o-o-o"));

        Assert.assertTrue(controle.validarEntrada("1234"));
        Assert.assertTrue(controle.validarEntrada("2845"));
        Assert.assertFalse(controle.validarEntrada("23451"));
        Assert.assertFalse(controle.validarEntrada("2340"));
        Assert.assertFalse(controle.validarEntrada("5495"));

        Assert.assertTrue(controle.validarEntrada("12x34"));
        Assert.assertFalse(controle.validarEntrada("22c34"));

        Assert.assertTrue(controle.validarEntrada("1234+"));
        Assert.assertTrue(controle.validarEntrada("1234#"));
        Assert.assertFalse(controle.validarEntrada("2234$"));

        Assert.assertTrue(controle.validarEntrada("31=D"));
        Assert.assertTrue(controle.validarEntrada("81=C"));
        Assert.assertTrue(controle.validarEntrada("48=T"));
        Assert.assertTrue(controle.validarEntrada("78=B"));
        Assert.assertFalse(controle.validarEntrada("74=B"));
        Assert.assertFalse(controle.validarEntrada("41=F"));

    }
}
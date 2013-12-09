/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author leds
 */
public class TestRainha {

    Tabuleiro tab;
    Peca rainhaPreta;
    Peca rainhaBranca;

    @Before
    public void before() {
        Tabuleiro.getInstance().restaurarTabuleiro();
        tab = Tabuleiro.getInstance();

        rainhaBranca = tab.getPosicao("41").getPeca();
        rainhaPreta = tab.getPosicao("48").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("48")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("38")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("58")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("37")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("47")));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("57")));

        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("41")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("31")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("51")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("32")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("42")));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("52")));

        tab.getPosicao("44").setPeca(rainhaPreta);

        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("35")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("45")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("55")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("34")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("54")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("33")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("43")));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("53")));

    }
}

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

    Partida partida;
    Tabuleiro tab;
    Peca rainhaPreta;
    Peca rainhaBranca;

    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.tab = this.partida.getTabuleiro();
        this.rainhaBranca = this.tab.getPosicao("41").getPeca();
        this.rainhaPreta = this.tab.getPosicao("48").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("48"), this.partida));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("38"), this.partida));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("58"), this.partida));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("37"), this.partida));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("47"), this.partida));
        Assert.assertFalse(rainhaPreta.validarMovimento(tab.getPosicao("57"), this.partida));

        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("41"), this.partida));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("31"), this.partida));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("51"), this.partida));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("32"), this.partida));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("42"), this.partida));
        Assert.assertFalse(rainhaBranca.validarMovimento(tab.getPosicao("52"), this.partida));

        tab.getPosicao("44").setPeca(rainhaPreta);

        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("35"), this.partida));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("45"), this.partida));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("55"), this.partida));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("34"), this.partida));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("54"), this.partida));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("33"), this.partida));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("43"), this.partida));
        Assert.assertTrue(rainhaPreta.validarMovimento(tab.getPosicao("53"), this.partida));

    }

    @Test
    public void testValidarMovimentoCaptura() {
        tab.getPosicao("44").setPeca(rainhaBranca);

        Assert.assertTrue(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("17"), this.partida));
        Assert.assertTrue(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("47"), this.partida));
        Assert.assertTrue(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("77"), this.partida));
        Assert.assertFalse(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("22"), this.partida));
        Assert.assertFalse(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("32"), this.partida));
        Assert.assertFalse(rainhaBranca.validarMovimentoCaptura(tab.getPosicao("42"), this.partida));

    }
}

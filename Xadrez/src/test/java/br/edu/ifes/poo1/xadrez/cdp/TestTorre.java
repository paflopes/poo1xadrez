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
public class TestTorre {

    Partida partida;
    Peca torreBranca;
    Peca torrePreta;
    Tabuleiro tab;

    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.tab = this.partida.getTabuleiro();
        this.torrePreta = this.tab.getPosicao("88").getPeca();
        this.torreBranca = this.tab.getPosicao("11").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("12"), this.partida));
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("22"), this.partida));
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("21"), this.partida));

        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("87"), this.partida));
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("77"), this.partida));
        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("78"), this.partida));

        Assert.assertFalse(torrePreta.validarMovimento(tab.getPosicao("85"), this.partida));

        tab.getPosicao("45").setPeca(torreBranca);
        
        Assert.assertTrue(torreBranca.validarMovimento(tab.getPosicao("55"), this.partida));
        Assert.assertTrue(torreBranca.validarMovimento(tab.getPosicao("65"), this.partida));
        Assert.assertTrue(torreBranca.validarMovimento(tab.getPosicao("46"), this.partida));
        Assert.assertTrue(torreBranca.validarMovimento(tab.getPosicao("44"), this.partida));
        
        
    }

    @Test
    public void testValidarMovimentoCaptura() {
        tab.getPosicao("45").setPeca(torrePreta);
        
        Assert.assertTrue(torrePreta.validarMovimentoCaptura(tab.getPosicao("42"), this.partida));
        Assert.assertFalse(torrePreta.validarMovimentoCaptura(tab.getPosicao("48"), this.partida));
        Assert.assertFalse(torrePreta.validarMovimentoCaptura(tab.getPosicao("45"), this.partida));
    }
}

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
public class TestRei {

    Partida partida;
    Tabuleiro tab;
    Peca reiPreto;
    Peca reiBranco;

    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.tab = this.partida.getTabuleiro();
        this.reiPreto = tab.getPosicao("58").getPeca();
        this.reiBranco = tab.getPosicao("51").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("47"), this.partida));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("57"), this.partida));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("67"), this.partida));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("48"), this.partida));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("68"), this.partida));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("58"), this.partida));

        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("42"), this.partida));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("52"), this.partida));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("62"), this.partida));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("41"), this.partida));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("61"), this.partida));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("51"), this.partida));

        tab.getPosicao("45").setPeca(reiPreto);

        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("36"), this.partida));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("46"), this.partida));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("56"), this.partida));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("34"), this.partida));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("44"), this.partida));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("54"), this.partida));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("35"), this.partida));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("55"), this.partida));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("45"), this.partida));
    }
}

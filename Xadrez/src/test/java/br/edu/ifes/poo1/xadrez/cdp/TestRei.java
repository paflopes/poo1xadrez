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

    Tabuleiro tab;
    Peca reiPreto;
    Peca reiBranco;

    @Before
    public void before() {
        Tabuleiro.getInstance().restaurarTabuleiro();
        tab = Tabuleiro.getInstance();
        reiPreto = tab.getPosicao("58").getPeca();
        reiBranco = tab.getPosicao("51").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("47")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("57")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("67")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("48")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("68")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("58")));

        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("42")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("52")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("62")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("41")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("61")));
        Assert.assertFalse(reiBranco.validarMovimento(tab.getPosicao("51")));

        tab.getPosicao("45").setPeca(reiPreto);

        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("36")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("46")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("56")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("34")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("44")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("54")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("35")));
        Assert.assertTrue(reiPreto.validarMovimento(tab.getPosicao("55")));
        Assert.assertFalse(reiPreto.validarMovimento(tab.getPosicao("45")));
    }
    
    @Test
    public void testValidarMovimetoCaptura() {
        
    }
}

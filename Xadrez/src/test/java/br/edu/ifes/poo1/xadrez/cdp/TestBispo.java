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
public class TestBispo {

    Tabuleiro tab;
    Peca bispoBranco;
    Peca bispoPreto;

    @Before
    public void before() {
        Tabuleiro.getInstance().restaurarTabuleiro();
        tab = Tabuleiro.getInstance();
        bispoBranco = tab.getPosicao("61").getPeca();
        bispoPreto = tab.getPosicao("38").getPeca();
    }

    @Test
    public void testValidarMovimentoCaptura() {
        Assert.assertFalse(bispoPreto.validarMovimentoCaptura(tab.getPosicao("46")));

        tab.getPosicao("27").setPeca(tab.getPosicao("22").getPeca());
        tab.getPosicao("47").setPeca(tab.getPosicao("42").getPeca());

        Assert.assertTrue(bispoPreto.validarMovimentoCaptura(tab.getPosicao("27")));
        Assert.assertTrue(bispoPreto.validarMovimentoCaptura(tab.getPosicao("47")));

    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("52")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("62")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("72")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("51")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("71")));
        Assert.assertFalse(bispoBranco.validarMovimento(tab.getPosicao("43")));

        tab.getPosicao("53").setPeca(tab.getPosicao("52").getPeca());
        tab.getPosicao("73").setPeca(tab.getPosicao("72").getPeca());

        Assert.assertTrue(bispoBranco.validarMovimento(tab.getPosicao("52")));
        Assert.assertTrue(bispoBranco.validarMovimento(tab.getPosicao("43")));
        Assert.assertTrue(bispoBranco.validarMovimento(tab.getPosicao("72")));
        Assert.assertTrue(bispoBranco.validarMovimento(tab.getPosicao("83")));

    }
}

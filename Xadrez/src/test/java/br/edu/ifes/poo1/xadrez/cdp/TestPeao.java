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
 * @author phillipe
 */
public class TestPeao {

    Tabuleiro tab;
    Peca peaoPreto;
    Peca peaoBranco;

    @Before
    public void before() {
        tab = Tabuleiro.getInstance();
        peaoPreto = tab.getPosicao("47").getPeca();
        peaoBranco = tab.getPosicao("32").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("47")));
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("46")));
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("45")));
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("44")));

        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("32")));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("33")));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("34")));
        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("35")));

        tab.getPosicao("33").setPeca(peaoBranco);

        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("35")));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("34")));
    }

    @Test
    public void testValidarMovimentoCaptura() {
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("47")));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("46")));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("56")));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("36")));

        tab.getPosicao("56").setPeca(tab.getPosicao("57").getPeca());
        tab.getPosicao("36").setPeca(tab.getPosicao("37").getPeca());

        Assert.assertTrue(peaoPreto.validarMovimentoCaptura(tab.getPosicao("56")));
        Assert.assertTrue(peaoPreto.validarMovimentoCaptura(tab.getPosicao("36")));

    }
}

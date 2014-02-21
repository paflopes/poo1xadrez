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

    Partida partida;
    Tabuleiro tab;
    Peca peaoPreto;
    Peca peaoBranco;

    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.tab = this.partida.getTabuleiro();
        this.peaoPreto = tab.getPosicao("47").getPeca();
        this.peaoBranco = tab.getPosicao("32").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("47"), this.partida));
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("46"), this.partida));
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("45"), this.partida));
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("44"), this.partida));

        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("32"), this.partida));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("33"), this.partida));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("34"), this.partida));
        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("35"), this.partida));

        tab.getPosicao("33").setPeca(peaoBranco);

        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("35"), this.partida));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("34"), this.partida));
    }

    @Test
    public void testValidarMovimentoCaptura() {
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("47"), this.partida));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("46"), this.partida));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("56"), this.partida));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("36"), this.partida));

        tab.getPosicao("56").setPeca(tab.getPosicao("52").getPeca());
        tab.getPosicao("36").setPeca(tab.getPosicao("32").getPeca());

        Assert.assertTrue(peaoPreto.validarMovimentoCaptura(tab.getPosicao("56"), this.partida));
        Assert.assertTrue(peaoPreto.validarMovimentoCaptura(tab.getPosicao("36"), this.partida));
        Assert.assertFalse(peaoPreto.validarMovimentoCaptura(tab.getPosicao("46"), this.partida));

    }
}

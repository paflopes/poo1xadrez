/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Adm
 */
public class TestCavalo {

    Partida partida;
    Peca peca;
    Tabuleiro tabuleiro;

    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.tabuleiro = this.partida.getTabuleiro();
        this.peca = this.tabuleiro.getPosicao("21").getPeca();
    }

    @Test
    public void testValidarMovimento() {
        Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao("13"), this.partida));
        Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao("33"), this.partida));
        Assert.assertFalse(this.peca.validarMovimento(this.tabuleiro.getPosicao("42"),this.partida ));
    }
}

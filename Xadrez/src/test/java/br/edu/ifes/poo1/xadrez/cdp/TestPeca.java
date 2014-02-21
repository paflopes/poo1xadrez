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
 * @author phillipe
 */
public class TestPeca {
    Peca peca;
    Tabuleiro tabuleiro;
    Partida partida;
    
    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.tabuleiro = this.partida.getTabuleiro();
        this.peca = tabuleiro.getPosicao("31").getPeca();
    }
    
    @Test
    public void testJaMovimentou() {
        Assert.assertFalse(peca.jaMovimentou());
        peca.setPosicao(tabuleiro.getPosicao("25"));
        Assert.assertTrue(peca.jaMovimentou());
    }
}

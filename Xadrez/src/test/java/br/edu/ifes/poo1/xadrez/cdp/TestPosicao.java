/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author leds
 */
public class TestPosicao {

    Tabuleiro tabuleiro;
    Partida partida;

    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.tabuleiro = this.partida.getTabuleiro();
    }

    @Test
    public void testGetPosicao() {
        Assert.assertNotNull(this.tabuleiro.getPosicao("85"));
        Assert.assertNull(this.tabuleiro.getPosicao("01"));
    }
}

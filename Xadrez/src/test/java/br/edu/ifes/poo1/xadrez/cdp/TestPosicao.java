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

    @Before
    public void before() {
        this.tabuleiro = Tabuleiro.getInstance();
    }

    @Test
    public void testExistePosicao() {
        Posicao posicao = this.tabuleiro.getPosicao("11");
        Assert.assertTrue(posicao.existePosicao(Coordenada.N));
        Assert.assertTrue(posicao.existePosicao(Coordenada.NE));
        Assert.assertTrue(posicao.existePosicao(Coordenada.E));
        Assert.assertFalse(posicao.existePosicao(Coordenada.SE));
        Assert.assertFalse(posicao.existePosicao(Coordenada.S));
        Assert.assertFalse(posicao.existePosicao(Coordenada.SO));
        Assert.assertFalse(posicao.existePosicao(Coordenada.O));
        Assert.assertFalse(posicao.existePosicao(Coordenada.NO));
    }

    @Test
    public void testGetPosicao() {
        Assert.assertNotNull(this.tabuleiro.getPosicao("85"));
        Assert.assertNull(this.tabuleiro.getPosicao("01"));
    }
}

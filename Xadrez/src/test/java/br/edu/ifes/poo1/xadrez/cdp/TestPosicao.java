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
        Assert.assertTrue(this.tabuleiro.getPosicao("11").existePosicao(Coordenada.N));
        Assert.assertTrue(this.tabuleiro.getPosicao("11").existePosicao(Coordenada.NE));
        Assert.assertTrue(this.tabuleiro.getPosicao("11").existePosicao(Coordenada.E));
        Assert.assertFalse(this.tabuleiro.getPosicao("11").existePosicao(Coordenada.SE));
        Assert.assertFalse(this.tabuleiro.getPosicao("11").existePosicao(Coordenada.S));
        Assert.assertFalse(this.tabuleiro.getPosicao("11").existePosicao(Coordenada.SO));
        Assert.assertFalse(this.tabuleiro.getPosicao("11").existePosicao(Coordenada.O));
        Assert.assertFalse(this.tabuleiro.getPosicao("11").existePosicao(Coordenada.NO));
    }
}

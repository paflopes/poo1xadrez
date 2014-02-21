/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author 20121BSI0236
 */
public class TestTabuleiro {

    Partida partida;
    Tabuleiro tabuleiro;

    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.tabuleiro = this.partida.getTabuleiro();
    }

    @Test
    public void getPosicao() {
        for (char coluna = '1'; coluna < '9'; coluna++) {
            for (char linha = '1'; linha < '9'; linha++) {
                String pos1;
                String pos2;
                char proxLinha = (char) (linha + 1);
                pos1 = "" + coluna + linha;
                pos2 = "" + coluna + proxLinha;
                Assert.assertNotNull(this.tabuleiro.getPosicao(pos1));
                Assert.assertNotSame(this.tabuleiro.getPosicao(pos1), this.tabuleiro.getPosicao(pos2));
                Assert.assertEquals(pos1, this.tabuleiro.getPosicao(pos1).getId());
            }
        }
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import org.junit.Assert;
import org.junit.Before;

/**
 *
 * @author leds
 */
public class TestTorre {

    Peca peca;
    Tabuleiro tabuleiro;

    @Before
    public void before() {
        Tabuleiro.getInstance().restaurarTabuleiro();
        this.tabuleiro = Tabuleiro.getInstance();
        this.peca = this.tabuleiro.getPosicao("88").getPeca();
    }

    public void testValidarMovimento() {
        for (char linha = '1'; linha < '9'; linha++) {
            Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao("8" + linha)));
        }
        for (char coluna = '1'; coluna < '9'; coluna++) {
            Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao(coluna + "8")));
        }
        for (char coluna = '1'; coluna < '8'; coluna++) {
            for (char linha = '1'; linha < '8'; linha++) {
                Assert.assertFalse(this.peca.validarMovimento(this.tabuleiro.getPosicao("" + coluna + linha)));
            }
        }
    }
}

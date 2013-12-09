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

    Peca peca;
    Tabuleiro tabuleiro;

    @Before
    public void before() {
        Tabuleiro.getInstance().restaurarTabuleiro();
        this.tabuleiro = Tabuleiro.getInstance();
        this.peca = this.tabuleiro.getPosicao("21").getPeca();
    }

    
    @Test
    public void testValidarMovimento() {
        Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao("13")));
        Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao("33")));
        Assert.assertFalse(this.peca.validarMovimento(this.tabuleiro.getPosicao("42")));
        for (char coluna = '1'; coluna < '9'; coluna++) {
            for (char linha = '1'; linha < '9'; linha++) {
                Posicao posicaoTmp = this.tabuleiro.getPosicao("" + coluna + linha);
                boolean posValidas = posicaoTmp == this.tabuleiro.getPosicao("13");
                posValidas = posValidas || (posicaoTmp == this.tabuleiro.getPosicao("33"));
                posValidas = posValidas || (posicaoTmp == this.tabuleiro.getPosicao("42"));

                if (!posValidas) {
                    Assert.assertFalse(this.peca.validarMovimento(posicaoTmp));
                }
            }
        }
    }
}

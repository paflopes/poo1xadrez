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
        this.tabuleiro = Tabuleiro.getInstance();
        this.peca = this.tabuleiro.getPosicao("21").getPeca();
    }

    
    @Test
    public void testValidarPosicao() {
        Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao("13")));
        Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao("33")));
        Assert.assertTrue(this.peca.validarMovimento(this.tabuleiro.getPosicao("42")));
//        for (char coluna = '1'; coluna < '9'; coluna++) {
//            for (char linha = '1'; linha < '9'; linha++) {
//                Posicao posicaoTmp = this.tabuleiro.getPosicao("" + coluna + linha);
//                boolean posInvalidas = posicaoTmp == this.tabuleiro.getPosicao("13");
//                posInvalidas = posInvalidas || (posicaoTmp == this.tabuleiro.getPosicao("33"));
//                posInvalidas = posInvalidas || (posicaoTmp == this.tabuleiro.getPosicao("42"));
//
//                if (posInvalidas) {
//                    Assert.assertFalse(this.peca.validarMovimento(posicaoTmp));
//                }
//            }
//        }
    }
}
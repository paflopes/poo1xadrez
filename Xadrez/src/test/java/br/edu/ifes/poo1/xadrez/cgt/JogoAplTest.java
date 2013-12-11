/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class JogoAplTest {

    Jogada jogada;
    Tabuleiro tab;
    JogoApl jogo;

    @Before
    public void before() {
        Tabuleiro.getInstance().restaurarTabuleiro();
        jogo = new JogoApl();
        tab = Tabuleiro.getInstance();
        jogada = new Jogada();
        jogada.setPosicaoInicial(tab.getPosicao("21"));
        jogada.setPosicaoFinal(tab.getPosicao("13"));
    }

    @Test
    public void testFazerJogada() throws JogadaInvalidaException {
        jogada.setOperacao(Operacao.MOVIMENTO);
        jogo.fazerJogada(jogada);
        Assert.assertTrue(tab.getPosicao("13").existePeca());
        Assert.assertFalse(tab.getPosicao("21").existePeca());
    }

    @Test(expected = JogadaInvalidaException.class)
    public void testFazerJogadaException() throws JogadaInvalidaException {
        jogada.setOperacao(Operacao.MOVIMENTO);
        jogada.setPosicaoFinal(tab.getPosicao("42"));

        jogo.fazerJogada(jogada);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorHumano;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class JogoAplTest {

    JogadorHumano jogador;
    Jogada jogada;
    Partida partida;
    JogoApl jogo;
    Tabuleiro tab;

    @Before
    public void before() {
        this.partida = new Partida();
        this.partida.iniciaPartida();
        this.jogo = new JogoApl();
        this.tab = this.partida.getTabuleiro();
        this.jogador = new JogadorHumano(Cor.BRANCO);
        this.jogada = new Jogada();
        this.jogada.setPosicaoInicial(tab.getPosicao("21"));
        this.jogada.setPosicaoFinal(tab.getPosicao("13"));
    }

    @Test
    public void testFazerJogada() throws JogadaInvalidaException {
        jogada.setOperacao(Operacao.MOVIMENTO);
        jogador.setJogada(jogada);
        jogo.fazerJogada(jogador, partida);
        Assert.assertTrue(tab.getPosicao("13").existePeca());
        Assert.assertFalse(tab.getPosicao("21").existePeca());
    }

    @Test(expected = JogadaInvalidaException.class)
    public void testFazerJogadaException() throws JogadaInvalidaException {
        jogada.setOperacao(Operacao.MOVIMENTO);
        jogada.setPosicaoFinal(tab.getPosicao("42"));

        jogador.setJogada(jogada);

        jogo.fazerJogada(jogador, partida);
    }
}

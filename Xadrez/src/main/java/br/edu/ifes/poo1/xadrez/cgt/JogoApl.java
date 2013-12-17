/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.jogo.DadoJogo;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lincoln
 */
public class JogoApl {

    private final List<DadoJogo> dadosJogo;

    public JogoApl() {
        this.dadosJogo = new ArrayList<>();
    }

    public void fazerJogada(Jogador jogador) throws JogadaInvalidaException {
        Jogada jogada = jogador.getJogada();
        Posicao posicaoAtual = jogada.getPosicaoInicial();
        Posicao posicaoFinal = jogada.getPosicaoFinal();
        Peca peca = posicaoAtual.getPeca();
        boolean isCaptura = jogada.getOperacao() == Operacao.CAPTURA;

        if ((!isCaptura && peca.validarMovimento(posicaoFinal))
                || (isCaptura && peca.validarMovimentoCaptura(posicaoFinal))) {
            posicaoFinal.setPeca(peca);
        } else {
            throw new JogadaInvalidaException("Jogada inválida!");
        }
    }

    public void salvarDado(DadoJogo dado) {
        this.dadosJogo.add(dado);
    }

    public List<DadoJogo> getDados() {
        return this.dadosJogo;
    }

    public Posicao getPosicao(String idPosicao) {
        return Tabuleiro.getInstance().getPosicao(idPosicao);
    }

    public Tabuleiro getTabuleiro() {
        return Tabuleiro.getInstance();
    }
}

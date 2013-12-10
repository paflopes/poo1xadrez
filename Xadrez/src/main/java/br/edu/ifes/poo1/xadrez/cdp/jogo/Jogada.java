/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Posicao;

/**
 *
 * @author leds
 */
public class Jogada {

    Posicao posicaoInicial;
    Posicao posicaoFinal;
    Operacao operacao;

    public Posicao getPosicaoInicial() {
        return posicaoInicial;
    }

    public void setPosicaoInicial(Posicao posicaoInicial) {
        this.posicaoInicial = posicaoInicial;
    }

    public Posicao getPosicaoFinal() {
        return posicaoFinal;
    }

    public void setPosicaoFinal(Posicao posicaoFinal) {
        this.posicaoFinal = posicaoFinal;
    }

    public Operacao getOperacao() {
        return operacao;
    }

    public void setOperacao(Operacao operacao) {
        this.operacao = operacao;
    }
}

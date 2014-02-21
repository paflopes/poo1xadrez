/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author leds
 */
public class Jogada implements Serializable {

    Posicao posicaoInicial;
    Posicao posicaoFinal;
    Operacao operacao;
    Class pecaDesejada;

    public Peca getPecaDesejada(Cor cor) {
        try {
            return (Peca) pecaDesejada.getConstructor(Cor.class).newInstance(cor);
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return null;
        }
    }

    public void setPecaDesejada(Class pecaDesejada) {
        this.pecaDesejada = pecaDesejada;
    }

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

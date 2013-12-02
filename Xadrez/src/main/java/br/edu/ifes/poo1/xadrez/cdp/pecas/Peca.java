/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;

/**
 *
 * @author phillipe
 */
public abstract class Peca {

    protected Cor cor;
    protected Posicao posicao;
    protected char desenho;

    
    public Posicao getPosicao() {
        return posicao;
    }

    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    /**
     *
     * @param cor A cor da peça.
     */
    public void setCor(Cor cor) {
        this.cor = cor;
    }

    /**
     *
     * @return A cor da peça.
     */
    public Cor getCor() {
        return this.cor;
    }
    
    /**
     *
     * @param novaPosicao A posição que se deseja que a peça vá.
     * @return
     */
    public abstract boolean validarMovimento(Posicao novaPosicao);

    /**
     * @return the desenho
     */
    public char getDesenho() {
        return desenho;
    }

    /**
     * @param desenho the desenho to set
     */
    public void setDesenho(char desenho) {
        this.desenho = desenho;
    }
}

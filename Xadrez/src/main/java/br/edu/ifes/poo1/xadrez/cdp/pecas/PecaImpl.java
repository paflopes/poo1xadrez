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
public abstract class PecaImpl implements Peca, Cloneable {

    protected Cor cor;
    protected Posicao posicao;
    protected char desenho;

    @Override
    public Posicao getPosicao() {
        return posicao;
    }

    @Override
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
    }

    /**
     *
     * @param cor A cor da peça.
     */
    @Override
    public void setCor(Cor cor) {
        this.cor = cor;
    }

    /**
     *
     * @return A cor da peça.
     */
    @Override
    public Cor getCor() {
        return this.cor;
    }

    /**
     *
     * @param novaPosicao A posição que se deseja que a peça vá.
     * @return
     */
    @Override
    public abstract boolean validarMovimento(Posicao novaPosicao);

    /**
     * @return the desenho
     */
    @Override
    public char getDesenho() {
        return desenho;
    }

    /**
     * @param desenho the desenho to set
     */
    @Override
    public void setDesenho(char desenho) {
        this.desenho = desenho;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }

}

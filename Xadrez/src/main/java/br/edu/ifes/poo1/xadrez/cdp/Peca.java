/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

/**
 *
 * @author phillipe
 */
public abstract class Peca {

    Cor cor;

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
}

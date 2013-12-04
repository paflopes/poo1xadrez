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
 * @author leds
 */
public interface Peca {

    public Posicao getPosicao();

    public void setPosicao(Posicao posicao);

    /**
     *
     * @param cor A cor da peça.
     */
    public void setCor(Cor cor);

    /**
     *
     * @return A cor da peça.
     */
    public Cor getCor();

    /**
     *
     * @param novaPosicao A posição que se deseja que a peça vá.
     * @return
     */
    public boolean validarMovimento(Posicao novaPosicao);

    /**
     * @return the desenho
     */
    public char getDesenho();

    /**
     * @param desenho the desenho to set
     */
    public void setDesenho(char desenho);

}

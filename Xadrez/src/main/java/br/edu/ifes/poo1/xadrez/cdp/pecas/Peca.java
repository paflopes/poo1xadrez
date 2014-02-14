/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;
import br.edu.ifes.poo1.xadrez.cdp.Partida;

/**
 *
 * @author leds
 */
public interface Peca extends Cloneable {

    public Posicao getPosicao();

    public void setPosicao(Posicao posicao);

    public void setPosicaoInicial(Posicao posicao);
    
    
    /*
    * Retorna o valor de cada peça
    */
    
    public int getValor();
   
    /**
     *
     * @return A cor da peça.
     */
    public Cor getCor();
    
    /**
     * Verifica se a peça já se movimentou no Tabuleiro.
     * @return {@code true}  se já se movimentou, {@code false} caso contrário.
     */
    public boolean jaMovimentou();

    /**
     *
     * @param novaPosicao A posição que se deseja que a peça vá.
     * @return
     */
    public boolean validarMovimento(Posicao novaPosicao , Partida partida);

    /**
     * Verifica se a peça pode realizar a captura.
     * @param novaPosicao Posição onde está a peça a ser capturada.
     * @return {@code true} se o movimento for válido ou {@code false} caso contrário.
     */
    public boolean validarMovimentoCaptura(Posicao novaPosicao, Partida partida);
    
    /**
     * @return the desenho
     */
    public String getDesenho();

    /**
     * @param desenho the desenho to set
     */
    public void setDesenho(String desenho);


    /**
     * 
     * @return O nome da peça. Ex.: {@code NomePeca.CAVALO}.
     */
    public NomePeca getNome();
    
    public Object clone() throws CloneNotSupportedException;
}

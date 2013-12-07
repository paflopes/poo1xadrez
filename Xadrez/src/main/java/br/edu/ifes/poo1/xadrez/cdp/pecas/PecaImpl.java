/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.TipoPeca;

/**
 *
 * @author phillipe
 */
public abstract class PecaImpl implements Peca, Cloneable {

    protected TipoPeca tipo;
    protected Cor cor;
    protected Posicao posicao;
    protected String desenho;

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
     * @return the desenho
     */
    @Override
    public String getDesenho() {
        return desenho;
    }

    /**
     * @param desenho the desenho to set
     */
    @Override
    public void setDesenho(String desenho) {
        this.desenho = desenho;
    }


    @Override
    public TipoPeca getTipo() {
        
        return this.tipo;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        return validarMovimento(novaPosicao);
    }
       
   
    
}

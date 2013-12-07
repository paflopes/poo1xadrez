/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;

/**
 *
 * @author phillipe
 */
public abstract class PecaImpl implements Peca {

    private final Cor cor;
    private Posicao posicao;
    private String desenho;
    private final NomePeca nome;
    private boolean seMovimentou;

    public PecaImpl(Cor cor, NomePeca nome) {
        this.cor = cor;
        this.nome = nome;
    }

    @Override
    public Posicao getPosicao() {
        return posicao;
    }

    @Override
    public void setPosicao(Posicao posicao) {
        this.posicao = posicao;
        if (!this.seMovimentou) {
            this.seMovimentou = true;
        }
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
    public NomePeca getNome() {
        return this.nome;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        return validarMovimento(novaPosicao);
    }

    @Override
    public boolean jaMovimentou() {
        return this.seMovimentou;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

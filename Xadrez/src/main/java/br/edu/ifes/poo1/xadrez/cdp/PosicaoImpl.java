/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.io.Serializable;

/**
 *
 * @author phillipe
 */
public class PosicaoImpl implements Posicao, Serializable {

    private final String id;
    private Peca peca;

    public PosicaoImpl(String id) {
        this.peca = null;
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public Peca getPeca() {
        return peca;
    }

    /**
     * Coloca uma peca na posição e retira da posição anterior.
     *
     * @param peca
     */
    @Override
    public void setPeca(Peca peca) {
        Posicao posicaoAnt;
        this.peca = peca;

        // Aqui é verificado se é a primeira vez que é a primeira vez que a posição é definida.
        try {
            posicaoAnt = peca.getPosicao();
        } catch (NullPointerException e) {
            this.peca = null;
            return;
        }
        if (posicaoAnt != null) {
            ((PosicaoImpl) posicaoAnt).peca = null;
            peca.setPosicao(this);
        } else {
            peca.setPosicaoInicial(this);
        }
    }

    /**
     *
     * @return Retorna true se há alguma peça na posição atual e false caso
     * contrário.
     */
    @Override
    public boolean existePeca() {
        return this.peca != null;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        PosicaoImpl clone = (PosicaoImpl) super.clone();

        try {
            clone.peca = (Peca) this.peca.clone();
            clone.peca.setPosicao(clone);
        } catch (NullPointerException e) {

        }

        return clone;
    }

}

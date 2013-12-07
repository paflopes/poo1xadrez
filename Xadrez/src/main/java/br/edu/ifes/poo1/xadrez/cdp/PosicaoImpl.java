/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;

/**
 *
 * @author phillipe
 */
public class PosicaoImpl implements Posicao {

    private final String id;
    private Peca peca = null;

    public PosicaoImpl(String id) {
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

        try {
            posicaoAnt = peca.getPosicao();
        } catch (NullPointerException e) {
            return;
        }

        if (posicaoAnt != null) {
            posicaoAnt.setPeca(null);
        }

        peca.setPosicao(this);
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

    
}

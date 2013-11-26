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
public class Posicao {

    private Peca pecaAtual = null;

    public Peca getPecaAtual() {
        return pecaAtual;
    }

    public void setPecaAtual(Peca pecaAtual) {
        this.pecaAtual = pecaAtual;
    }

    /**
     *
     * @return Retorna true se há alguma peça na posição atual e false caso
     * contrário.
     */
    public boolean haPeca() {
        return this.pecaAtual != null;
    }

}

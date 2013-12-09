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
public interface Posicao extends Cloneable {

    public String getId();

    public Peca getPeca();

    /**
     * Coloca uma peca na posição e retira da posição anterior.
     *
     * @param peca
     */
    public void setPeca(Peca peca);

    /**
     * @return Retorna {@code true} se há alguma peça na posição atual e
     * {@code false} caso contrário.
     */
    public boolean existePeca();

    public Object clone() throws CloneNotSupportedException;
}

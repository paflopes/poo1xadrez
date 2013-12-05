/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;

/**
 *
 * @author 20121bsi0236
 */
public interface Posicao extends Cloneable {

    public String getId();

    public void setId(String id);

    public Peca getPeca();

    public void setPeca(Peca peca);

    /**
     *
     * @return Retorna true se há alguma peça na posição atual e false caso
     * contrário.
     */
    public boolean existePeca();

    public Object clone() throws CloneNotSupportedException;
}

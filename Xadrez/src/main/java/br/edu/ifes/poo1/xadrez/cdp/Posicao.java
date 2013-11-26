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

    private Peca peca = null;

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca pecaAtual) {
        this.peca = pecaAtual;
    }

    /**
     *
     * @return Retorna true se há alguma peça na posição atual e false caso
     * contrário.
     */
    public boolean existePeca() {
        return this.peca != null;
    }

    public boolean existePosicao(Coordenada coordenada) {
        char coluna;
        char linha;
        return false;
    }

    /**
     *
     * @return
     */
    private String coordenadaToPos(Coordenada coordenada) {

        String posicao = null;
        String posAtual = Tabuleiro.getInstance().getIdPosicao(this);
        //char linhaAtual = posAtual.
        
        switch (coordenada) {
            case N:
                
                break;
            case NE:
                break;
            case E:
                break;
            case SE:
                break;
            case S:
                break;
            case SO:
                break;
            case O:
                break;
            case NO:
                break;
            default:
                throw new AssertionError(coordenada.name());

        }
        return posicao;
    }
}
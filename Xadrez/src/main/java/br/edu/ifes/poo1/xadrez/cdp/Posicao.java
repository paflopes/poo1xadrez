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
        String novaPosicao = this.coordenadaToPosicao(coordenada);

        return Tabuleiro.getInstance().getPosicao(novaPosicao) != null;
    }

    public Posicao getPosicao(Coordenada coordenada) {
        String novaPosicao = this.coordenadaToPosicao(coordenada);
        
        return Tabuleiro.getInstance().getPosicao(novaPosicao);
    }

    /**
     * Converte uma coordenada para um id de posição.
     *
     * @return
     */
    private String coordenadaToPosicao(Coordenada coordenada) {

        String posAtual = Tabuleiro.getInstance().getIdPosicao(this);
        char coluna = posAtual.charAt(0);
        char linha = posAtual.charAt(1);

        switch (coordenada) {
            case N:
                linha++;
                break;
            case NE:
                linha++;
                coluna++;
                break;
            case E:
                coluna++;
                break;
            case SE:
                linha--;
                coluna++;
                break;
            case S:
                linha--;
                break;
            case SO:
                linha--;
                coluna--;
                break;
            case O:
                coluna--;
                break;
            case NO:
                linha++;
                coluna--;
                break;
            default:
                throw new AssertionError(coordenada.name());
        }

        return "" + coluna + linha;
    }
}

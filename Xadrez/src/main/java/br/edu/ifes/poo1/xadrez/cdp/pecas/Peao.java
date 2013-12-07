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
public class Peao extends PecaImpl {

    public Peao(Cor cor) {
        super(cor, NomePeca.PEAO);
        this.setDesenho("P");
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        char colunaAtual = this.getPosicao().getId().charAt(0);
        char linhaAtual = this.getPosicao().getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        int linhasAndadas = Math.abs(linhaNova - linhaAtual);

        /**
         * Se não houver Peça na nova posição, então verificamos se os
         * movimentos são válidos.
         */
        if (!novaPosicao.existePeca()) {
            /**
             * Se não for o primeiro movimento, então o Peão anda apenas uma
             * casa. O peão anda duas ou uma casa, caso contrário.
             */
            if (linhaAtual != '2' && linhaAtual != '7') {
                return (linhasAndadas == 1 && colunaAtual == colunaNova);
            } else {
                return ((linhasAndadas == 2 || linhasAndadas == 1) && colunaAtual == colunaNova);
            }
        } else {
            return false;
        }
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        char colunaAtual = this.getPosicao().getId().charAt(0);
        char linhaAtual = this.getPosicao().getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        /**
         * Se a peça não existir, então não há captura e um movimento deverá ser
         * realizado.
         */
        if (novaPosicao.existePeca()) {
            /**
             * Se a peça for branca, verificamos nas diagonais para cima, caso
             * contrário verificamos as diagonais abaixo.
             */
            if (this.getCor() == Cor.BRANCO) {
                return (Math.abs(colunaAtual - colunaNova) == 1) && ((linhaNova - linhaAtual) == 1);
            } else {
                return (Math.abs(colunaAtual - colunaNova) == 1) && ((linhaNova - linhaAtual) == -1);
            }
        } else {
            return false;
        }
    }

}

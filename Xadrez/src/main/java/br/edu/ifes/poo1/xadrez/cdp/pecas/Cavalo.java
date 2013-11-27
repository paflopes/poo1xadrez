/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Coordenada;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;

/**
 *
 * @author phillipe
 */
public class Cavalo extends Peca {

    private final Coordenada[] movPossiveis;

    public Cavalo() {
        this.movPossiveis = new Coordenada[4];
        movPossiveis[0] = Coordenada.N;
        movPossiveis[1] = Coordenada.E;
        movPossiveis[2] = Coordenada.O;
        movPossiveis[3] = Coordenada.S;
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        Posicao posTemp1 = this.getPosicao();
        Posicao posTemp2 = this.getPosicao();
        int nMov1, nMov2;

        for (Coordenada direcao : this.movPossiveis) {
            //É verificado quantas posições a peça consegue se movimentar.
            for (nMov1 = 0; nMov1 < 2 && posTemp2.existePosicao(direcao); nMov1++) {
                posTemp2 = posTemp2.getPosicao(direcao);
            }

            //Se a peça tiver se movimentado duas casas, então é verificada o último movimento da peça.
            if (nMov1 == 2) {
                for (Coordenada ultimoMov : this.movPossiveis) {
                    if (posTemp2.existePosicao(ultimoMov) && posTemp2.getPosicao(ultimoMov) == novaPosicao) {
                        return true;
                    }
                }
                //Se a peça tiver andado apenas uma casa, então é verificado o resto das possibilidades.
            } else if (nMov1 == 1) {
                for (Coordenada ultimoMov : this.movPossiveis) {
                    for (nMov1 = 0; nMov1 < 2 && posTemp2.existePosicao(ultimoMov); nMov1++) {
                        posTemp2 = posTemp2.getPosicao(direcao);
                    }
                    if (nMov1 == 2) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}

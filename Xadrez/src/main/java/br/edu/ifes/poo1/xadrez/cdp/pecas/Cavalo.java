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
        int nMov;

        for (Coordenada direcao : this.movPossiveis) {
            //É verificado quantas posições a peça consegue se movimentar.
            for (nMov = 0; nMov < 2 && posTemp2.existePosicao(direcao); nMov++) {
                posTemp2 = posTemp2.getPosicao(direcao);
            }

            //Se a peça tiver se movimentado duas casas, então é verificada o último movimento da peça.
            if (nMov == 2) {
                for (Coordenada ultimoMov : this.movPossiveis) {
                    if (posTemp2.existePosicao(ultimoMov) && posTemp2.getPosicao(ultimoMov) == novaPosicao) {
                        return true;
                    }
                }
                //Se a peça tiver andado apenas uma casa, então é verificado o resto das possibilidades.
            } else if (nMov == 1) {
                for (Coordenada ultimoMov : this.movPossiveis) {
                    for (nMov = 0; nMov < 2 && posTemp2.existePosicao(ultimoMov); nMov++) {
                        posTemp2 = posTemp2.getPosicao(direcao);
                    }
                    if (nMov == 2 && posTemp2 == novaPosicao) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

}

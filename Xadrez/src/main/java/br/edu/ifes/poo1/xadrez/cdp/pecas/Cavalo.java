/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Coordenada;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import java.util.Set;

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
        return this.getPosicoesDisp().contains(novaPosicao);
    }

    public Set<Posicao> getPosicoesDisp() {
        
        throw new UnsupportedOperationException("Not supported yet.");
//        Set<Posicao> posicoesDisponiveis = new HashSet<>();
//        Posicao posTemp;
//
//        for (Coordenada direcao1 : this.movPossiveis) {
//            posTemp = this.getPosicao();
//            
//            for (int nMovimento = 0; nMovimento < 2; nMovimento++) {
//                if (posTemp.existePosicao(direcao1)) {
//                    posTemp = posTemp.getPosicao(direcao1);
//                } else {
//                    break;
//                }
//                for (Coordenada direcao2 : this.movPossiveis) {
//                    for (int nMovimento2 = (3 - nMovimento); nMovimento2 > 0; nMovimento2--) {
//                        if (posTemp.existePosicao(direcao2)) {
//                            posTemp = posTemp.getPosicao(direcao2);
//                        } else {
//                            break;
//                        }
//                        if (nMovimento2 == 1) {
//                            posicoesDisponiveis.add(posTemp);
//                        }
//                    }
//                }
//            }
//
////        }
//
//        return posicoesDisponiveis;
    }

}

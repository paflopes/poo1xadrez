/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.MovimentoPeca;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;

/**
 *
 * @author phillipe
 */
public class Rainha extends PecaImpl {

    public Rainha() {
        desenho = 'D';

    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao) {

        return MovimentoPeca.isDiagonal(this.posicao, novaPosicao) || MovimentoPeca.isStraight(this.posicao, novaPosicao);
    }

}

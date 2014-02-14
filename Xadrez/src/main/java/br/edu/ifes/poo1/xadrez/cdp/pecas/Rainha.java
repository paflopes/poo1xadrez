/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.MovimentoPeca;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import java.util.List;

/**
 *
 * @author phillipe
 */
public class Rainha extends PecaImpl {

    public Rainha(Cor cor) {
        super(cor, NomePeca.RAINHA, 9);
        this.setDesenho("D");
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao, Partida partida) {
        List<String> caminho;

        if (!novaPosicao.existePeca()) {
            if (MovimentoPeca.isDiagonal(this.getPosicao(), novaPosicao)) {
                caminho = MovimentoPeca.caminhoDiagonal(this.getPosicao(), novaPosicao);
                return !MovimentoPeca.haPeca(caminho, partida);
            } else if (MovimentoPeca.isStraight(this.getPosicao(), novaPosicao)) {
                caminho = MovimentoPeca.caminhoReto(this.getPosicao(), novaPosicao);
                return !MovimentoPeca.haPeca(caminho, partida);
            }
        }
        return false;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao, Partida partida) {
        List<String> caminho;

        if (novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != this.getCor()) {
            if (MovimentoPeca.isDiagonal(this.getPosicao(), novaPosicao)) {
                caminho = MovimentoPeca.caminhoDiagonal(this.getPosicao(), novaPosicao);
                return !MovimentoPeca.haPeca(caminho, partida);
            } else if (MovimentoPeca.isStraight(this.getPosicao(), novaPosicao)) {
                caminho = MovimentoPeca.caminhoReto(this.getPosicao(), novaPosicao);
                return !MovimentoPeca.haPeca(caminho, partida);
            }
        }

        return false;
    }

}

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
import java.util.List;

/**
 *
 * @author phillipe
 */
public class Rainha extends PecaImpl {

    public Rainha(Cor cor) {
        super(cor, NomePeca.RAINHA);
        this.setDesenho("D");
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        List<String> caminho;

        if (!novaPosicao.existePeca()) {
            if (MovimentoPeca.isDiagonal(this.getPosicao(), novaPosicao)) {
                caminho = MovimentoPeca.caminhoDiagonal(this.getPosicao(), novaPosicao);
                return !MovimentoPeca.haPeca(caminho);
            } else if (MovimentoPeca.isStraight(this.getPosicao(), novaPosicao)) {
                caminho = MovimentoPeca.caminhoReto(this.getPosicao(), novaPosicao);
                return !MovimentoPeca.haPeca(caminho);
            }
        }
        return false;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

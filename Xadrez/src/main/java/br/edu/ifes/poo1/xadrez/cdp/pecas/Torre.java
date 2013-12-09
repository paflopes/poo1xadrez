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
public class Torre extends PecaImpl {

    public Torre(Cor cor) {
        super(cor, NomePeca.TORRE);
        this.setDesenho("T");
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        List<String> caminho;

        if (!novaPosicao.existePeca()) {
            caminho = MovimentoPeca.caminhoReto(this.getPosicao(), novaPosicao);
            System.out.println(MovimentoPeca.haPeca(caminho));
            return MovimentoPeca.isStraight(this.getPosicao(), novaPosicao) && !MovimentoPeca.haPeca(caminho);
        }

        return false;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        List<String> caminho;

        if (novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != this.getCor()) {
            caminho = MovimentoPeca.caminhoReto(this.getPosicao(), novaPosicao);
            return MovimentoPeca.isStraight(this.getPosicao(), novaPosicao) && !MovimentoPeca.haPeca(caminho);
        }

        return false;
    }

}

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
public class Bispo extends PecaImpl {

    public Bispo(Cor cor) {
        super(cor, NomePeca.BISPO, 3);
        this.setDesenho("B");
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao, Partida partida) {
        List<String> caminho = MovimentoPeca.caminhoDiagonal(this.getPosicao(), novaPosicao);

        //O movimento só é válido quando for diagonal, não houver peças em seu caminho e não existir nenhuma peça na nova posição.
        return MovimentoPeca.isDiagonal(this.getPosicao(), novaPosicao) && !MovimentoPeca.haPeca(caminho, partida) && !novaPosicao.existePeca();
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao, Partida partida) {
        List<String> caminho = MovimentoPeca.caminhoDiagonal(this.getPosicao(), novaPosicao);

        //O movimento só é válido quando for diagonal, não houver peças em seu caminho,
        return MovimentoPeca.isDiagonal(this.getPosicao(), novaPosicao) && !MovimentoPeca.haPeca(caminho, partida)
                //existir uma peça na nova posição e esta peça for de outra cor.
                && novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != this.getCor();
    }

}

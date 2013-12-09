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
public class Bispo extends PecaImpl {

    public Bispo(Cor cor) {
        super(cor, NomePeca.BISPO);
        this.setDesenho("B");
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        char colunaInicial = this.getPosicao().getId().charAt(0);
        char linhaInicial = this.getPosicao().getId().charAt(1);
        char colunaDestino = novaPosicao.getId().charAt(0);
        char linhaDestino = novaPosicao.getId().charAt(1);
        List<String> caminho = MovimentoPeca.caminhoDiagonal(this.getPosicao(), novaPosicao);
        System.out.println(caminho);

        //O movimento só é válido quando for diagonal, não houver peças em seu caminho e não existir nenhuma peça na nova posição.
        return MovimentoPeca.isDiagonal(this.getPosicao(), novaPosicao) & !MovimentoPeca.haPeca(caminho) & !novaPosicao.existePeca();
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

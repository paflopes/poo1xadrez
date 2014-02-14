/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;
import br.edu.ifes.poo1.xadrez.cdp.Partida;

/**
 *
 * @author phillipe
 */
public class Cavalo extends PecaImpl {

    public Cavalo(Cor cor) {
        super(cor, NomePeca.CAVALO, 3);
        this.setDesenho("C");
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao, Partida partida) {
        char colunaAtual = this.getPosicao().getId().charAt(0);
        char linhaAtual = this.getPosicao().getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        if (!novaPosicao.existePeca()) {
            return ((Math.abs(colunaAtual - colunaNova) == 2) && (Math.abs(linhaAtual - linhaNova) == 1))
                    || ((Math.abs(colunaAtual - colunaNova) == 1) && (Math.abs(linhaAtual - linhaNova) == 2));
        }
        return false;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao, Partida partida) {
        char colunaAtual = this.getPosicao().getId().charAt(0);
        char linhaAtual = this.getPosicao().getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        if (novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != this.getCor()) {
            return ((Math.abs(colunaAtual - colunaNova) == 2) && (Math.abs(linhaAtual - linhaNova) == 1))
                    || ((Math.abs(colunaAtual - colunaNova) == 1) && (Math.abs(linhaAtual - linhaNova) == 2));
        }
        return false;
    }

}

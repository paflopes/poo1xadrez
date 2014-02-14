
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
public class Rei extends PecaImpl {

    public Rei(Cor cor) {
        super(cor, NomePeca.REI, 0);
        this.setDesenho("R");
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao, Partida partida) {
        char colunaAtual = this.getPosicao().getId().charAt(0);
        char linhaAtual = this.getPosicao().getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        return !novaPosicao.existePeca() && Math.abs(colunaAtual - colunaNova) <= 1 && Math.abs(linhaAtual - linhaNova) <= 1;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao, Partida partida) {
        char colunaAtual = this.getPosicao().getId().charAt(0);
        char linhaAtual = this.getPosicao().getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        //Tem que existir alguma peça na nova posição, além de serem de cores diferentes.
        return novaPosicao.existePeca() && novaPosicao.getPeca().getCor() != this.getCor()
                //O movimento tem que ser o mesmo que o de validar movimento.
                && Math.abs(colunaAtual - colunaNova) <= 1 && Math.abs(linhaAtual - linhaNova) <= 1;
    }
}

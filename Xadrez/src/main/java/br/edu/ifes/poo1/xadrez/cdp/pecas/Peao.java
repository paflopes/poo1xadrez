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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author phillipe
 */
public class Peao extends PecaImpl {

    private boolean moveuUmaVez = false;

    public Peao(Cor cor) {
        super(cor, NomePeca.PEAO, 1);
        this.setDesenho("P");
    }

    /**
     * Diz se o peão se moveu apenas uma vez.
     *
     * @return
     */
    public boolean moveuUmaVez() {
        return moveuUmaVez;
    }

    @Override
    public void setPosicao(Posicao posicao) {
        this.moveuUmaVez = !this.jaMovimentou();
        super.setPosicao(posicao);
    }

    @Override
    public boolean validarMovimento(Posicao novaPosicao, Partida partida) {
        char colunaAtual = this.getPosicao().getId().charAt(0);
        char linhaAtual = this.getPosicao().getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        List<String> caminho = new ArrayList<>();
        int linhasAndadas = linhaNova - linhaAtual;

        /**
         * Defino o caminho da peça.
         */
        if (this.getCor() == Cor.PRETO) {
            caminho.add("" + colunaAtual + (char) (linhaAtual - 1));
            caminho.add("" + colunaAtual + (char) (linhaAtual - 2));
        } else {
            caminho.add("" + colunaAtual + (char) (linhaAtual + 1));
            caminho.add("" + colunaAtual + (char) (linhaAtual + 2));
        }

        /**
         * Se não for o primeiro movimento, então o Peão anda apenas uma casa. O
         * peão anda duas ou uma casa, caso contrário.
         */
        if (this.jaMovimentou()) {
            switch (this.getCor()) {
                case BRANCO:
                    return (linhasAndadas == 1 && colunaAtual == colunaNova && !novaPosicao.existePeca());
                case PRETO:
                    return (linhasAndadas == -1 && colunaAtual == colunaNova && !novaPosicao.existePeca());
            }
        } else {
            switch (this.getCor()) {
                case BRANCO:
                    return ((linhasAndadas == 2 || linhasAndadas == 1) && colunaAtual == colunaNova && !MovimentoPeca.haPeca(caminho, partida));
                case PRETO:
                    return ((linhasAndadas == -2 || linhasAndadas == -1) && colunaAtual == colunaNova && !MovimentoPeca.haPeca(caminho, partida));
            }
        }
        return false;
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao, Partida partida) {
        char colunaAtual = this.getPosicao().getId().charAt(0);
        char linhaAtual = this.getPosicao().getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        /**
         * Se a peça não existir, então não há captura e um movimento deverá ser
         * realizado.
         */
        if (novaPosicao.existePeca() && (novaPosicao.getPeca().getCor() != this.getCor())) {
            /**
             * Se a peça for branca, verificamos nas diagonais para cima, caso
             * contrário verificamos as diagonais abaixo.
             */
            if (this.getCor() == Cor.BRANCO) {
                return (Math.abs(colunaAtual - colunaNova) == 1) && ((linhaNova - linhaAtual) == 1);
            } else {
                return (Math.abs(colunaAtual - colunaNova) == 1) && ((linhaNova - linhaAtual) == -1);
            }
        } else {
            return false;
        }
    }

}

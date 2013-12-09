/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

/**
 *
 * @author leds
 */
public class MovimentoPeca {

    public static boolean isDiagonal(Posicao posicaoAtual, Posicao novaPosicao) {
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        return Math.abs(colunaAtual - colunaNova) == Math.abs(linhaAtual - linhaNova);
    }

    public static boolean isStraight(Posicao posicaoAtual, Posicao novaPosicao) {
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        return ((colunaAtual - colunaNova) == 0) || ((linhaAtual - linhaNova) == 0);
    }

    public static boolean isEnPassant(Posicao posicao) {

        return false;
    }

    public static boolean isRoque(Posicao posicao) {

        return false;
    }

    /**
     * Verifica se todas as posições no caminho dado estão sem peças.
     *
     * @param caminho O caminho a ser verificado no Tabuleiro.
     * @return {@code true} se não houver peças em nenhuma das posições,
     * {@code false} caso contrário.
     */
    public static boolean haPeca(String[] caminho) {
        Tabuleiro tab = Tabuleiro.getInstance();
        boolean haPeca = true;
        
        for (String idPosicao : caminho) {
            haPeca = haPeca && tab.getPosicao(idPosicao).existePeca();
        }

        return haPeca;
    }

    /**
     * Verifica se há alguma peça na posição dada.
     *
     * @param idPosicao
     * @return
     */
    public static boolean haPeca(String idPosicao) {
        return Tabuleiro.getInstance().getPosicao(idPosicao).existePeca();
    }
}

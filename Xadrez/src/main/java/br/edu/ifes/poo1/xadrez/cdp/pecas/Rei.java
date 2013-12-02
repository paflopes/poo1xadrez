/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Posicao;

/**
 *
 * @author phillipe
 */
public class Rei extends Peca {

    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        char colunaAtual = this.posicao.getId().charAt(0);
        char linhaAtual = this.posicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        
        return Math.abs(colunaAtual - colunaNova)<=1 && Math.abs(linhaAtual - linhaNova)<=1;
    }
    
}

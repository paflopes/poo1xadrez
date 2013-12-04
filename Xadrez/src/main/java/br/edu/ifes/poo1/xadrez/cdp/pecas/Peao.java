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
public class Peao extends PecaImpl{

    public Peao() {
        desenho = 'P';
        
    }

    
    
    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        char colunaAtual = this.posicao.getId().charAt(0);
        char linhaAtual = this.posicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        
        if(linhaAtual == 2 || linhaAtual == 7){
            return Math.abs(linhaNova - linhaAtual) <= 2;
        }else{
            return Math.abs(linhaNova - linhaAtual) == 1;
        }        
    }
    
}

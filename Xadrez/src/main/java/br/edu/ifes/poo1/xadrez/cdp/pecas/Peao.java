/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.TipoPeca;

/**
 *
 * @author phillipe
 */
public class Peao extends PecaImpl{

    public Peao() {
        desenho = "P";
        tipo=TipoPeca.PEAO;
        
        
    }

    
    
    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        char colunaAtual = this.posicao.getId().charAt(0);
        char linhaAtual = this.posicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
                
        if(linhaAtual == '2' || linhaAtual == '7'){
            return Math.abs(linhaNova - linhaAtual) <= 2;
        }else{
            return Math.abs(linhaNova - linhaAtual) == 1;
        }        
    }
    
    /**
     *
     * @param novaPosicao
     * @return
     */
    
    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao){
        char colunaAtual = this.posicao.getId().charAt(0);
        char linhaAtual = this.posicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        
        return ((this.getCor()==Cor.BRANCO)&&(Math.abs(colunaAtual-colunaNova)==1) && (linhaNova - linhaAtual)==1) || 
               ((this.getCor()==Cor.PRETO)&&(Math.abs(colunaAtual-colunaNova)==1) && (linhaNova - linhaAtual)==-1);
        
    }
    
}

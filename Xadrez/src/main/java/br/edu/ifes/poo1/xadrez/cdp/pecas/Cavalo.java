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
public class Cavalo extends PecaImpl {

    public Cavalo() {
        desenho = "C";
        tipo=TipoPeca.CAVALO;
        
    }
    
    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        char colunaAtual = this.posicao.getId().charAt(0);
        char linhaAtual = this.posicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        return ((Math.abs(colunaAtual - colunaNova) == 2) && (Math.abs(linhaAtual - linhaNova) == 1))
                || ((Math.abs(colunaAtual - colunaNova) == 1) && (Math.abs(linhaAtual - linhaNova) == 2));
    }

    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

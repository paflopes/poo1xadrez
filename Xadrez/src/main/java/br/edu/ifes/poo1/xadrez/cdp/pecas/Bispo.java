/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecas;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.MovimentoPeca;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.TipoPeca;

/**
 *
 * @author phillipe
 */
public class Bispo extends PecaImpl {

    public Bispo() {
        desenho = "B";
        tipo=TipoPeca.BISPO;
        
    }
    
    @Override
    public boolean validarMovimento(Posicao novaPosicao) {
        
        return MovimentoPeca.isDiagonal(this.getPosicao(), novaPosicao);
    }
    
    @Override
    public boolean validarMovimentoCaptura(Posicao novaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

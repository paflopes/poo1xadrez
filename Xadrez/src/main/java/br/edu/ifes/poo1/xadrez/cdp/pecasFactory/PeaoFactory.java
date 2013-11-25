/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecasFactory;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Peao;
import br.edu.ifes.poo1.xadrez.cdp.Peca;
import java.util.Map;

/**
 *
 * @author leds
 */
public class PeaoFactory extends PecasFactory {

    @Override
    protected void instanciaPecas(Map<Cor, Peca[]> pecas) {
        Peca[] peoesBrancos = pecas.get(Cor.BRANCO);
        Peca[] peoesPretos = pecas.get(Cor.PRETO);
        
        for (int nPeao = 0; nPeao < peoesBrancos.length; nPeao++) {
            peoesBrancos[nPeao] = new Peao();
            peoesBrancos[nPeao].setCor(Cor.BRANCO);
        }
        for (int nPeao = 0; nPeao < peoesPretos.length; nPeao++) {
            peoesPretos[nPeao] = new Peao();
            peoesPretos[nPeao].setCor(Cor.PRETO);
        }
    }

}

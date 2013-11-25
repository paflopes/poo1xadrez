/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecasFactory;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Peca;
import br.edu.ifes.poo1.xadrez.cdp.Torre;
import java.util.Map;

/**
 *
 * @author leds
 */
public class BispoFactory extends PecasFactory {

    @Override
    protected void instanciaPecas(Map<Cor, Peca[]> pecas) {
        Peca[] bisposBrancos = pecas.get(Cor.BRANCO);
        Peca[] bisposPretos = pecas.get(Cor.PRETO);

        for (int nBispo = 0; nBispo < bisposBrancos.length; nBispo++) {
            bisposBrancos[nBispo] = new Torre();
            bisposBrancos[nBispo].setCor(Cor.BRANCO);
        }

        for (int nBispo = 0; nBispo < bisposPretos.length; nBispo++) {
            bisposPretos[nBispo] = new Torre();
            bisposPretos[nBispo].setCor(Cor.PRETO);
        }
    }
}

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
public class TorreFactory extends PecasFactory {

    @Override
    protected void instanciaPecas(Map<Cor, Peca[]> pecas) {
        Peca[] torresBrancas = pecas.get(Cor.BRANCO);
        Peca[] torresPretas = pecas.get(Cor.PRETO);

        for (int nTorre = 0; nTorre < torresBrancas.length; nTorre++) {
            torresBrancas[nTorre] = new Torre();
            torresBrancas[nTorre].setCor(Cor.BRANCO);
        }

        for (int nTorre = 0; nTorre < torresPretas.length; nTorre++) {
            torresPretas[nTorre] = new Torre();
            torresPretas[nTorre].setCor(Cor.PRETO);
        }
    }

}

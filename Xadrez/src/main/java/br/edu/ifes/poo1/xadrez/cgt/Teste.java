/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Cavalo;
import java.util.Set;

/**
 *
 * @author phillipe
 */
public class Teste {

    public static void main(String[] args) {

        Set<Posicao> posicoes = ((Cavalo)Tabuleiro.getInstance().getPosicao("21").getPeca()).getPosicoesDisp();
        
        for(Posicao posicao: posicoes)
            System.out.println(Tabuleiro.getInstance().getIdPosicao(posicao));
        
        
        
    }

}

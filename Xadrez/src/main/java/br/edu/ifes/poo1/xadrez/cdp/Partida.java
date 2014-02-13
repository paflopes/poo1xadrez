/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import java.io.Serializable;

/**
 *
 * @author Lincoln
 */
public class Partida implements Serializable {

    public Partida(Jogador jogadorBranco, Jogador jogadorPreto, Tabuleiro tabuleiro) {
        this.jogadorBranco = jogadorBranco;
        this.jogadorPreto = jogadorPreto;
        this.tabuleiro = tabuleiro;    
    }
    
    
    
    private Jogador jogadorBranco;
    private Jogador jogadorPreto;
    private Tabuleiro tabuleiro;
    
}

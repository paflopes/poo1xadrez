/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;

/**
 *
 * @author phillipe
 */
public interface Jogador {

    public String getNome();

    public Jogada getJogada();

    public Cor getCor();

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Lincoln
 */
public class Partida implements Serializable {
  
    
    private boolean finalizada = false;
    private Jogador jogadorBranco;
    private Jogador jogadorPreto;
    private Tabuleiro tabuleiro;
    private Date inicio;
    private Date fim;

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public boolean isFinalizada() {
        return finalizada;
    }

    public void setFinalizada(boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Jogador getJogadorBranco() {
        return jogadorBranco;
    }

    public void setJogadorBranco(Jogador jogadorBranco) {
        this.jogadorBranco = jogadorBranco;
    }

    public Jogador getJogadorPreto() {
        return jogadorPreto;
    }

    public void setJogadorPreto(Jogador jogadorPreto) {
        this.jogadorPreto = jogadorPreto;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    
    public int getPartidasNaoFinalizadas(ArrayList<Partida> listPartidas){
        int numeroPartidas=0;
        for(int contador = 0; contador<listPartidas.size(); contador++){
            if(listPartidas.get(contador).isFinalizada() == false){
                numeroPartidas++;
            }
        }
        return numeroPartidas;
    }
    
}

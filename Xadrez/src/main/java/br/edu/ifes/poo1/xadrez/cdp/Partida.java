/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Lincoln
 */
public class Partida implements Serializable {
  
    private boolean finalizada;
    private Jogador jogadorBranco;
    private Jogador jogadorPreto;
    private Tabuleiro tabuleiro;
    private Date inicio;
    private Date fim;
    private String vencedor;
    private String turno;
    private boolean partidaInterrompida;

    public boolean isPartidaInterrompida() {
        return partidaInterrompida;
    }

    public void setPartidaInterrompida(boolean partidaInterrompida) {
        this.partidaInterrompida = partidaInterrompida;
    }
    
    
    
     public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    public String getVencedor() {
        return vencedor;
    }

    public void setVencedor(String vencedor) {
        this.vencedor = vencedor;
    }

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

    public  Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }
    

    
    public void iniciaPartida(){
        this.turno = "jogadorBranco";
        this.inicio = new Date();
        this.tabuleiro = new Tabuleiro();
        this.vencedor = "Em andamento";
        this.finalizada = false;
        this.partidaInterrompida = false;
    }
    
    public void recomeçarPartida(){
        this.partidaInterrompida = false;
        this.jogadorBranco.setSave(false);
        if(!jogadorPreto.getNome().equals("ZEUS")){
            this.jogadorPreto.setSave(false);
        }
    }
    
    public void encerrarPartida(String nome){
    
        this.partidaInterrompida = true;
        this.fim = new Date();
        this.vencedor = nome;
        this.finalizada = true;
    
    }
}

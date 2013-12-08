/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

/**
 *
 * @author Lincoln
 */
public class Jogador {
    
    private String nome;
    private String jogada;
    private int pontos;
    private boolean vitoria;
    private Cor cor;
    
    /**
     *
     */
    public Jogador(){
        pontos=0;
        vitoria=false;        
    }
    
    
    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the jogada
     */
    public String getJogada() {
        return jogada;
    }

    /**
     * @param jogada the jogada to set
     */
    public void setJogada(String jogada) {
        this.jogada = jogada;
    }

 
    /**
     * @return the pontos
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * @param pontos the pontos to set
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /**
     * @return the vitoria
     */
    public boolean isVitoria() {
        return vitoria;
    }

    /**
     * @param vitoria the vitoria to set
     */
    public void setVitoria(boolean vitoria) {
        this.vitoria = vitoria;
    }

    /**
     * @return the cor
     */
    public Cor getCor() {
        return cor;
    }

    /**
     * @param cor the cor to set
     */
    public void setCor(Cor cor) {
        this.cor = cor;
    }
    
    
}

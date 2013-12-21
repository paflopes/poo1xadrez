/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.jogo;

import java.util.List;

/**
 *
 * @author Lincoln
 */
public class DadoJogo {

    private String nome;
    private int pontos;

    public DadoJogo() {
        pontos = 0;
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

    public static void setListaDados(JogadorHumano jogador, List<DadoJogo> listaDadoJogo) {
        boolean achouNaListaa = false;        
        if(jogador.getNome().equals("ZEUS")){
            return;
        }        
        for(int contador = 0; contador< listaDadoJogo.size(); contador++){
            if(listaDadoJogo.get(contador).getNome().equals(jogador.getNome())){
                if(jogador.isVitoria()){
                    listaDadoJogo.get(contador).setPontos(listaDadoJogo.get(contador).getPontos() + 1);
                }
                achouNaListaa = true;
            }
        }
        
        if(achouNaListaa == false){
            DadoJogo dados = new DadoJogo();
            dados.setNome(jogador.getNome());
            if(jogador.isVitoria()){
                dados.setPontos(1);
            }
            listaDadoJogo.add(dados);
        }     
        
    }

}


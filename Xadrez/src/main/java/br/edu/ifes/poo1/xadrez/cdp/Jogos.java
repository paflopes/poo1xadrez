/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.jogo.DadoJogo;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lincoln
 */
public class Jogos implements Serializable {
    
    private  ArrayList<Partida> listPartidasFinalizadas = new ArrayList<>();
    private  ArrayList<Partida> listPartidasNaoFinalizadas = new ArrayList<>();
    private  ArrayList<DadoJogo> listDadosJogos = new ArrayList<>();

   
    
    public ArrayList<DadoJogo> getListDadoJogo() {
        return listDadosJogos;
    }

    
    
    public  ArrayList<Partida> getListPartidasFinalizadas() {
        return listPartidasFinalizadas;
    }
    
    public  ArrayList<Partida> getListPartidasNaoFinalizadas() {
        return listPartidasNaoFinalizadas;
    }

    public void setlistPartidasFinalizadas(ArrayList<Partida> listPartidasFinalizadas) {
        this.listPartidasFinalizadas = listPartidasFinalizadas;
    }
    
    public void setlistPartidasNaoFinalizadas(ArrayList<Partida> listPartidasNaoFinalizadas) {
        this.listPartidasNaoFinalizadas = listPartidasNaoFinalizadas;
    }
    
    public void setListDadosJogos(Jogador jogador, List<DadoJogo> listaDadoJogo) {
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

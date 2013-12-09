/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import java.util.ArrayList;

/**
 *
 * @author Lincoln
 */
public class DadosPartida {
    
    private static final DadosPartida instance = new DadosPartida();
    private ArrayList<Dados> listaDados = new ArrayList<Dados>();
    
    
    public static DadosPartida getInstance() {
        return DadosPartida.instance;
    }

    /**
     * @return the listaDados
     */
    public ArrayList<Dados> getListaDados() {
        return listaDados;
    }

    public String retornaNome(int posicao){
        return DadosPartida.getInstance().getListaDados().get(posicao).getNome();
    }
    
    
    
    public void setListaDados(Jogador jogador) {
        boolean achouNaListaa = false;        
        for(int contador = 0; contador< DadosPartida.getInstance().getListaDados().size(); contador++){
            if(retornaNome(contador).equals(jogador.getNome())){
                if(jogador.isVitoria()){
                    DadosPartida.getInstance().getListaDados().get(contador).setPontos(DadosPartida.getInstance().getListaDados().get(contador).getPontos() + 1);
                }
                achouNaListaa = true;
            }
        }
        
        if(achouNaListaa == false){
            Dados dados = new Dados();
            dados.setNome(jogador.getNome());
            if(jogador.isVitoria()){
                dados.setPontos(1);
            }
            DadosPartida.getInstance().getListaDados().add(dados);
        }     
        
    }
    
}

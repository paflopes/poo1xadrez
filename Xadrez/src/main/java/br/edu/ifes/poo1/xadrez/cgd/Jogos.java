/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cgd;

import br.edu.ifes.poo1.xadrez.cdp.Partida;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Lincoln
 */
public class Jogos implements Serializable {
    
    private  ArrayList<Partida> listPartidas = new ArrayList<Partida>();

    

    
    
    public  ArrayList<Partida> getListPartidas() {
        return listPartidas;
    }

    public void setListPartidas(ArrayList<Partida> listPartidas) {
        this.listPartidas = listPartidas;
    }
    
}

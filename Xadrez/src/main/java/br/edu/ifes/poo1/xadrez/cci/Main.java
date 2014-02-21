/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cgt.JogoApl;
import br.edu.ifes.poo1.xadrez.cih.Impressora;

/**
 *
 * @author phillipe
 */
public class Main {

    public static void main(String[] args) throws ClassNotFoundException, PartidaEncerradaException {
        ControleGeral controle = new ControleGeral();

        controle.run();
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.app;

import br.edu.ifes.poo1.xadrez.cci.ControleGeral;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;

/**
 *
 * @author Lincoln
 */
public class Main {

    public static void main(String[] args) throws CloneNotSupportedException {
        ControleGeral controleGeral = new ControleGeral();
        Tabuleiro clone;
        Peca pos1, pos2, pos3;
        clone = (Tabuleiro) Tabuleiro.getInstance().clone();

//        System.out.println(clone == Tabuleiro.getInstance());
//        System.out.println(clone.getPosicao("11") == Tabuleiro.getInstance().getPosicao("11"));
//        System.out.println(clone.getMapNomePosicao());
        pos1 = clone.getPosicao("11").getPeca();
        clone.getPosicao("44").setPeca(pos1);

        controleGeral.exibirMenu();
    }
}

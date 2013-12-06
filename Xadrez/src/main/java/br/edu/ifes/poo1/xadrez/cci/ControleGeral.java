/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Jogador;
import br.edu.ifes.poo1.xadrez.cgt.Controle;
import br.edu.ifes.poo1.xadrez.cih.Impressao;
import java.util.Scanner;

/**
 *
 * @author Lincoln
 */
public class ControleGeral {
    
    private Impressao impressora = new Impressao();
    private Controle controle = new Controle();
    private boolean jogadaValida;
    
    public void exibirMenu(){
           
        impressora.imprimiMenu();
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        if(escolha==1){
            Jogador jogadorBranco = cadastraJogador("branca");
            Jogador jogadorPreto = cadastraJogador("preta");

            while(true){
                impressora.imprimiTabuleiro();
                jogadorBranco.setJogada(pedeJogada(jogadorBranco));
                controle.processaJogada(jogadorBranco);
                
                
                
                
            
            
            }


        }		



    }
    
    public String pedeJogada(Jogador jogador){
        impressora.imprimiPedidoMovimento(jogador);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public Jogador cadastraJogador(String cor) {	
        impressora.imprimiPedidoNomeJogador(cor);
        Jogador jogador = new Jogador();
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        jogador.setNome(nome);
        jogador.setCor(cor);
        return jogador;

    }    
    
    
    
    
}




    

    


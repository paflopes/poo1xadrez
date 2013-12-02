/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cgt.Controle;
import br.edu.ifes.poo1.xadrez.cih.Impressao;
import java.util.Scanner;

/**
 *
 * @author Lincoln
 */
public class ControleGeral {
    
    private Impressao impressora = new Impressao();

    public void exibirMenu(){
            impressora.imprimiMenu();
            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();
            if(escolha==1){
                    Jogador jogadorBranco = cadastraJogador("branca");
                    Jogador jogadorPreto = cadastraJogador("preta");
                    
                    impressora.imprimiTabuleiro(Tabuleiro.getInstance());


            }		



    }

    /*public Jogador processaPartida(Jogador jogadorBranco, Jogador jogadorPreto) {
        boolean vitoria = false;
        Controle controle = new Controle();
        while(vitoria==false){
            impressora.imprimiPedidoMovimento(jogadorBranco);
            Scanner scanner = new Scanner(System.in);
            String jogada = scanner.nextLine();
            if(jogada.equals("O-O-O")){

            }else{
                if(jogada.equals("O-O")){

                }else{
                    if(jogada.equals("pontos")){

                    }else{
                        if(jogada.equals("desistir")){

                        }else{
                            if(jogada.equals("empate")){

                            }else{
                                
                            }
                        }
                    }
                }
            }
        }			
    }*/

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




    

    


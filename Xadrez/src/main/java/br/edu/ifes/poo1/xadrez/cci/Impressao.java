/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;

/**
 *
 * @author 20121bsi0236
 */
public class Impressao {
    
    public void imprimir(String nome) {
		System.out.println(nome);
	}
	
    public void imprimiMenu() {
            imprimir("Jogo de Xadrez");
            imprimir("1 - Nova partida");
            imprimir("2 - Dados das partidas");
            imprimir("3 - Sair");
    }


    public void imprimiPedidoNomeJogador(String cor) {
            imprimir("Digite o nome do jogador com as peças de cor "+cor+": ");

    }


    public void imprimiTabuleiro(Tabuleiro tabuleiro) {
            imprimir("_________________");
            for(int countColuna = 0; countColuna<8;countColuna++){
                    for(int countLinha = 0; countLinha<8; countLinha++){
                        String idPosicao = "" +countColuna +countLinha;
                        if(Tabuleiro.getInstance().getPosicao(idPosicao) == null){
                            System.out.print("| ");
                        }else{
                            System.out.print(Tabuleiro.getInstance().getPosicao(idPosicao).getPeca().getDesenho());
                        }
                    }
                    imprimir("|");
                    imprimir("_________________");
            }

    }

    public void imprimiPedidoMovimento(Jogador jogador) {		
            imprimir("Digite o movimento "+jogador.getNome());
    }

    public void imprimiPontos(Jogador jogador) {
            imprimir("Pontos do jogador "+jogador.getNome()+": "+jogador.getPontos());
    }	
    
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cih;

import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;

/**
 *
 * @author 20121bsi0236
 */
public class Impressora {

    private void imprimir(String nome) {
        System.out.println(nome);
    }
    
    private void imprimir(Object objeto) {
        System.out.println(objeto);
    }

    public void imprimirMenu() {
        imprimir("Jogo de Xadrez");
        imprimir("1 - Nova partida");
        imprimir("2 - Dados das partidas");
        imprimir("3 - Sair");
    }

    public void pedirNomeJogador(String cor) {
        imprimir("Digite o nome do jogador com as peças de cor " + cor + ": ");
    }

    public void imprimirTabuleiro(Tabuleiro tabuleiro) {
        imprimir(tabuleiro);
    }

    public void pedirMovimento(Jogador jogador) {
        imprimir("Digite o movimento " + jogador.getNome()+":");
    }

    public void imprimiPontos(Jogador jogador) {
        imprimir("Pontos do jogador " + jogador.getNome() + ": " + jogador.getPontos());
    }
}

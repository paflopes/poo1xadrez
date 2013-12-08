/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cih;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
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

    public void imprimiPedidoNomeJogador(Cor cor) {
        imprimir("Digite o nome do jogador com as peças de cor " + cor + ": ");

    }

    public void imprimiTabuleiro() {
        
        
        imprimir("    1   2   3   4   5   6   7   8");
        imprimir("  ---------------------------------");
        for (int countLinha = 8; countLinha > 0; countLinha--) {
            System.out.print(countLinha+" ");
            for (int countColuna = 1; countColuna < 9; countColuna++) {
                String idPosicao = "" + countColuna + countLinha;
                if (!Tabuleiro.getInstance().getPosicao(idPosicao).existePeca()) {
                    System.out.print("|   ");
                } else {
                    if(Tabuleiro.getInstance().getPosicao(idPosicao).getPeca().getCor()==Cor.BRANCO){
                        System.out.print("|" + Tabuleiro.getInstance().getPosicao(idPosicao).getPeca().getDesenho()+".b");
                    }else{
                        System.out.print("|" + Tabuleiro.getInstance().getPosicao(idPosicao).getPeca().getDesenho()+".p");
                    }
                }
            }
            System.out.print("|");
            imprimir(" " +countLinha);
            imprimir("  ---------------------------------");
        }
        imprimir("    1   2   3   4   5   6   7   8");

    }

    public void imprimiPedidoMovimento(Jogador jogador) {
        imprimir("Digite o movimento " + jogador.getNome()+":");
    }

    public void imprimiPontos(Jogador jogador) {
        imprimir("Pontos do jogador " + jogador.getNome() + ": " + jogador.getPontos());
    }
    
    public void imprimiJogadaInvalida(){
        imprimir("Jogada invalida!");
    }
    
    public void imprimiPedidoEmpate(){
        imprimir("Deseja aceitar o empate jogador adversario? S/N");
    }
    
    public void imprimiEmpate(){
        imprimir("Jogo empatado");
    }
    
    public void imprimiVencedor(Jogador jogador){
        imprimir("O jogador " +jogador.getNome() +" ganhou");
    }
}

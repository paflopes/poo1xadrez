/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cih;

import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorHumano;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.jogo.DadoJogo;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

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

    /**
     * Imprime o menu inicial do jogo.
     */
    public void imprimirMenu() {
        clearConsole();
        imprimir("Jogo de Xadrez");
        imprimir("1 - Nova partida");
        imprimir("2 - Dados das partidas");
        imprimir("3 - Sair");
    }

    /**
     * Pergunta se o jogador deseja jogar sozinho.
     */
    public void imprimirOpcaoJogarSozinho() {
        clearConsole();
        imprimir("Deseja jogar sozinho?");
        imprimir("1 - Sim");
        imprimir("2 - Não");
    }

    /**
     * Pega a última opção digitada no console.
     *
     * @return O inteiro que representa a opção desejada.
     */
    public int getOpcao() {
        Scanner scanner = new Scanner(System.in);
        int opcao = scanner.nextInt();

        return opcao;
    }

    /**
     * Pega o que foi digitado no console.
     *
     * @return A string digitada no console.
     */
    public String getString() {
        Scanner scanner = new Scanner(System.in);
        String opcao = scanner.nextLine();

        return opcao;
    }

    public void pedirNomeJogador(String cor) {
        clearConsole();
        imprimir("Digite o nome do jogador com as peças de cor " + cor + ": ");
    }

    public void imprimirArgumentoInvalido() {
        imprimir("Argumento inválido!!");
        imprimir("Digite novamente:");
    }

    public void imprimirJogadaInvalida() {
        imprimir("Jogada inválida!!");
    }

    public void imprimirTabuleiro(Tabuleiro tabuleiro) {
        clearConsole();
        imprimir(tabuleiro);
    }

    public void pedirMovimento(String nomeJogador) {
        imprimir("Digite o movimento " + nomeJogador + ":");
    }

    public void imprimirPontos(JogadorHumano jogador) {
        clearConsole();
        imprimir("Pontos do jogador " + jogador.getNome() + ": " + jogador.getPontos());
    }

    /**
     * Limpa o console onde o jogo é exibido. Funciona no Windows, Linux e Mac.
     */
    private void clearConsole() {
        try {
            String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException exception) {
            System.out.println("");
        }
    }
    
    public void imprimiEmpate(){
        imprimir("Deseja aceitar o empate? S/N");
    }
    
    public void imprimirDados(List<DadoJogo> listaDadoJogo){
        imprimir("Nomes:                        Pontos:");
        for(int contador = 0;contador < listaDadoJogo.size(); contador++){
            System.out.println(listaDadoJogo.get(contador).getNome());
            for(int espaco = 30 - listaDadoJogo.get(contador).getNome().length(); espaco>0; espaco--){
                System.out.println(" ");
            }        
            imprimir(listaDadoJogo.get(contador).getPontos());
        }
    }
    
    
}

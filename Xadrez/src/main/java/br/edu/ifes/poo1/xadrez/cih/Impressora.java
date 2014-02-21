/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cih;

import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorHumano;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.Jogos;
import java.io.IOException;
import java.util.ArrayList;
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
        imprimir("1 - Iniciar uma nova partida");
        imprimir("2 - Retomar uma partida");
        imprimir("3 - Dados das partidas");
        imprimir("4 - Sair");
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
        imprimir("Pecas capturadas: "+jogador.getPecasCapturadas());
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
    
    public void imprimiGanhador(Jogador jogador){
        imprimir("O jogador/jogador " +jogador.getNome() +"venceu a partida.");
    }
    
    public void imprimiFimJogo(){
        imprimir("Jogo finalizado.");
    }
    
    public void imprimiEmpate(){
        imprimir("Jogo empatado.");
    }
    public void imprimiPedidoEmpate(){
        imprimir("Deseja aceitar o empate? S/N");
    }
    
    public void imprimirDados( Jogos jogos){
        
        imprimir("Partidas: \n");
        for(int contador = 0; contador<jogos.getListPartidasFinalizadas().size();contador++){
            imprimir("Partida "+contador +": Inicio:" +jogos.getListPartidasFinalizadas().get(contador).getInicio() +" Fim: "+jogos.getListPartidasFinalizadas().get(contador).getFim());
            imprimir("Jogador branco: "+jogos.getListPartidasFinalizadas().get(contador).getJogadorBranco().getNome() +" Jogador preto: " +jogos.getListPartidasFinalizadas().get(contador).getJogadorPreto().getNome());
            imprimir("Vencedor: " +jogos.getListPartidasFinalizadas().get(contador).getVencedor()+"\n");
        }
          
        
        for(int contadorAux = 0; contadorAux<jogos.getListPartidasNaoFinalizadas().size() ;contadorAux++){
            imprimir("Partida "+(contadorAux + jogos.getListPartidasFinalizadas().size()) +": Inicio:" +jogos.getListPartidasNaoFinalizadas().get(contadorAux).getInicio() +" Fim: "+jogos.getListPartidasNaoFinalizadas().get(contadorAux).getFim());
            imprimir("Jogador branco: "+jogos.getListPartidasNaoFinalizadas().get(contadorAux).getJogadorBranco().getNome() +" Jogador preto: " +jogos.getListPartidasNaoFinalizadas().get(contadorAux).getJogadorPreto().getNome());
            imprimir("Vencedor: " +jogos.getListPartidasNaoFinalizadas().get(contadorAux).getVencedor()+"\n");
        }
        
        
        imprimir("\nNomes:                        Pontos:");      
        for(int contador = 0;contador < jogos.getListDadoJogo().size(); contador++){
            System.out.print(jogos.getListDadoJogo().get(contador).getNome());
            for(int espaco = 30 - jogos.getListDadoJogo().get(contador).getNome().length(); espaco>0; espaco--){
                System.out.print(" ");
            }        
            imprimir(jogos.getListDadoJogo().get(contador).getPontos());
        }
    }
    
    public void imprimirPartidas(ArrayList<Partida> listPartidas){
     
        int contador = 0, contadorAux = 0;
        while(contador<listPartidas.size()){
            if(listPartidas.get(contador).isFinalizada() == false){
                imprimir("Partida "+contadorAux);
                imprimir("Jogador branco: "+listPartidas.get(contador).getJogadorBranco().getNome()+" Jogador preto: "+listPartidas.get(contador).getJogadorPreto().getNome());
                contadorAux++;
            }
            contador++;        
        }
       
    }
    
    public void imprimiErroSaida(){
        imprimir("Salve primeiro para sair.");
    }
    
    public void imprimirJogoSalvo(){
        imprimir("Jogo salvo com sucesso.");
    }
    
    public void imprimirSemPartidas(){
        imprimir("Não existe nenhuma partida para ser retomada.");
    }
    
    public void imprimirSemDados(){
        imprimir("Não há dados sobre nenhuma partida ou jogador ainda.");
    }
    
    public void imprimirEscolhaPartida(){
        imprimir("Digite o numero da partida para retoma-la.");
    }
}

                
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.DadosPartida;
import br.edu.ifes.poo1.xadrez.cdp.Jogador;
import br.edu.ifes.poo1.xadrez.cgt.Controle;
import br.edu.ifes.poo1.xadrez.cih.Impressao;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Lincoln
 */
public class ControleGeral {
    
    private Impressao impressora = new Impressao();
    private Controle controle = new Controle();
    private boolean jogadaValida;
    
    public void exibirMenu() throws IOException{
           
        impressora.imprimiMenu();
        Scanner scanner = new Scanner(System.in);
        int escolha = scanner.nextInt();
        if(escolha==1){
            Jogador jogadorBranco = cadastraJogador(Cor.BRANCO);
            Jogador jogadorPreto = cadastraJogador(Cor.PRETO);

            while(true){
                
                jogada(jogadorBranco);
                
                if(isDesistencia(jogadorBranco.getJogada())){
                    impressora.imprimiVencedor(jogadorPreto);
                    DadosPartida.getInstance().setListaDados(jogadorPreto);
                    break;
                }
                
                if(jogadorBranco.isVitoria()){
                    impressora.imprimiVencedor(jogadorBranco);
                    DadosPartida.getInstance().setListaDados(jogadorBranco);
                    break;
                }
                
                jogada(jogadorPreto);
                if(isDesistencia(jogadorPreto.getJogada())){
                    impressora.imprimiVencedor(jogadorBranco);
                    DadosPartida.getInstance().setListaDados(jogadorBranco);
                    break;
                }
                
                if(jogadorPreto.isVitoria()){
                    impressora.imprimiVencedor(jogadorPreto);
                    DadosPartida.getInstance().setListaDados(jogadorPreto);
                    break;
                }
            
            }
        }
    }
    
    private void jogada(Jogador jogador) {
        impressora.imprimiTabuleiro();
        jogador.setJogada(pedeJogada(jogador));
        processaJogada(jogador);

        while(!jogador.getJogada().equals("valida") &&  !jogador.getJogada().equals("desistir")){
            if(!(jogador.getJogada().equals("pontos") && !jogador.getJogada().equals("empate"))){
                impressora.imprimiJogadaInvalida();
            }                   
            if(jogador.getJogada().equals("empate")){
                impressora.imprimiPedidoEmpate();
                Scanner scanner = new Scanner(System.in);
                String escolha = scanner.nextLine();
                if(escolha.equals("S")){
                    impressora.imprimiEmpate();
                    break;
                }
            }
            jogador.setJogada(pedeJogada(jogador));
            processaJogada(jogador);
        }
        jogador.setVitoria(controle.isXequeMate(jogador.getJogada().charAt(4)));
    }
    
    public String pedeJogada(Jogador jogador){
        impressora.imprimiPedidoMovimento(jogador);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public Jogador cadastraJogador(Cor cor) {	
        impressora.imprimiPedidoNomeJogador(cor);
        Jogador jogador = new Jogador();
        Scanner scanner = new Scanner(System.in);
        String nome = scanner.nextLine();
        jogador.setNome(nome);
        jogador.setCor(cor);
        return jogador;

    }    
    
    public void processaJogada(Jogador jogador){
        if(isDesistencia(jogador.getJogada())){                
        }else{
            if(isEmpate(jogador.getJogada())){                
            }else{
                if(isPontuacao(jogador.getJogada())){
                    impressora.imprimir("" +jogador.getPontos());
                }else{
                    if(isPromocao(jogador.getJogada())){
                        
                    }else{
                        if(isRoqueMaior(jogador.getJogada())){
                            
                        }else{
                            if(isRoqueMenor(jogador.getJogada())){
                                
                            }else{
                                controle.fazJogada(jogador);
                                
                            }
                        }
                    }
                }
            }
        }       
    }
    
    //Condição para roque menor
    public boolean isRoqueMenor(String jogada){
        return jogada.equals("O-O");
    }
    
    //Condição para roque maior
    public boolean isRoqueMaior(String jogada){
        return jogada.equals("O-O-O");
    }
    
    //Condição para empate
    public boolean isEmpate(String jogada){
        return jogada.equals("empate");
    }
    
    //Condição para desistencia
    public boolean isDesistencia(String jogada){
        return jogada.equals("desistir");
    }
    
    //Condição para promover um peão
    public boolean isPromocao(String jogada){
        return jogada.charAt(2)=='=';
    }
    
    //Condição para mostrar a pontuação
    public boolean isPontuacao(String jogada){
        return jogada.equals("pontos");
    }
    
    
}




    

    


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.TipoPeca;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;

/**
 *
 * @author Lincoln
 */
public class Controle {
    
    public void processaJogada(Jogador jogador){
        if(isDesistencia(jogador.getJogada())){
            
        }else{
            if(isEmpate(jogador.getJogada())){
                
            }else{
                if(isPontuacao(jogador.getJogada())){
                    
                }else{
                    if(isPromocao(jogador.getJogada())){
                        
                    }else{
                        if(isRoqueMaior(jogador.getJogada())){
                            
                        }else{
                            if(isRoqueMenor(jogador.getJogada())){
                                
                            }else{
                                fazJogada(jogador);
                                
                            }
                        }
                    }
                }
            }
        }
        
        
        
    }
    
    
    public void fazJogada(Jogador jogador){
        processaPeca(jogador);
        
        
    }
    
    public void processaPeca(Jogador jogador){        
       
        //Pego a posicao atual da peca, pego a peça, pego o tipo da peça e instancio a posicao desejada
        Posicao posicaoAtual = Tabuleiro.getInstance().getPosicao(""+jogador.getJogada().charAt(0)+jogador.getJogada().charAt(1));
        Peca peca = posicaoAtual.getPeca();
        TipoPeca tipo = peca.getTipo();
        Posicao novaPosicao = new Posicao();
        
        //Se vai acontecer tentiva de captura na jogada
        boolean captura = isCaptura(jogador.getJogada().charAt(2));
        
        //Posicao desejada pelo o usuario
        if(jogador.getJogada().charAt(2)=='x'){
            novaPosicao.setId(""+jogador.getJogada().charAt(3)+jogador.getJogada().charAt(4));
        }else{
            novaPosicao.setId(""+jogador.getJogada().charAt(2)+jogador.getJogada().charAt(3));
        }
        
        //Se a peça selecionada é do tipo Peão
        if(tipo == TipoPeca.PEAO){
              
            //Se a peça vai fazer um movimento, o movimento tem que ser valido e a posição desejada estar vazia
            if(peca.validarMovimento(novaPosicao) && posicaoFrenteVazia(novaPosicao, Tabuleiro.getInstance())){
                System.out.println("Andou");
                
                //Seta a nova posição na peca, e altera as posições no tabuleiro
                peca.setPosicao(novaPosicao);
                Tabuleiro.getInstance().getPosicao(posicaoAtual.getId()).setPeca(null);                
                Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).setPeca(peca);
            }else{
                
                //Se a peça vai capturar, a posiçao de captura tem que ser valida,captura ser valido e a cor da peça na posição desejada ser da outra cor
                if(peca.validarMovimentoCaptura(novaPosicao) && captura==true 
                        && Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getCor()!=peca.getCor()){
                    System.out.println("Capturou");
                    
                    //Seta a nova posição na peca, e altera as posições no tabuleiro
                    peca.setPosicao(novaPosicao);
                    Tabuleiro.getInstance().getPosicao(posicaoAtual.getId()).setPeca(null);
                    Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).setPeca(peca);                    
                }
            }
            
        }else{
            
            //Se a peça selecionada é do tipo Torre
            if(tipo == TipoPeca.TORRE){
                
            }else{
                
                //Se a peça selecionada é do tipo Bispo
                if(tipo == TipoPeca.BISPO){
                    
                }else{
                    
                    //Se a peça selecionada é do tipo Cavalo
                    if(tipo == TipoPeca.CAVALO){
                        
                    }else{
                        
                        //Se a peça selecionada é do tipo Rainha
                        if(tipo == TipoPeca.RAINHA){
                            
                        }else{
                            
                            //A peça selecionada é do tipo Rei
                            
                        }
                    }
                }
            }
        }
    }
    
    public boolean posicaoFrenteVazia(Posicao novaPosicao, Tabuleiro tabuleiro){
        return !tabuleiro.getPosicao(novaPosicao.getId()).existePeca();
        
    }
    
    public boolean isCaptura(char jogada){
        return jogada=='x';
    }
    
    public boolean isXeque(char jogada){
        return jogada=='+';
    }
    
    public boolean isXequeMate(char jogada){
        return jogada=='#';
    }
    
    
    public boolean isRoqueMenor(String jogada){
        return jogada.equals("O-O");
    }
    
    public boolean isRoqueMaior(String jogada){
        return jogada.equals("O-O-O");
    }
    
    public boolean isEmpate(String jogada){
        return jogada.equals("empate");
    }
    
    public boolean isDesistencia(String jogada){
        return jogada.equals("desistir");
    }
    
    public boolean isPromocao(String jogada){
        return jogada.charAt(2)=='=';
    }
    
    public boolean isPontuacao(String jogada){
        return jogada.equals("pontos");
    }
    
}

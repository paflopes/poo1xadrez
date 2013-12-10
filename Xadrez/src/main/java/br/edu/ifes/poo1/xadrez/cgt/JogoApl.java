/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;

/**
 *
 * @author Lincoln
 */
public class JogoApl {
    
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
        NomePeca tipo = peca.getNome();
        Posicao novaPosicao;
        
        //Se vai acontecer tentiva de captura na jogada
        boolean captura = isCaptura(jogador.getJogada().charAt(2));
        
        //Posicao desejada pelo o usuario
        if(jogador.getJogada().charAt(2)=='x'){
            novaPosicao = Tabuleiro.getInstance().getPosicao(""+jogador.getJogada().charAt(3)+jogador.getJogada().charAt(4));
        }else{
            novaPosicao = Tabuleiro.getInstance().getPosicao(""+jogador.getJogada().charAt(2)+jogador.getJogada().charAt(3));
        }
        
        //Se a peça selecionada é do tipo Peão
        if(tipo == NomePeca.PEAO){
              
            //Se a peça vai fazer um movimento, o movimento tem que ser valido e a posição desejada estar vazia
            if(peca.validarMovimento(novaPosicao) && posicaoFrenteVazia(novaPosicao, Tabuleiro.getInstance())){
                
                //Seta a nova posição na peca, e altera as posições no tabuleiro
                //peca.setPosicao(novaPosicao);
                //Tabuleiro.getInstance().getPosicao(posicaoAtual.getId()).setPeca(null);                
                Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).setPeca(peca);
            }else{
                
                //Se a peça vai capturar, a posiçao de captura tem que ser valida,captura ser valido e a cor da peça na posição desejada ser da outra cor
                if(peca.validarMovimentoCaptura(novaPosicao) && captura==true 
                        && Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getCor()!=peca.getCor()){
                    
                    //Seta a nova posição na peca, e altera as posições no tabuleiro
                    //peca.setPosicao(novaPosicao);
                    //Tabuleiro.getInstance().getPosicao(posicaoAtual.getId()).setPeca(null);
                    Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).setPeca(peca);                    
                }
            }
            
        }else{
            
            //Se a peça selecionada é do tipo Torre
            if(tipo == NomePeca.TORRE){
                
                if(peca.validarMovimento(novaPosicao)&& caminhoRetoVazio(posicaoAtual, novaPosicao, Tabuleiro.getInstance())){
                    
                    //Seta a nova posição na peca, e altera as posições no tabuleiro
                    peca.setPosicao(novaPosicao);
                    Tabuleiro.getInstance().getPosicao(posicaoAtual.getId()).setPeca(null);                
                    Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).setPeca(peca);
                    
                }else{
                    
                    if(peca.validarMovimento(novaPosicao) && caminhoRetoCaptura(posicaoAtual, novaPosicao, Tabuleiro.getInstance()) &&
                            captura==true){
                        
                        //Seta a nova posição na peca, e altera as posições no tabuleiro
                        peca.setPosicao(novaPosicao);
                        Tabuleiro.getInstance().getPosicao(posicaoAtual.getId()).setPeca(null);                
                        Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).setPeca(peca);
                    }
                }
                
                
            }else{
                
                //Se a peça selecionada é do tipo Bispo
                if(tipo == NomePeca.BISPO){
                    
                    if(peca.validarMovimento(novaPosicao) && caminhoDiagonalVazio(posicaoAtual, novaPosicao, Tabuleiro.getInstance()) ){
                        
                        peca.setPosicao(novaPosicao);
                        Tabuleiro.getInstance().getPosicao(posicaoAtual.getId()).setPeca(null);                
                        Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).setPeca(peca);
                    }else{
                        
                    }
                        
                        
                    
                    
                    
                }else{
                    
                    //Se a peça selecionada é do tipo Cavalo
                    if(tipo == NomePeca.CAVALO){
                        
                    }else{
                        
                        //Se a peça selecionada é do tipo Rainha
                        if(tipo == NomePeca.RAINHA){
                            
                        }else{
                            
                            //A peça selecionada é do tipo Rei
                            
                        }
                    }
                }
            }
        }
    }
    
    public boolean caminhoDiagonalVazio(Posicao posicaoAtual, Posicao novaPosicao, Tabuleiro tabuleiro){
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        
        
        //Verifica a direção Nordeste
        if(linhaAtual <= linhaNova && colunaAtual <= colunaNova){
            while(linhaAtual <= linhaNova && colunaAtual <= colunaNova){
                if(tabuleiro.getPosicao(""+(linhaAtual+1) + (linhaNova+1)).existePeca()){
                    return false;
                }
                linhaAtual++;
                colunaAtual++;
            }              
        }else{
            
            //Verifica a direção Noroeste
            if(linhaAtual >= linhaNova && colunaAtual <= colunaNova){
                while(linhaAtual >= linhaNova && colunaAtual <= colunaNova){
                    if(tabuleiro.getPosicao(""+(linhaAtual+1) + (linhaNova+1)).existePeca()){
                        return false;
                    }
                    linhaAtual++;
                    colunaAtual--;
                }
            }else{
                
                //Verifica a direção Sudoeste
                if(linhaAtual >= linhaNova && colunaAtual >= colunaNova){
                    while(linhaAtual <= linhaNova && colunaAtual <= colunaNova){
                    if(tabuleiro.getPosicao(""+(linhaAtual+1) + (linhaNova+1)).existePeca()){
                        return false;
                    }
                    linhaAtual--;
                    colunaAtual--;
                    }
                }else{
                    
                    //Verifica a direção Sudeste
                    while(linhaAtual <= linhaNova && colunaAtual >= colunaNova){
                        if(tabuleiro.getPosicao(""+(linhaAtual+1) + (linhaNova+1)).existePeca()){
                            return false;
                        }
                        linhaAtual--;
                        colunaAtual++;
                    }
                }
            }
        }
        return true;
    }
    
    
    public boolean caminhoRetoCaptura(Posicao posicaoAtual, Posicao novaPosicao, Tabuleiro tabuleiro){
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        
        if(colunaAtual == colunaNova || linhaAtual != linhaNova){
            for(linhaAtual = (char)(posicaoAtual.getId().charAt(1) +1); linhaAtual<linhaNova; linhaAtual++){
                if(Tabuleiro.getInstance().getPosicao("" +colunaAtual +linhaAtual).existePeca()){
                   return false; 
                }
            }
        }else{
            for(colunaAtual = (char)(posicaoAtual.getId().charAt(0) +1); colunaAtual<colunaNova; colunaAtual++){
                if(Tabuleiro.getInstance().getPosicao("" +colunaAtual +linhaAtual).existePeca()){
                   return false; 
                }
            }
        }
        return true;
        
    }
    
    
    public boolean caminhoRetoVazio(Posicao posicaoAtual, Posicao novaPosicao, Tabuleiro tabuleiro){
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        
        if(colunaAtual == colunaNova || linhaAtual != linhaNova){
            for(linhaAtual = (char)(posicaoAtual.getId().charAt(1) +1); linhaAtual<=linhaNova; linhaAtual++){
                if(Tabuleiro.getInstance().getPosicao("" +colunaAtual +linhaAtual).existePeca()){
                   return false; 
                }
            }
        }else{
            for(colunaAtual = (char)(posicaoAtual.getId().charAt(0) +1); colunaAtual<=colunaNova; colunaAtual++){
                if(Tabuleiro.getInstance().getPosicao("" +colunaAtual +linhaAtual).existePeca()){
                   return false; 
                }
            }
        }
        return true;
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

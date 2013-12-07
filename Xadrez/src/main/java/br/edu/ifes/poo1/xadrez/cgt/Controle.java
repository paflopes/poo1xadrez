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
        
    public void fazJogada(Jogador jogador){
        processaJogadaPeca(jogador);
        
        
    }
    
    public void processaJogadaPeca(Jogador jogador){        
                
        
        //Pego a posicao atual da peca, pego a peça, pego o tipo da peça e instancio a posicao desejada
        Posicao posicaoAtual = Tabuleiro.getInstance().getPosicao(""+jogador.getJogada().charAt(0)+jogador.getJogada().charAt(1));                
        Peca peca = posicaoAtual.getPeca();    
        
        if(peca != null && peca.getCor() == jogador.getCor()){
        
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
                if(peca.validarMovimento(novaPosicao) && posicaoDesejadaVazia(novaPosicao)){

                    atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                    atualizaJogadorJogada(jogador);

                }else{

                    //Se a peça vai capturar, a posiçao de captura tem que ser valida,captura ser valido e a cor da peça na posição desejada ser da outra cor
                    if(peca.validarMovimentoCaptura(novaPosicao) && captura==true 
                            && Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getCor()!=peca.getCor()){

                        atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                        atualizaJogadorJogada(jogador);
                        atualizaPontosJogador(jogador, novaPosicao);
                        
                    }
                }

            }else{

                //Se a peça selecionada é do tipo Torre
                if(tipo == TipoPeca.TORRE){
                    
                    //Se a torre vai fazer um movimento
                    if(peca.validarMovimento(novaPosicao)&& caminhoRetoVazio(posicaoAtual, novaPosicao)){

                        atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                        atualizaJogadorJogada(jogador);

                    }else{
                        
                        //Se a torre vai fazer uma captura
                        if(peca.validarMovimento(novaPosicao) && caminhoRetoCaptura(posicaoAtual, novaPosicao) && captura==true &&
                                Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getCor() != peca.getCor()){

                            atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                            atualizaJogadorJogada(jogador);
                            atualizaPontosJogador(jogador, novaPosicao);

                        }
                    }


                }else{

                    //Se a peça selecionada é do tipo Bispo
                    if(tipo == TipoPeca.BISPO){
                        
                        //Se o bispo vai fazer um movimento
                        if(peca.validarMovimento(novaPosicao) && caminhoDiagonalVazio(posicaoAtual, novaPosicao) ){

                            atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                            atualizaJogadorJogada(jogador);

                        }else{
                            
                            //Se o bispo vai fazer uma captura
                            if(peca.validarMovimento(novaPosicao) && caminhoDiagonalCaptura(posicaoAtual, novaPosicao) && captura == true
                                    && Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getCor() != peca.getCor()){

                                atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                                atualizaJogadorJogada(jogador);
                                atualizaPontosJogador(jogador, novaPosicao);

                            }
                        }  

                    }else{

                        //Se a peça selecionada é do tipo Cavalo
                        if(tipo == TipoPeca.CAVALO){
                            
                            //Se o cavalo vai fazer um movimento
                            if(peca.validarMovimento(novaPosicao) && posicaoDesejadaVazia(novaPosicao)){

                                atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                                atualizaJogadorJogada(jogador);

                            }else{
                                
                                //Se o cavalo vai fazer uma captura
                                if(peca.validarMovimento(novaPosicao) && captura == true &&
                                        Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getCor() != peca.getCor()){

                                    atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                                    atualizaJogadorJogada(jogador);
                                    atualizaPontosJogador(jogador, novaPosicao);

                                }
                            }                       

                        }else{

                            //Se a peça selecionada é do tipo Rainha
                            if(tipo == TipoPeca.RAINHA){

                                //Se a rainha vai fazer um movimento 
                                if(peca.validarMovimento(novaPosicao) && (caminhoRetoVazio(posicaoAtual, novaPosicao) ||
                                        caminhoDiagonalVazio(posicaoAtual, novaPosicao))){

                                    atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                                    atualizaJogadorJogada(jogador);

                                }else{
                                    
                                    //Se a rainha vai fazer uma captura
                                    if(peca.validarMovimento(novaPosicao) && (caminhoRetoCaptura(posicaoAtual, novaPosicao) ||
                                        caminhoDiagonalCaptura(posicaoAtual, novaPosicao)) && captura==true && 
                                            Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getCor() != peca.getCor()){

                                        atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                                        atualizaJogadorJogada(jogador);
                                        atualizaPontosJogador(jogador, novaPosicao);

                                    }
                                }

                            }else{

                                //A peça selecionada é do tipo Rei
                                //Se o rei vai fazer um movimento
                                if(peca.validarMovimento(novaPosicao) && posicaoDesejadaVazia(novaPosicao)){
                                    
                                    atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                                    atualizaJogadorJogada(jogador);

                                }else{
                                    
                                    //Se o rei vai fazer uma captura
                                    if(peca.validarMovimento(novaPosicao) && captura == true &&
                                        Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getCor() != peca.getCor()){

                                        atualizaTabuleiro(peca, posicaoAtual, novaPosicao);
                                        atualizaJogadorJogada(jogador);
                                        atualizaPontosJogador(jogador, novaPosicao);

                                    }
                                }                           
                            }
                        }
                    }
                }
            }
        }
    }
    
    //Verifica se a diagonal está vazia ate uma posiçao diagonal antes da peca a ser capturada.
    public boolean caminhoDiagonalCaptura(Posicao posicaoAtual, Posicao novaPosicao){
        
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        
        if(posicaoAtual.getId().equals(novaPosicao.getId())){
            return false;
        }
        
        //Nordeste
        if(linhaNova > linhaAtual && colunaNova > colunaAtual){
            linhaAtual++;
            colunaAtual++;
            while((linhaAtual) < linhaNova && (colunaAtual) < colunaNova){
                if(Tabuleiro.getInstance().getPosicao("" +(colunaAtual) +(linhaAtual)).existePeca()){
                    return false;
                }
                linhaAtual++;
                colunaAtual++;
            }            
        }
        
        //Noroeste
        if(linhaNova > linhaAtual && colunaAtual > colunaNova){
            linhaAtual++;
            colunaAtual--;
            while((linhaAtual) < linhaNova && (colunaAtual) > colunaNova){
                if(Tabuleiro.getInstance().getPosicao("" +(colunaAtual) +(linhaAtual)).existePeca()){
                    return false;
                }
                linhaAtual++;
                colunaAtual--;
            }
        }
        
        //Sudoeste
        if(linhaAtual > linhaNova && colunaAtual > colunaNova){
            linhaAtual--;
            colunaAtual--;
            while((linhaAtual) > linhaNova && (colunaAtual) > colunaNova){
                if(Tabuleiro.getInstance().getPosicao("" +(colunaAtual) +(linhaAtual)).existePeca()){
                    return false;
                }
                linhaAtual--;
                colunaAtual--;
            }
        }
        
        //Sudeste
        if(linhaAtual > linhaNova && colunaNova > colunaAtual){
            linhaAtual--;
            colunaAtual++;
            while((linhaAtual) > linhaNova && (colunaAtual) < colunaNova){
                if(Tabuleiro.getInstance().getPosicao("" +(colunaAtual) +(linhaAtual)).existePeca()){
                    return false;
                }
                linhaAtual--;
                colunaAtual++;
            }
        }        
        
        return true;
    }
    
    //Verifica se a diagonal está vazia para se fazer o movimento
    public boolean caminhoDiagonalVazio(Posicao posicaoAtual, Posicao novaPosicao){
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        
        if(posicaoAtual.getId().equals(novaPosicao.getId())){
            return false;
        }
        
        //Nordeste
        if(linhaNova > linhaAtual && colunaNova > colunaAtual){
            linhaAtual++;
            colunaAtual++;
            while((linhaAtual) <= linhaNova && (colunaAtual) <= colunaNova){
                if(Tabuleiro.getInstance().getPosicao("" +(colunaAtual) +(linhaAtual)).existePeca()){
                    return false;
                }
                linhaAtual++;
                colunaAtual++;
            }
            
            
        }
        
        //Noroeste
        if(linhaNova > linhaAtual && colunaAtual > colunaNova){
            linhaAtual++;
            colunaAtual--;
            while((linhaAtual) <= linhaNova && (colunaAtual) >= colunaNova){
                if(Tabuleiro.getInstance().getPosicao("" +(colunaAtual) +(linhaAtual)).existePeca()){
                    return false;
                }
                linhaAtual++;
                colunaAtual--;
            }
        }
        
        //Sudoeste
        if(linhaAtual > linhaNova && colunaAtual > colunaNova){
            linhaAtual--;
            colunaAtual--;
            while((linhaAtual) >= linhaNova && (colunaAtual) >= colunaNova){
                if(Tabuleiro.getInstance().getPosicao("" +(colunaAtual) +(linhaAtual)).existePeca()){
                    return false;
                }
                linhaAtual--;
                colunaAtual--;
            }
        }
        
        //Sudeste
        if(linhaAtual > linhaNova && colunaNova > colunaAtual){
            linhaAtual--;
            colunaAtual++;
            while((linhaAtual) >= linhaNova && (colunaAtual) <= colunaNova){
                if(Tabuleiro.getInstance().getPosicao("" +(colunaAtual) +(linhaAtual)).existePeca()){
                    return false;
                }
                linhaAtual--;
                colunaAtual++;
            }
        }        
        
        return true;
    }
    
    //Semelhante ao caminhoRetoVazio, pórem vai ate uma casa a menos, pois a ultima é capturada
    public boolean caminhoRetoCaptura(Posicao posicaoAtual, Posicao novaPosicao){
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        
        if(posicaoAtual.getId().equals(novaPosicao.getId())){
            return false;
        }     
        
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
    
    //Atualiza os pontos do jogador de acordo com o tipo da peça capturada
    public void atualizaPontosJogador(Jogador jogador,Posicao novaPosicao){
        if(Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getTipo() == TipoPeca.PEAO){
            jogador.setPontos(jogador.getPontos()+1);
        }else{
            if(Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getTipo() == TipoPeca.TORRE){
                jogador.setPontos(jogador.getPontos()+5);
            }else{
                if(Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getTipo() == TipoPeca.CAVALO){
                    jogador.setPontos(jogador.getPontos()+3);
                }else{
                    if(Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).getPeca().getTipo() == TipoPeca.BISPO){
                        jogador.setPontos(jogador.getPontos()+3);
                    }else{
                        jogador.setPontos(jogador.getPontos()+9);                        
                    }
                }
            }
        }
    }
    
    //Atualiza a jogada, para sinalizar se foi valida ou nao
    public void atualizaJogadorJogada(Jogador jogador){
        jogador.setJogada("valida");        
    }
    
    //Atualiza o tabuleiro após uma movimentação ou captura
    public void atualizaTabuleiro(Peca peca, Posicao posicaoAtual, Posicao novaPosicao){
        
        peca.setPosicao(novaPosicao);
        Tabuleiro.getInstance().getPosicao(posicaoAtual.getId()).setPeca(null);                
        Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).setPeca(peca);
    }
    
    //Verifica se todo o caminho em direção reta está vazio
    public boolean caminhoRetoVazio(Posicao posicaoAtual, Posicao novaPosicao){
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        
        //Verifica se é a mesma posição que a peça ja está
        if(posicaoAtual.getId().equals(novaPosicao.getId())){
            return false;
        }
        
        //Percorrendo a coluna
        if(colunaAtual == colunaNova || linhaAtual != linhaNova){
            for(linhaAtual = (char)(posicaoAtual.getId().charAt(1) +1); linhaAtual<=linhaNova; linhaAtual++){
                if(Tabuleiro.getInstance().getPosicao("" +colunaAtual +linhaAtual).existePeca()){
                   return false; 
                }
            }
        }else{
            //Percorrendo a linha
            for(colunaAtual = (char)(posicaoAtual.getId().charAt(0) +1); colunaAtual<=colunaNova; colunaAtual++){
                if(Tabuleiro.getInstance().getPosicao("" +colunaAtual +linhaAtual).existePeca()){
                   return false; 
                }
            }
        }
        return true;
    }
    
    //Posição desejada para movimento vazia
    public boolean posicaoDesejadaVazia(Posicao novaPosicao){
        return !Tabuleiro.getInstance().getPosicao(novaPosicao.getId()).existePeca();
        
    }
    
    //Condição para captura
    public boolean isCaptura(char jogada){
        return jogada=='x';
    }
    
    //Condição para xeque
    public boolean isXeque(char jogada){
        return jogada=='+';
    }
    
    //condição para xeque mate
    public boolean isXequeMate(char jogada){
        return jogada=='#';
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

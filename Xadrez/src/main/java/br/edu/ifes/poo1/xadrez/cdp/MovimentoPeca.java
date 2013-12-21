/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peao;
import java.util.ArrayList;
import java.util.List;

public class MovimentoPeca {

    public static boolean isDiagonal(Posicao posicaoAtual, Posicao novaPosicao) {
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        return Math.abs(colunaAtual - colunaNova) == Math.abs(linhaAtual - linhaNova);
    }

    public static boolean isStraight(Posicao posicaoAtual, Posicao novaPosicao) {
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        return ((colunaAtual - colunaNova) == 0) || ((linhaAtual - linhaNova) == 0);
    }

    public static boolean isEnPassant(Posicao posicaoAtual, Posicao novaPosicao) {
        Peao peaoAtual = (Peao) posicaoAtual.getPeca();
        Posicao posicaoCaptura = null;
        boolean andouDuasCasas = false;
        char novaColuna = novaPosicao.getId().charAt(0);
        char novaLinha = novaPosicao.getId().charAt(1);

        switch (peaoAtual.getCor()) {
            case BRANCO:
                posicaoCaptura = Tabuleiro.getInstance().getPosicao("" + novaColuna + ((char) (novaLinha - 1)));
                andouDuasCasas = posicaoCaptura.getId().charAt(1) == '5';
                break;
            case PRETO:
                posicaoCaptura = Tabuleiro.getInstance().getPosicao("" + novaColuna + ((char) (novaLinha + 1)));
                andouDuasCasas = posicaoCaptura.getId().charAt(1) == '4';
                break;
        }

        return posicaoCaptura.existePeca()
                && posicaoCaptura.getPeca().getNome() == NomePeca.PEAO
                && ((Peao) posicaoCaptura.getPeca()).moveuUmaVez()
                && andouDuasCasas;
    }

    public static boolean isXeque(Posicao posicaoAtual, Posicao posicaoFinal) {
        
        return posicaoAtual.getPeca().validarMovimentoCaptura(posicaoFinal);
    }

    public static boolean isXequeMate(Posicao posicaoAtual, Posicao posicaoFinal) {
        if(tentarInterceptarXMATE(posicaoAtual, posicaoFinal)
            || reiEscaparMovimento(posicaoFinal)){
            
        }
        
        return false;
    }

    /**
     * Verifica se é um RoqueMaior.
     *
     * @param posicaoAtual É a posição inicial do rei.
     * @return {@code true} se é um roque maior ou {@code false} caso contrário.
     */
    public static boolean isRoqueMaior(Posicao posicaoAtual) {
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunhaAtual = posicaoAtual.getId().charAt(0);
        Posicao posicaoTorre = Tabuleiro.getInstance().getPosicao("1" + linhaAtual);
        List<String> caminho = new ArrayList<>();

        for (int nCaminho = 1; nCaminho < 3; nCaminho++) {
            caminho.add("" + ((char) (colunhaAtual - nCaminho)) + linhaAtual);
        }

        return (posicaoAtual.existePeca()
                && !posicaoAtual.getPeca().jaMovimentou()
                && posicaoAtual.getPeca().getNome() == NomePeca.REI)
                && !MovimentoPeca.haPeca(caminho)
                && posicaoTorre.existePeca()
                && !posicaoTorre.getPeca().jaMovimentou();
    }

    /**
     * Verifica se é um roque menor.
     *
     * @param posicaoAtual A posição inicial do Rei.
     * @return {@code true} se é um roque maior ou {@code false} caso contrário.
     */
    public static boolean isRoqueMenor(Posicao posicaoAtual) {
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunhaAtual = posicaoAtual.getId().charAt(0);
        Posicao posicaoTorre = Tabuleiro.getInstance().getPosicao("8" + linhaAtual);
        List<String> caminho = new ArrayList<>();

        for (int nCaminho = 1; nCaminho < 3; nCaminho++) {
            caminho.add("" + ((char) (colunhaAtual + nCaminho)) + linhaAtual);
        }

        return (posicaoAtual.existePeca()
                && !posicaoAtual.getPeca().jaMovimentou()
                && posicaoAtual.getPeca().getNome() == NomePeca.REI)
                && !MovimentoPeca.haPeca(caminho)
                && posicaoTorre.existePeca()
                && !posicaoTorre.getPeca().jaMovimentou();
    }

    /**
     * Verifica se todas as posições no caminho dado estão sem peças.
     *
     * @param caminho O caminho a ser verificado no Tabuleiro.
     * @return {@code true} se não houver peças em nenhuma das posições,
     * {@code false} caso contrário.
     */
    public static boolean haPeca(List<String> caminho) {
        Tabuleiro tab = Tabuleiro.getInstance();

        for (String idPosicao : caminho) {
            if (tab.getPosicao(idPosicao).existePeca() == true) {
                return true;
            }
        }

        return false;
    }

    /**
     * Verifica se a reta está vazia ate uma posiçao antes da peca a ser
     * capturada
     *
     * @param posicaoAtual A posição atual.
     * @param novaPosicao A nova posição da peça.
     * @return Uma lista com todos o caminho reto de uma posição a outra.
     */
    public static List<String> caminhoReto(Posicao posicaoAtual, Posicao novaPosicao) {
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        List<String> caminho = new ArrayList<>();

        //Norte
        if (colunaAtual == colunaNova && linhaAtual < linhaNova) {
            linhaAtual++;
            while (linhaAtual < linhaNova) {
                caminho.add("" + colunaAtual + linhaAtual);
                linhaAtual++;
            }
        } //Leste
        if (colunaAtual < colunaNova && linhaAtual == linhaNova) {
            colunaAtual++;
            while (colunaAtual < colunaNova) {
                caminho.add("" + colunaAtual + linhaAtual);
                colunaAtual++;
            }
        } //Sul
        if (colunaAtual == colunaNova && linhaAtual > linhaNova) {
            linhaAtual--;
            while (linhaAtual > linhaNova) {
                caminho.add("" + colunaAtual + linhaAtual);
                linhaAtual--;
            }
        } //Oeste
        if (colunaAtual > colunaNova && linhaAtual == linhaNova) {
            colunaAtual--;
            while (colunaAtual > colunaNova) {
                caminho.add("" + colunaAtual + linhaAtual);
                colunaAtual--;
            }
        }
        return caminho;
    }

    /**
     * Verifica se a diagonal está vazia ate uma posiçao diagonal antes da peca
     * a ser capturada.
     *
     * @param posicaoAtual A posição atual da peça.
     * @param novaPosicao A nova posição da peça.
     * @return Uma lista com todos o caminho diagonal de uma posição a outra.
     */
    public static List<String> caminhoDiagonal(Posicao posicaoAtual, Posicao novaPosicao) {

        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        List<String> caminho = new ArrayList<>();

        //Nordeste
        if (linhaNova > linhaAtual && colunaNova > colunaAtual) {
            linhaAtual++;
            colunaAtual++;
            while ((linhaAtual) < linhaNova && (colunaAtual) < colunaNova) {
                caminho.add("" + colunaAtual + linhaAtual);
                linhaAtual++;
                colunaAtual++;
            }
        }

        //Noroeste
        if (linhaNova > linhaAtual && colunaAtual > colunaNova) {
            linhaAtual++;
            colunaAtual--;
            while ((linhaAtual) < linhaNova && (colunaAtual) > colunaNova) {
                caminho.add("" + colunaAtual + linhaAtual);
                linhaAtual++;
                colunaAtual--;
            }
        }

        //Sudoeste
        if (linhaAtual > linhaNova && colunaAtual > colunaNova) {
            linhaAtual--;
            colunaAtual--;
            while ((linhaAtual) > linhaNova && (colunaAtual) > colunaNova) {
                caminho.add("" + colunaAtual + linhaAtual);
                linhaAtual--;
                colunaAtual--;
            }
        }

        //Sudeste
        if (linhaAtual > linhaNova && colunaNova > colunaAtual) {
            linhaAtual--;
            colunaAtual++;
            while ((linhaAtual) > linhaNova && (colunaAtual) < colunaNova) {
                caminho.add("" + colunaAtual + linhaAtual);
                linhaAtual--;
                colunaAtual++;
            }
        }

        return caminho;
    }

    public static boolean saltoDuploPeao(Posicao posicaoAtual, Posicao novaPosicao) {
        char colunaAtual = posicaoAtual.getId().charAt(0);
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunaNova = novaPosicao.getId().charAt(0);
        char linhaNova = novaPosicao.getId().charAt(1);

        return Math.abs(linhaAtual - linhaNova) == 2 && linhaAtual == linhaNova;
    }
    
    
    //Função para tentar interceptar o XMATE colocando uma peça no caminho ou capturando a peça que da XMATE
    private static boolean tentarInterceptarXMATE(Posicao posicaoAtual, Posicao posicaoFinal){          
        
        return false;
    }
    
    //Rei escapar de XEQUE MATE andando
    private static boolean reiEscaparMovimento(Posicao posicaoDoRei){
                
        /*
        *Phillipe, a logica funciona, se quiser achar uma forma mais eficiente e achar que esta na classe errada, por favor arrume.
         */

        return tentarMovimentoRei(posicaoDoRei, 0, 1)   || //Movimento para o norte
               tentarMovimentoRei(posicaoDoRei, 1, 1)   || //Movimento para o nordeste
               tentarMovimentoRei(posicaoDoRei, 1, 0)   || //Movimento para o leste
               tentarMovimentoRei(posicaoDoRei, 1, -1)  || //Movimento para o suldeste
               tentarMovimentoRei(posicaoDoRei, 0, -1)  || //Movimento para o sul
               tentarMovimentoRei(posicaoDoRei, -1, -1) || //Movimento para o sudoeste
               tentarMovimentoRei(posicaoDoRei, -1, 0)  || //Movimento para o oeste
               tentarMovimentoRei(posicaoDoRei, -1, +1);   //Movimento para o noroeste

    }
    
    //Verifica se é possivel movimentar o Rei para fugir de um Xeque
    private static boolean tentarMovimentoRei(Posicao posicaoDoRei, int colunaAdd, int linhaAdd){
        
        char colunaAux = posicaoDoRei.getId().charAt(0);
        char linhaAux = posicaoDoRei.getId().charAt(1);
        
        //Se eu não puder movimentar ou capturar a casa ao lado pra sair do xeque eu retorno um false
        if(!(posicaoDoRei.getPeca().validarMovimento(Tabuleiro.getInstance().getPosicao(""+(colunaAux + colunaAdd) +(linhaAux + linhaAdd)))
           || posicaoDoRei.getPeca().validarMovimentoCaptura(Tabuleiro.getInstance().getPosicao(""+(colunaAux + colunaAdd) +(linhaAux + linhaAdd))))){
            return false;
        }else{
            
            //Aloco um peão da cor do rei na posição desejada só para testar se alguma peça consegue capturar ele
            Peao peaoAux = new Peao(posicaoDoRei.getPeca().getCor());
            Tabuleiro.getInstance().getPosicao(""+(colunaAux + colunaAdd) +(linhaAux + linhaAdd)).setPeca(peaoAux);
            boolean noXeque = true;
            
            //Percorre todo o tabuleiro
            for (char coluna = '1'; coluna < '9'; coluna++) {
                for (char linha = '1'; linha < '9'; linha++) {
                    
                    //Se uma peca do tabuleiro estiver dando XEQUE na posicao desejada e essa peca que 
                    //está dando XEQUE tem que ser de cor diferente da do rei.
                    if(Tabuleiro.getInstance().getPosicao("" +coluna +linha).getPeca().validarMovimentoCaptura(Tabuleiro.getInstance().getPosicao(""+(colunaAux + colunaAdd) +(linhaAux + linhaAdd)))
                       && Tabuleiro.getInstance().getPosicao("" +coluna +linha).getPeca().getCor() != posicaoDoRei.getPeca().getCor())  {
                        noXeque = false;
                    }
                }
            }
            //Retiro o peão da posicao que coloquei para testar
            Tabuleiro.getInstance().getPosicao(""+(colunaAux + colunaAdd) +(linhaAux + linhaAdd)).setPeca(null);
            return noXeque;
        }
        
    }
    
}

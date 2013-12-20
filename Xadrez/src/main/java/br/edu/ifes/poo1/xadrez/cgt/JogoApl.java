/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.MovimentoPeca;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.PosicaoImpl;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.jogo.DadoJogo;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lincoln
 */
public class JogoApl {

    private final List<DadoJogo> dadosJogo;

    public JogoApl() {
        this.dadosJogo = new ArrayList<>();
    }

    public void fazerJogada(Jogador jogador) throws JogadaInvalidaException {
        Jogada jogada = jogador.getJogada();
        Posicao posicaoAtual = jogada.getPosicaoInicial();
        Posicao posicaoFinal = jogada.getPosicaoFinal();
        Operacao operacao = jogada.getOperacao();
        Peca peca;

        // Se o jogador não tiver uma posição atual definida, então a posição do Rei é dada.
        if (posicaoAtual == null) {
            if (jogador.getCor() == Cor.BRANCO) {
                posicaoAtual = this.getPosicao("51");
            } else {
                posicaoAtual = this.getPosicao("58");
            }
        }

        peca = posicaoAtual.getPeca();

        if (posicaoAtual.existePeca() && peca.getCor() == jogador.getCor()) {
            switch (operacao) {
                case MOVIMENTO:
                    if (peca.validarMovimento(posicaoFinal)) {
                        posicaoFinal.setPeca(peca);
                    } else {
                        throw new JogadaInvalidaException("Jogada Inválida!");
                    }
                    break;
                case CAPTURA:
                    if (peca.validarMovimentoCaptura(posicaoFinal)) {
                        
                        //Atualiza os pontos pela captura
                        jogador.atualizaPontosJogador(posicaoFinal);
                        posicaoFinal.setPeca(peca);
                        
                        //Caso a captura seja um enPassant.
                    } else if (MovimentoPeca.isEnPassant(posicaoAtual, posicaoFinal)) {
                        char colunaFinal = posicaoFinal.getId().charAt(0);
                        char linhaFinal = 0;
                        switch (posicaoAtual.getPeca().getCor()) {
                            case BRANCO:
                                linhaFinal = (char) (posicaoFinal.getId().charAt(1) - 1);
                                break;
                            case PRETO:
                                linhaFinal = (char) (posicaoFinal.getId().charAt(1) + 1);
                                break;
                        }
                        posicaoFinal.setPeca(peca);
                        posicaoFinal = Tabuleiro.getInstance().getPosicao("" + colunaFinal + linhaFinal);
                        jogador.atualizaPontosJogador(posicaoFinal);
                        posicaoFinal.setPeca(null);
                    } else {
                        throw new JogadaInvalidaException("Jogada Inválida!");
                    }
                    break;
                case RMAIOR:
                    if (MovimentoPeca.isRoqueMaior(posicaoAtual)) {
                        char linhaAtual = posicaoAtual.getId().charAt(1);
                        Peca rei = posicaoAtual.getPeca();
                        Peca torre = this.getPosicao("1" + linhaAtual).getPeca();
                        this.getPosicao("3" + linhaAtual).setPeca(rei);
                        this.getPosicao("4" + linhaAtual).setPeca(torre);
                    } else {
                        throw new JogadaInvalidaException("Jogada Inválida!");
                    }
                    break;
                case RMENOR:
                    if (MovimentoPeca.isRoqueMenor(posicaoAtual)) {
                        char linhaAtual = posicaoAtual.getId().charAt(1);
                        Peca rei = posicaoAtual.getPeca();
                        Peca torre = this.getPosicao("8" + linhaAtual).getPeca();
                        this.getPosicao("7" + linhaAtual).setPeca(rei);
                        this.getPosicao("6" + linhaAtual).setPeca(torre);
                    } else {
                        throw new JogadaInvalidaException("Jogada Inválida!");
                    }
                    break;
                case PROMOCAO:
                    
                    break;
                case XEQUE:
                                 
                    if(!peca.validarMovimentoCaptura(posicaoFinal)){
                        throw new JogadaInvalidaException("Jogada inválida!");
                    }                    
                    break;
                case XMATE:
                    
                    
                    
                    
                    break;
            }
        } else {
            throw new JogadaInvalidaException("Jogada inválida!");
        }

    }

    public void salvarDado(DadoJogo dado) {
        this.dadosJogo.add(dado);
    }

    public List<DadoJogo> getDados() {
        return this.dadosJogo;
    }

    public Posicao getPosicao(String idPosicao) {
        return Tabuleiro.getInstance().getPosicao(idPosicao);
    }

    public Tabuleiro getTabuleiro() {
        return Tabuleiro.getInstance();
    }

    public void reiniciarTabuleiro() {
        Tabuleiro.getInstance().restaurarTabuleiro();
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.MovimentoPeca;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;

/**
 *
 * @author Lincoln
 */
public class JogoApl {

    
    public void fazerJogada(Jogador jogador, Partida partida) throws JogadaInvalidaException {
        Jogada jogada = jogador.getJogada(partida);
        Posicao posicaoAtual = jogada.getPosicaoInicial();
        Posicao posicaoFinal = jogada.getPosicaoFinal();
        Operacao operacao = jogada.getOperacao();
        Peca peca;

        // Se o jogador não tiver uma posição atual definida, então a posição do Rei é dada.
        if (posicaoAtual == null) {
            if (jogador.getCor() == Cor.BRANCO) {
                posicaoAtual = this.getPosicao("51", partida);
            } else {
                posicaoAtual = this.getPosicao("58", partida);
            }
        }

        peca = posicaoAtual.getPeca();

        if (posicaoAtual.existePeca() && peca.getCor() == jogador.getCor()) {
            switch (operacao) {
                case MOVIMENTO:
                    if (peca.validarMovimento(posicaoFinal, partida) && !MovimentoPeca.isXeque(posicaoAtual, posicaoFinal, partida)) {
                        posicaoFinal.setPeca(peca);
                    } else {
                        throw new JogadaInvalidaException("Jogada Inválida!");
                    }
                    break;
                case CAPTURA:

                    if (peca.validarMovimentoCaptura(posicaoFinal, partida) && posicaoFinal.getPeca().getNome() != NomePeca.REI) {

                        //Atualiza os pontos pela captura
                        jogador.atualizaPontosJogador(posicaoFinal);
                        jogador.setPecasCapturadas(posicaoFinal.getPeca().getDesenho());
                        posicaoFinal.setPeca(peca);

                        //Caso a captura seja um enPassant.
                    } else if (MovimentoPeca.isEnPassant(posicaoAtual, posicaoFinal, partida)) {
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
                        posicaoFinal = partida.getTabuleiro().getPosicao("" + colunaFinal + linhaFinal);
                        jogador.atualizaPontosJogador(posicaoFinal);
                        jogador.setPecasCapturadas(posicaoFinal.getPeca().getDesenho());
                        posicaoFinal.setPeca(null);
                    } else {
                        throw new JogadaInvalidaException("Jogada Inválida!");
                    }
                    break;
                case RMAIOR:
                    if (MovimentoPeca.isRoqueMaior(posicaoAtual, partida)) {
                        char linhaAtual = posicaoAtual.getId().charAt(1);
                        Peca rei = posicaoAtual.getPeca();
                        Peca torre = this.getPosicao("1" + linhaAtual, partida).getPeca();
                        this.getPosicao("3" + linhaAtual, partida).setPeca(rei);
                        this.getPosicao("4" + linhaAtual, partida).setPeca(torre);
                    } else {
                        throw new JogadaInvalidaException("Jogada Inválida!");
                    }
                    break;
                case RMENOR:
                    if (MovimentoPeca.isRoqueMenor(posicaoAtual, partida)) {
                        char linhaAtual = posicaoAtual.getId().charAt(1);
                        Peca rei = posicaoAtual.getPeca();
                        Peca torre = this.getPosicao("8" + linhaAtual, partida).getPeca();
                        this.getPosicao("7" + linhaAtual, partida).setPeca(rei);
                        this.getPosicao("6" + linhaAtual, partida).setPeca(torre);
                    } else {
                        throw new JogadaInvalidaException("Jogada Inválida!");
                    }
                    break;
                case PROMOCAO:
                    boolean pecaPreta = peca.getCor() == Cor.PRETO
                            && peca.getNome() == NomePeca.PEAO && peca.getPosicao().getId().matches("[1-8]1");
                    boolean pecaBranca = peca.getCor() == Cor.BRANCO
                            && peca.getNome() == NomePeca.PEAO && peca.getPosicao().getId().matches("[1-8]8");

                    if (pecaBranca || pecaPreta) {
                        posicaoAtual.setPeca(jogada.getPecaDesejada(jogador.getCor()));
                    } else {
                        throw new JogadaInvalidaException(("Jogada Inválida!"));
                    }

                    break;

                case XEQUE:
                    if (!MovimentoPeca.isXeque(posicaoAtual, posicaoFinal, partida) || MovimentoPeca.isXequeMate(posicaoAtual, posicaoFinal, partida)) {
                        throw new JogadaInvalidaException("Jogada inválida!");
                    }

                    posicaoFinal.setPeca(peca);

                    break;
                case XMATE:
                    if (MovimentoPeca.isXequeMate(posicaoAtual, posicaoFinal, partida)) {
                        jogador.setVitoria(true);
                    } else  {
                        throw new JogadaInvalidaException("Jogada inválida!");
                    }

                    break;
            }
        } else {
            throw new JogadaInvalidaException("Jogada inválida!");
        }

    }

    public Posicao getPosicao(String idPosicao, Partida partida) {
        return partida.getTabuleiro().getPosicao(idPosicao);
    }
}

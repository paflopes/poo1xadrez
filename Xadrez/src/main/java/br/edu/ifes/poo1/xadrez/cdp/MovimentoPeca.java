/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
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

    public static boolean isEnPassant(Posicao posicaoAtual, Posicao novaPosicao, Partida partida) {
        Peao peaoAtual;
        Posicao posicaoCaptura = null;
        boolean andouDuasCasas = false;
        char novaColuna = novaPosicao.getId().charAt(0);
        char novaLinha = novaPosicao.getId().charAt(1);

        // Verificamos se a peça que está tentando capturar é um Peão
        // e se está andando apenas uma coluna.
        if (posicaoAtual.getPeca().getNome() != NomePeca.PEAO
                || Math.abs(novaColuna - posicaoAtual.getId().charAt(0)) == 1) {
            return false;
        }

        peaoAtual = (Peao) posicaoAtual.getPeca();

        switch (peaoAtual.getCor()) {
            case BRANCO:
                posicaoCaptura = partida.getTabuleiro().getPosicao("" + novaColuna + ((char) (novaLinha - 1)));
                andouDuasCasas = posicaoCaptura != null && posicaoCaptura.getId().charAt(1) == '5';
                break;
            case PRETO:
                posicaoCaptura = partida.getTabuleiro().getPosicao("" + novaColuna + ((char) (novaLinha + 1)));
                andouDuasCasas = posicaoCaptura != null && posicaoCaptura.getId().charAt(1) == '4';
                break;
        }

        return andouDuasCasas
                && !novaPosicao.existePeca()
                && posicaoCaptura.existePeca()
                && posicaoCaptura.getPeca().getNome() == NomePeca.PEAO
                && ((Peao) posicaoCaptura.getPeca()).moveuUmaVez();
    }

    /**
     * Verifica se o rei ficará em xeque com essa movimentação.
     *
     * @param posicaoAtual Posicao atual da peça.
     * @param posicaoFinal Movimento que deixará o rei em xeque.
     * @return {@code true} se for xeque ou {@code false} caso contrário.
     */
    public static boolean isXeque(Posicao posicaoAtual, Posicao posicaoFinal, Partida partida) {
        Cor corAtual = posicaoAtual.getPeca().getCor();
        // Cor do adversário. Serve para achar a posição do rei adversário.
        Cor corAdversaria;
        // Serve para vermos se a peça colocará o rei em perigo caso se movimente.
        Peca copiaPecaAtual;
        boolean reiEmPerigo;

        try {
            copiaPecaAtual = (Peca) posicaoAtual.getPeca().clone();
        } catch (CloneNotSupportedException ex) {
            return false;
        }

        if (posicaoFinal.existePeca()) {
            return false;
        }

        if (corAtual == Cor.BRANCO) {
            corAdversaria = Cor.PRETO;
        } else {
            corAdversaria = Cor.BRANCO;
        }

        // Aqui verifico se o rei está em perigo.
        Posicao posicaoRei = partida.getTabuleiro().getPosicaoRei(corAdversaria);
        posicaoFinal.setPeca(copiaPecaAtual);
        reiEmPerigo = copiaPecaAtual.validarMovimentoCaptura(posicaoRei, partida);
        posicaoFinal.setPeca(null);

        // Se o movimento for válido e o rei estiver em perigo na nova posição, então é um Xeque.
        return posicaoAtual.getPeca().validarMovimento(posicaoFinal, partida)
                && reiEmPerigo;
    }

    public static boolean isXequeMate(Posicao posicaoAtual, Posicao posicaoFinal, Partida partida) {
        Cor corAdversario;
        Posicao posicaoRei;
        List<Posicao> posicoesEscape;
        List<Peca> pecas;
        boolean isXequeMate = true;

        if (!isXeque(posicaoAtual, posicaoFinal, partida)) {
            return false;
        }

        if (posicaoAtual.getPeca().getCor() == Cor.BRANCO) {
            corAdversario = Cor.PRETO;
        } else {
            corAdversario = Cor.BRANCO;
        }

        posicaoRei = partida.getTabuleiro().getPosicaoRei(corAdversario);
        posicoesEscape = posicoesEscapeRei(posicaoRei, partida);
        pecas = partida.getTabuleiro().getPecas(posicaoAtual.getPeca().getCor());

        for (Posicao posicaoEscape : posicoesEscape) {
            boolean posicaoAmeacada = false;
            for (Peca peca : pecas) {
                if (peca.validarMovimento(posicaoEscape, partida) || peca.validarMovimentoCaptura(posicaoEscape, partida)) {
                    posicaoAmeacada = posicaoAmeacada || true;
                }
            }
            isXequeMate = isXequeMate && posicaoAmeacada;
        }

        return isXequeMate;
    }

    /**
     * Acha todas as posições que um rei pode escapar, pelo movimento ou pela
     * captura de alguma outra peça.
     *
     * @param posicaoRei A posição que o rei se encontra.
     * @return Uma lista com as possíveis posições.
     */
    private static List<Posicao> posicoesEscapeRei(Posicao posicaoRei, Partida partida) {
        List<Posicao> posicoesRei = new ArrayList<>();
        Peca rei = posicaoRei.getPeca();
        List<String> idPosicoesPossiveis = new ArrayList<>();
        char colunaAtual = posicaoRei.getId().charAt(0);
        char linhaAtual = posicaoRei.getId().charAt(1);

        //Norte
        idPosicoesPossiveis.add("" + colunaAtual + ((char) (linhaAtual + 1)));
        //Sul
        idPosicoesPossiveis.add("" + colunaAtual + ((char) (linhaAtual - 1)));
        //Leste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual + 1)) + linhaAtual);
        //Oeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual - 1)) + linhaAtual);
        //Noroeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual - 1)) + ((char) (linhaAtual + 1)));
        //Nordeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual + 1)) + ((char) (linhaAtual + 1)));
        //Sudoeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual - 1)) + ((char) (linhaAtual - 1)));
        //Sudeste
        idPosicoesPossiveis.add("" + ((char) (colunaAtual - 1)) + ((char) (linhaAtual - 1)));

        for (String idPosicao : idPosicoesPossiveis) {
            Posicao posicaoPossivel = partida.getTabuleiro().getPosicao(idPosicao);
            if (posicaoPossivel != null
                    && (rei.validarMovimento(posicaoPossivel, partida) || rei.validarMovimentoCaptura(posicaoPossivel, partida))) {
                posicoesRei.add(posicaoPossivel);
            }
        }

        return posicoesRei;
    }

    /**
     * Verifica se é um RoqueMaior.
     *
     * @param posicaoAtual É a posição inicial do rei.
     * @return {@code true} se é um roque maior ou {@code false} caso contrário.
     */
    public static boolean isRoqueMaior(Posicao posicaoAtual, Partida partida) {
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunhaAtual = posicaoAtual.getId().charAt(0);
        Posicao posicaoTorre = partida.getTabuleiro().getPosicao("1" + linhaAtual);
        List<String> caminho = new ArrayList<>();

        for (int nCaminho = 1; nCaminho < 3; nCaminho++) {
            caminho.add("" + ((char) (colunhaAtual - nCaminho)) + linhaAtual);
        }

        return (posicaoAtual.existePeca()
                && !posicaoAtual.getPeca().jaMovimentou()
                && posicaoAtual.getPeca().getNome() == NomePeca.REI)
                && !MovimentoPeca.haPeca(caminho, partida)
                && posicaoTorre.existePeca()
                && !posicaoTorre.getPeca().jaMovimentou();
    }

    /**
     * Verifica se é um roque menor.
     *
     * @param posicaoAtual A posição inicial do Rei.
     * @return {@code true} se é um roque maior ou {@code false} caso contrário.
     */
    public static boolean isRoqueMenor(Posicao posicaoAtual, Partida partida) {
        char linhaAtual = posicaoAtual.getId().charAt(1);
        char colunhaAtual = posicaoAtual.getId().charAt(0);
        Posicao posicaoTorre = partida.getTabuleiro().getPosicao("8" + linhaAtual);
        List<String> caminho = new ArrayList<>();

        for (int nCaminho = 1; nCaminho < 3; nCaminho++) {
            caminho.add("" + ((char) (colunhaAtual + nCaminho)) + linhaAtual);
        }

        return (posicaoAtual.existePeca()
                && !posicaoAtual.getPeca().jaMovimentou()
                && posicaoAtual.getPeca().getNome() == NomePeca.REI)
                && !MovimentoPeca.haPeca(caminho, partida)
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
    public static boolean haPeca(List<String> caminho, Partida partida) {
        Tabuleiro tab = partida.getTabuleiro();

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

}

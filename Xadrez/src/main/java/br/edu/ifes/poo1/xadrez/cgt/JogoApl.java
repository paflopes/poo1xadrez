/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cgt;

import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;

/**
 *
 * @author Lincoln
 */
public class JogoApl {

    public void fazerJogada(Jogada jogada) throws JogadaInvalidaException {
        Posicao posicaoAtual = jogada.getPosicaoInicial();
        Posicao posicaoFinal = jogada.getPosicaoFinal();
        Peca peca = posicaoAtual.getPeca();
        boolean isCaptura = jogada.getOperacao() == Operacao.CAPTURA;

        if (!isCaptura && peca.validarMovimento(posicaoFinal)) {
            posicaoFinal.setPeca(peca);
        } else if (isCaptura && peca.validarMovimentoCaptura(posicaoFinal)) {
            posicaoFinal.setPeca(peca);
        } else {
            throw new JogadaInvalidaException("Jogada inválida!");
        }
    }

    public boolean isCaptura(char jogada) {
        return jogada == 'x';
    }

    public boolean isXeque(char jogada) {
        return jogada == '+';
    }

    public boolean isXequeMate(char jogada) {
        return jogada == '#';
    }

    public boolean isRoqueMenor(String jogada) {
        return jogada.equals("O-O");
    }

    public boolean isRoqueMaior(String jogada) {
        return jogada.equals("O-O-O");
    }

    public boolean isEmpate(String jogada) {
        return jogada.equals("empate");
    }

    public boolean isDesistencia(String jogada) {
        return jogada.equals("desistir");
    }

    public boolean isPromocao(String jogada) {
        return jogada.charAt(2) == '=';
    }

    public boolean isPontuacao(String jogada) {
        return jogada.equals("pontos");
    }
}

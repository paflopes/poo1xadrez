/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.MovimentoPeca;
import br.edu.ifes.poo1.xadrez.cdp.NomePeca;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import br.edu.ifes.poo1.xadrez.cdp.Tabuleiro;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phillipe
 */
public class JogadorVirtual implements Jogador {

    private final Cor cor;
    private final String nome;
    private int pontos;
    private boolean vitoria;

    public JogadorVirtual() {
        this.cor = Cor.PRETO;
        this.nome = "ZEUS";
    }

    @Override
    public Jogada getJogada() {
        //Colocar aqui a "inteligencia artificial"
        Jogada jogada = new Jogada();
        Tabuleiro tab = Tabuleiro.getInstance();
        Map<String, Posicao> posicoes = tab.getPosicoes();
        List<Peca> pecas = tab.getPecas(this.cor);

        for (Map.Entry<String, Posicao> entry : posicoes.entrySet()) {
            Posicao posicao = entry.getValue();
            for (Peca peca : pecas) {
                //Verificamos se é um movimento possível.
                if (peca.validarMovimento(posicao) && !MovimentoPeca.isXeque(peca.getPosicao(), posicao)) {
                    jogada.setOperacao(Operacao.MOVIMENTO);
                    jogada.setPosicaoFinal(posicao);
                    jogada.setPosicaoInicial(peca.getPosicao());
                    //Verificamos se é uma captura possível.
                } else if ((peca.validarMovimentoCaptura(posicao) && posicao.getPeca().getNome() != NomePeca.REI)
                        || MovimentoPeca.isEnPassant(peca.getPosicao(), posicao)) {
                    jogada.setOperacao(Operacao.CAPTURA);
                    jogada.setPosicaoFinal(posicao);
                    jogada.setPosicaoInicial(peca.getPosicao());
                    //Verificado se é um Roque maior.
                } else if (MovimentoPeca.isRoqueMaior(peca.getPosicao())) {
                    jogada.setOperacao(Operacao.RMAIOR);
                    jogada.setPosicaoInicial(peca.getPosicao());
                    //Verificado se é um Roque menor.
                } else if (MovimentoPeca.isRoqueMenor(peca.getPosicao())) {
                    jogada.setOperacao(Operacao.RMENOR);
                    jogada.setPosicaoInicial(peca.getPosicao());
                    //Verifica se é um Xeque.
                } else if (MovimentoPeca.isXeque(peca.getPosicao(), posicao)
                        && !MovimentoPeca.isXequeMate(peca.getPosicao(), posicao)) {
                    jogada.setOperacao(Operacao.XEQUE);
                    jogada.setPosicaoInicial(peca.getPosicao());
                    jogada.setPosicaoFinal(posicao);
                    //Verifica se é um xeque mate.
                } else if (MovimentoPeca.isXequeMate(peca.getPosicao(), posicao)) {
                    jogada.setOperacao(Operacao.XMATE);
                    jogada.setPosicaoInicial(peca.getPosicao());
                    jogada.setPosicaoFinal(posicao);
                }
            }
        }
        return jogada;
    }

    @Override
    public Cor getCor() {
        return this.cor;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setVitoria(boolean vitoria) {
        this.vitoria = true;
    }

    @Override
    public void atualizaPontosJogador(Posicao novaPosicao) {
        this.pontos = this.pontos + novaPosicao.getPeca().getValor();
    }

    @Override
    public boolean isVitoria() {
        return this.vitoria;
    }

}

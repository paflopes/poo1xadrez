/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Bispo;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Cavalo;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Rainha;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Rei;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Torre;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author phillipe
 */
public class Tabuleiro implements Serializable{

    private final Map<String, Posicao> mapNomePosicao;

    public Tabuleiro() {
        this.mapNomePosicao = new HashMap<>();
        criarPosicoes();
        criarPeoes();
        criarTorres();
        criarBispos();
        criarCavalos();
        criarReis();
        criarRainhas();
    }


    /**
     * Pega uma posição do Tabuleiro
     *
     * @param id id da Posição. Ex.: {@code "11"} para coluna 1 e linha 1 ou
     * {@code "32"} para coluna 3 e linha 2
     * @return a Posicao pedida.
     */
    public Posicao getPosicao(String id) {
        return this.mapNomePosicao.get(id);
    }

    /**
     * Pega a posição que tem o rei de dada cor.
     *
     * @param cor A cor do rei.
     * @return A posição que tem o rei.
     */
    public Posicao getPosicaoRei(Cor cor) {
        Posicao posicaoRei = null;

        for (Map.Entry<String, Posicao> entry : mapNomePosicao.entrySet()) {
            Posicao posicao = entry.getValue();

            if (posicao.existePeca() && posicao.getPeca().getNome() == NomePeca.REI
                    && posicao.getPeca().getCor() == cor) {
                posicaoRei = posicao;
            }
        }

        return posicaoRei;
    }

    /**
     * Pega todas as posições do tabuleiro.
     *
     * @return Um mapa, com o endereço e sua posição associada.
     */
    public Map<String, Posicao> getPosicoes() {
        return this.mapNomePosicao;
    }

    /**
     * Pega todas as peças da cor adversária.
     *
     * @param cor A cor das peças.
     * @return Uma lista com todas as peças da cor dada.
     */
    public List<Peca> getPecas(Cor cor) {
        List<Peca> pecas = new ArrayList<>();

        for (Map.Entry<String, Posicao> entry : mapNomePosicao.entrySet()) {
            Posicao posicao = entry.getValue();

            if (posicao.existePeca() && posicao.getPeca().getCor() == cor) {
                pecas.add(posicao.getPeca());
            }
        }

        return pecas;
    }

    /**
     * Restaura o Tabuleiro para seu estado inicial.
     */

//    @Override
//    protected Object clone() throws CloneNotSupportedException {
//        Tabuleiro cloneMet;
//
//        cloneMet = (Tabuleiro) super.clone();
//        cloneMet.mapNomePosicao = new HashMap<>();
//
//        for (Map.Entry<String, Posicao> entrada : mapNomePosicao.entrySet()) {
//            Posicao posicao = entrada.getValue();
//            String idPosicao = entrada.getKey();
//
//            cloneMet.mapNomePosicao.put(idPosicao, (Posicao) posicao.clone());
//        }
//
//        return cloneMet;
//    }
    private void criarPosicoes() {
        //Montando as posições no Tabuleiro;
        for (char coluna = '1'; coluna < '9'; coluna++) {
            for (char linha = '1'; linha < '9'; linha++) {
                String idPosicao;
                Posicao posicao;

                //Montando a String
                idPosicao = "" + coluna + linha;
                //Criando a posição
                posicao = new PosicaoImpl(idPosicao);
                //Salvando as posições
                mapNomePosicao.put(idPosicao, posicao);
            }
        }
    }

    //Funções de criação das peças. São utilizadas no construtor da Classe.    
    private void criarPeoes() {
        //Criando os peoes;
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(16, Peao.class);

        //Salvando nas posições do Tabuleiro.
        salvarPeoes('2', pecas.get(Cor.BRANCO));
        salvarPeoes('7', pecas.get(Cor.PRETO));

    }

    private void salvarPeoes(char linha, Peca[] peoes) {
        int nPeoes = 0;
        for (char coluna = '1'; coluna < '9'; coluna++) {
            String idPosicao = "" + coluna + linha;
            Posicao posicao = mapNomePosicao.get(idPosicao);

            //Salvando
            posicao.setPeca(peoes[nPeoes]);
            nPeoes++;
        }
    }

    private void criarTorres() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, Torre.class);

        //Salvando as torres
        mapNomePosicao.get("11").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("81").setPeca(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("18").setPeca(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("88").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarBispos() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, Bispo.class);

        //Salvando os bispos
        mapNomePosicao.get("31").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("61").setPeca(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("38").setPeca(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("68").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarCavalos() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, Cavalo.class);

        //Salvando os cavalos
        mapNomePosicao.get("21").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("71").setPeca(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("28").setPeca(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("78").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarReis() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(2, Rei.class);

        //Salvando os bispos
        mapNomePosicao.get("51").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("58").setPeca(pecas.get(Cor.PRETO)[0]);
    }

    private void criarRainhas() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(2, Rainha.class);

        //Salvando os bispos
        mapNomePosicao.get("41").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("48").setPeca(pecas.get(Cor.PRETO)[0]);
    }

    @Override
    public String toString() {
        String saida = "";

        saida += "    1   2   3   4   5   6   7   8\n";
        saida += " ---------------------------------\n";
        for (int countLinha = 8; countLinha > 0; countLinha--) {
            saida += countLinha + " ";
            for (int countColuna = 1; countColuna < 9; countColuna++) {
                String idPosicao = "" + countColuna + countLinha;
                if (!this.getPosicao(idPosicao).existePeca()) {
                    saida += "|   ";
                } else {
                    if (this.getPosicao(idPosicao).getPeca().getCor() == Cor.BRANCO) {
                        saida += "|" + this.getPosicao(idPosicao).getPeca().getDesenho() + ".b";
                    } else {
                        saida += "|" + this.getPosicao(idPosicao).getPeca().getDesenho() + ".p";
                    }
                }
            }
            saida += "|";
            saida += " " + countLinha + "\n";
            saida += " ---------------------------------\n";
        }
        saida += "    1   2   3   4   5   6   7   8\n";
        return saida;
    }
}

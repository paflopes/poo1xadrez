/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phillipe
 */
public class Tabuleiro {

    private final Map<String, Posicao> mapNomePosicao = new HashMap<>();
    private final Map<Posicao, String> mapPosicaoNome = new HashMap<>();
    private static final Tabuleiro instance = new Tabuleiro();

    public Tabuleiro() {
        criarPosicoes();
        criarPeoes();
        criarTorres();
        criarBispos();
        criarCavalos();
    }

    /**
     *
     * @return Uma instância de Tabuleiro.
     */
    public static Tabuleiro getInstance() {
        return Tabuleiro.instance;
    }

    public Posicao getPosicao(String id) {
        return Tabuleiro.instance.mapNomePosicao.get(id);
    }

    public String getIdPosicao(Posicao posicao) {
        return Tabuleiro.instance.mapPosicaoNome.get(posicao);
    }

    /**
     *
     * @param posicoes Vetor de posições.
     */
    private void criarPosicoes() {
        //Montando as posições no Tabuleiro;
        for (char coluna = '1'; coluna < '9'; coluna++) {
            for (char linha = '1'; linha < '9'; linha++) {
                String idPosicao;
                Posicao posicao = new Posicao();

                //Montando a String
                idPosicao = "" + coluna + linha;
                //Salvando as posições
                mapNomePosicao.put(idPosicao, posicao);
                mapPosicaoNome.put(posicao, idPosicao);
            }
        }
    }

    //Funções de criação das peças. São utilizadas no construtor da Classe.    
    private void criarPeoes() {
        //Criando os peoes;
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(16, "Peao");

        //Salvando nas posições do Tabuleiro.
        salvarPeoes('2', pecas.get(Cor.BRANCO));
        salvarPeoes('7', pecas.get(Cor.PRETO));

    }

    private void salvarPeoes(char linha, Peca[] peoes) {
        int nPeoes = 0;
        for (char coluna = '1'; coluna < '9'; coluna++) {
            StringBuffer posicao;
            posicao = new StringBuffer();

            //Montando a posicao.
            posicao.append(coluna);
            posicao.append(linha);

            //Salvando
            mapNomePosicao.get(posicao.toString()).setPeca(peoes[nPeoes]);
            nPeoes++;
        }
    }

    private void criarTorres() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, "Torre");

        //Salvando as torres
        mapNomePosicao.get("11").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("81").setPeca(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("18").setPeca(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("88").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarBispos() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, "Bispo");

        //Salvando os bispos
        mapNomePosicao.get("21").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("71").setPeca(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("28").setPeca(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("78").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarCavalos() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, "Cavalo");

        //Salvando os bispos
        mapNomePosicao.get("31").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("61").setPeca(pecas.get(Cor.BRANCO)[1]);
        mapNomePosicao.get("38").setPeca(pecas.get(Cor.PRETO)[0]);
        mapNomePosicao.get("68").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarReis() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(2, "Rei");

        //Salvando os bispos
        mapNomePosicao.get("41").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("48").setPeca(pecas.get(Cor.PRETO)[0]);
    }

    private void criarRainhas() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(2, "Rainha");

        //Salvando os bispos
        mapNomePosicao.get("51").setPeca(pecas.get(Cor.BRANCO)[0]);
        mapNomePosicao.get("58").setPeca(pecas.get(Cor.PRETO)[0]);
    }
}

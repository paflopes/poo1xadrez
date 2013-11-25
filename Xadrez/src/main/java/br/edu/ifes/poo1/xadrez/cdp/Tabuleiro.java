/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author phillipe
 */
public class Tabuleiro {

    @SuppressWarnings("FieldMayBeFinal")
    private Map<String, Posicao> mapNomePosicao = new HashMap<>();
    @SuppressWarnings("FieldMayBeFinal")
    private Map<Posicao, String> mapPosicaoNome = new HashMap<>();

    private static final Tabuleiro instance = new Tabuleiro();

    public Tabuleiro() {
        //Criando Posições.
        Posicao[] posicoes;
        posicoes = new Posicao[64];

        for (int nPosicao = 0; nPosicao < posicoes.length; nPosicao++) {
            posicoes[nPosicao] = new Posicao();
        }

        salvarPosicoes(posicoes);
        criaPeoes();
        criarTorres();
        criarBispos();

    }

    /**
     *
     * @return Uma instância de Tabuleiro.
     */
    public static Tabuleiro getInstance() {
        return Tabuleiro.instance;
    }

    public Peca getPeca(String posicao) {
        return Tabuleiro.instance.mapNomePosicao.get(posicao).getPecaAtual();
    }

    public Posicao getPosicao(String id) {
        return Tabuleiro.instance.mapNomePosicao.get(id);
    }

    private void salvarPosicoes(Posicao[] posicoes) {
        //Montando as posições no Tabuleiro;
        int contadorPosicoes = 0;

        for (char coluna = 'a'; coluna < 'i'; coluna++) {
            for (char linha = '1'; linha < '9'; linha++) {
                StringBuffer idPosicao;
                idPosicao = new StringBuffer();
                //Montando a String
                idPosicao.append(coluna);
                idPosicao.append(linha);
                //Salvando as posições
                mapNomePosicao.put(idPosicao.toString(), posicoes[contadorPosicoes]);
                mapPosicaoNome.put(posicoes[contadorPosicoes], idPosicao.toString());
                contadorPosicoes++;
            }
        }

    }

    private void criaPeoes() {
        //Criando os peoes;
        Peca[] peoesBrancos;
        Peca[] peoesPretos;
        peoesBrancos = new Peca[8];
        peoesPretos = new Peca[8];

        for (int nPeao = 0; nPeao < peoesBrancos.length; nPeao++) {
            peoesBrancos[nPeao] = new Peao();
            peoesBrancos[nPeao].setCor(Cor.BRANCO);
        }
        for (int nPeao = 0; nPeao < peoesPretos.length; nPeao++) {
            peoesPretos[nPeao] = new Peao();
            peoesPretos[nPeao].setCor(Cor.PRETO);
        }

        //Salvando nas posições do Tabuleiro.
        salvarPeoes('2', peoesBrancos);
        salvarPeoes('7', peoesPretos);

    }

    private void salvarPeoes(char linha, Peca[] peoes) {
        int nPeoes = 0;
        for (char coluna = 'a'; coluna < 'i'; coluna++) {
            StringBuffer posicao;
            posicao = new StringBuffer();

            //Montando a posicao.
            posicao.append(coluna);
            posicao.append(linha);

            //Salvando
            mapNomePosicao.get(posicao.toString()).setPecaAtual(peoes[nPeoes]);
            nPeoes++;
        }
    }

    private void criarTorres() {
        Peca[] torresBrancas;
        Peca[] torresPretas;
        torresBrancas = new Peca[2];
        torresPretas = new Peca[2];

        // Instanciando as torres.
        for (int nTorre = 0; nTorre < torresBrancas.length; nTorre++) {
            torresBrancas[nTorre] = new Torre();
            torresBrancas[nTorre].setCor(Cor.BRANCO);
        }
        for (int nTorre = 0; nTorre < torresPretas.length; nTorre++) {
            torresPretas[nTorre] = new Torre();
            torresPretas[nTorre].setCor(Cor.BRANCO);
        }

        //Salvando as torres
        mapNomePosicao.get("a1").setPecaAtual(torresBrancas[0]);
        mapNomePosicao.get("h1").setPecaAtual(torresBrancas[1]);
        mapNomePosicao.get("a8").setPecaAtual(torresPretas[0]);
        mapNomePosicao.get("h8").setPecaAtual(torresPretas[1]);
    }

    private void criarBispos() {
        Peca[] bisposBrancos;
        Peca[] bisposPretos;
        bisposBrancos = new Peca[2];
        bisposPretos = new Peca[2];

        // Instanciando os bispos.
        for (int nBispo = 0; nBispo < bisposBrancos.length; nBispo++) {
            bisposBrancos[nBispo] = new Bispo();
            bisposBrancos[nBispo].setCor(Cor.BRANCO);
        }
        for (int nBispo = 0; nBispo < bisposPretos.length; nBispo++) {
            bisposPretos[nBispo] = new Bispo();
            bisposPretos[nBispo].setCor(Cor.PRETO);
        }

        //Salvando os bispos
        mapNomePosicao.get("b1").setPecaAtual(bisposBrancos[0]);
        mapNomePosicao.get("g1").setPecaAtual(bisposBrancos[1]);
        mapNomePosicao.get("b8").setPecaAtual(bisposPretos[0]);
        mapNomePosicao.get("g8").setPecaAtual(bisposPretos[1]);
    }
}

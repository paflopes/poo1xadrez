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

    private Map<String, Posicao> mapNomePosicao = new HashMap<>();
    private static final Tabuleiro instance = new Tabuleiro();

    public Tabuleiro() {
        criarPosicoes();
        criarPeoes();
        criarTorres();
        criarBispos();
        criarCavalos();
        criarReis();
        criarRainhas();
    }

    /**
     *
     * @return Uma instância de Tabuleiro.
     */
    public static Tabuleiro getInstance() {
        return Tabuleiro.instance;
    }

    public Posicao getPosicao(String id) {
        return Tabuleiro.instance.getMapNomePosicao().get(id);
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
                getMapNomePosicao().put(idPosicao, posicao);
                posicao.setId(idPosicao);
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
            getMapNomePosicao().get(posicao.toString()).setPeca(peoes[nPeoes]);
            nPeoes++;
        }
    }

    private void criarTorres() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, "Torre");

        //Salvando as torres
        getMapNomePosicao().get("11").setPeca(pecas.get(Cor.BRANCO)[0]);
        getMapNomePosicao().get("81").setPeca(pecas.get(Cor.BRANCO)[1]);
        getMapNomePosicao().get("18").setPeca(pecas.get(Cor.PRETO)[0]);
        getMapNomePosicao().get("88").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarBispos() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, "Bispo");

        //Salvando os bispos
        getMapNomePosicao().get("31").setPeca(pecas.get(Cor.BRANCO)[0]);
        getMapNomePosicao().get("61").setPeca(pecas.get(Cor.BRANCO)[1]);
        getMapNomePosicao().get("38").setPeca(pecas.get(Cor.PRETO)[0]);
        getMapNomePosicao().get("68").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarCavalos() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(4, "Cavalo");

        //Salvando os cavalos
        getMapNomePosicao().get("21").setPeca(pecas.get(Cor.BRANCO)[0]);
        getMapNomePosicao().get("71").setPeca(pecas.get(Cor.BRANCO)[1]);
        getMapNomePosicao().get("28").setPeca(pecas.get(Cor.PRETO)[0]);
        getMapNomePosicao().get("78").setPeca(pecas.get(Cor.PRETO)[1]);
    }

    private void criarReis() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(2, "Rei");

        //Salvando os bispos
        getMapNomePosicao().get("41").setPeca(pecas.get(Cor.BRANCO)[0]);
        getMapNomePosicao().get("48").setPeca(pecas.get(Cor.PRETO)[0]);
    }

    private void criarRainhas() {
        Map<Cor, Peca[]> pecas = PecasFactory.getPecas(2, "Rainha");

        //Salvando os bispos
        getMapNomePosicao().get("51").setPeca(pecas.get(Cor.BRANCO)[0]);
        getMapNomePosicao().get("58").setPeca(pecas.get(Cor.PRETO)[0]);
    }

    /**
     * @return the mapNomePosicao
     */
    public Map<String, Posicao> getMapNomePosicao() {
        return mapNomePosicao;
    }

    /**
     * @param mapNomePosicao the mapNomePosicao to set
     */
    public void setMapNomePosicao(Map<String, Posicao> mapNomePosicao) {
        this.mapNomePosicao = mapNomePosicao;
    }
    
    
   

   
}

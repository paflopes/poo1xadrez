/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Fábrica de Peças.
 *
 * @author leds
 */
public class PecasFactory {

    /**
     *
     * @param quantidade Quantidade de pecas a serem criadas.
     * @param nomePeca Nome da classe desejada. Ex.: "Cavalo", "Peao".
     * @return Um mapa com um vetor da peça desejada relacionado a uma cor.
     */
    public static Map<Cor, Peca[]> getPecas(int quantidade, Class nomePeca) {
        Map<Cor, Peca[]> pecas;
        pecas = criarMapPecas(quantidade);
        try {
            instanciarPecas(pecas, nomePeca);
        } catch (Exception ex) {
            Logger.getLogger(PecasFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pecas;
    }

    /**
     *
     * @param pecas Um mapa com dois vetores vazios de Pecas. As classes filhas
     * implementam suas respectivas classes.
     * @param nomePeca O nome do tipo de peças a serem criadas. Ex.: Peao,
     * Cavalo.
     * @throws java.lang.ClassNotFoundException
     */
    private static void instanciarPecas(Map<Cor, Peca[]> pecas, Class nomePeca) throws Exception {
        Peca[] pecasBrancas = pecas.get(Cor.BRANCO);
        Peca[] pecasPretas = pecas.get(Cor.PRETO);
        //Instanciando a classe recebida por parâmetro.
        Peca pecaPreta = (Peca) nomePeca.getDeclaredConstructor(Cor.class).newInstance(Cor.PRETO);
        Peca pecaBranca = (Peca) nomePeca.getDeclaredConstructor(Cor.class).newInstance(Cor.BRANCO);

        for (int nPeca = 0; nPeca < pecasBrancas.length; nPeca++) {
            pecasBrancas[nPeca] = (Peca) pecaBranca.clone();
            pecasPretas[nPeca] = (Peca) pecaPreta.clone();
        }
    }

    /**
     * Cria o Map de peças.
     *
     * @param quantidade A quantidade total de peças que se deseja criar.
     * @return Um Map que a cada cor associada, retorna um vetor vazio do tipo
     * Peça.
     */
    private static Map<Cor, Peca[]> criarMapPecas(int quantidade) {
        Peca[] pecasBrancas;
        Peca[] pecasPretas;
        Map<Cor, Peca[]> pecas;
        pecasBrancas = new Peca[quantidade];
        pecasPretas = new Peca[quantidade];

        pecas = new HashMap<>();
        pecas.put(Cor.BRANCO, pecasBrancas);
        pecas.put(Cor.PRETO, pecasPretas);

        return pecas;
    }
}

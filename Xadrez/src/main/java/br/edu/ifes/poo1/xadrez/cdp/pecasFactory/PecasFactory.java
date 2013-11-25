/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.pecasFactory;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Peca;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author leds
 */
public abstract class PecasFactory {

    public Map<Cor, Peca[]> getPecas(int quantidade) {
        Map<Cor, Peca[]> pecas;
        pecas = this.criarMapPecas(quantidade);
        this.instanciaPecas(pecas);
        return pecas;
    }

    /**
     * 
     * @param quantidade A quantidade total de peças que se deseja criar.
     * @return Um Map que a cada cor associada, retorna um vetor vazio do tipo Peça.
     */
    private Map<Cor, Peca[]> criarMapPecas(int quantidade) {
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

    /**
     * 
     * @param pecas Um mapa com dois vetores vazios de Pecas. As classes filhas implementam suas respectivas classes.
     */
    protected abstract void instanciaPecas(Map<Cor, Peca[]> pecas);
}

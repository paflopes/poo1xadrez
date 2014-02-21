/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import java.util.ArrayList;

/**
 *
 * @author Lincoln
 */
public class JogadorHumano implements Jogador {

    private String nome;
    private Jogada jogada;
    private Jogada jogadaAnterior;
    private int pontos;
    private boolean vitoria;
    private final Cor cor;
    private boolean save = false;
    private ArrayList<String> pecasCapturadas = new ArrayList<>();

    
    
    
    /**
     *
     * @param cor A cor do Jogador.
     */
    public JogadorHumano(Cor cor) {
        pontos = 0;
        vitoria = false;
        this.cor = cor;
    }

    /**
     * @return the nome
     */
    @Override
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @param partida
     * @return A última jogada feita.
     */
    @Override
    public Jogada getJogada(Partida partida) {
        return jogada;
    }

    /**
     *
     * @param jogada A última jogada feita.
     */
    public void setJogada(Jogada jogada) {
        this.jogada = jogada;
    }

    /**
     *
     * @return A penúltima jogada
     */
    public Jogada getJogadaAnterior() {
        return jogadaAnterior;
    }

    /**
     *
     * @param jogadaAnterior A penúltima jogada
     */
    public void setJogadaAnterior(Jogada jogadaAnterior) {
        this.jogadaAnterior = jogadaAnterior;
    }

    /**
     * @return the pontos
     */
    public int getPontos() {
        return pontos;
    }

    /**
     * @param pontos the pontos to set
     */
    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    /**
     * @return the vitoria
     */
    @Override
    public boolean isVitoria() {
        return vitoria;
    }

    /**
     * @param vitoria the vitoria to set
     */
    @Override
    public void setVitoria(boolean vitoria) {
        this.vitoria = vitoria;
    }

    /**
     * @return the cor
     */
    @Override
    public Cor getCor() {
        return cor;
    }

    @Override
    //Atualiza os pontos do jogador de acordo com o tipo da peça capturada
    public void atualizaPontosJogador(Posicao novaPosicao) {

        this.setPontos(this.getPontos() + novaPosicao.getPeca().getValor());
    }
    
    @Override
    public void setSave(boolean save){
        this.save = save;
    }
    
    public boolean getSave(){
        return save;
    }

    @Override
    public void setPecasCapturadas(String desenho) {
        this.pecasCapturadas.add(desenho);
    }

    @Override
    public String getPecasCapturadas() {

        String retornoPecas= "";                
        
        for(int contador = 0; contador < this.pecasCapturadas.size(); contador++){
            retornoPecas = retornoPecas + " " +pecasCapturadas.get(contador);
            
        }
        return retornoPecas;
    }


    

}

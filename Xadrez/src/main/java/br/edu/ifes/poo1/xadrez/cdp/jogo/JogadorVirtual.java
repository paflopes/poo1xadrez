/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;

/**
 *
 * @author phillipe
 */
public class JogadorVirtual implements Jogador {

    private final Cor cor;
    private final String nome;

    public JogadorVirtual() {
        this.cor = Cor.PRETO;
        this.nome = "ZEUS";
    }

    @Override
    public Jogada getJogada() {
        //Colocar aqui a "inteligencia artificial"
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void atualizaPontosJogador(Posicao novaPosicao) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}

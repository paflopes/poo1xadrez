/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.Posicao;
import java.io.Serializable;

/**
 *
 * @author phillipe
 */
public interface Jogador extends Serializable{

    public String getNome();

    public Jogada getJogada(Partida partida);

    public void setVitoria(boolean vitoria);

    public Cor getCor();

    public boolean isVitoria();

    public void atualizaPontosJogador(Posicao novaPosicao);
    
    public void setSave(boolean save);
    
    public void setPecasCapturadas(String desenho);
    
    public String getPecasCapturadas();
    
    
    
}

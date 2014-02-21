/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp.jogo;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Rainha;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Lincoln
 */
public class JogadaTest {
    Jogada jogada;
    
    @Before
    public void before() {
        this.jogada = new Jogada();
        this.jogada.setPecaDesejada(Rainha.class);
    }
    
    @Test
    public void testGetPecaDesejada() {
        Peca peca = (Peca) this.jogada.getPecaDesejada(Cor.PRETO);
        Assert.assertTrue(peca instanceof Rainha);
    }
}

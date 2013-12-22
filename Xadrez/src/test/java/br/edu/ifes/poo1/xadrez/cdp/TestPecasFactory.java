/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import java.util.Map;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author leds
 */
public class TestPecasFactory {

    Map<Cor, Peca[]> pecas;

    @Before
    public void before() {
        this.pecas = PecasFactory.getPecas(16, Peao.class);
    }

    @Test
    public void testGetPecas() {
        Assert.assertNotNull(this.pecas);

        for (int nPeca = 0; nPeca < 9; nPeca++) {
            Assert.assertEquals(Cor.BRANCO, this.pecas.get(Cor.BRANCO)[nPeca].getCor());
        }
        for (int nPeca = 0; nPeca < 9; nPeca++) {
            Assert.assertEquals(Cor.PRETO, this.pecas.get(Cor.PRETO)[nPeca].getCor());
        }

    }
}

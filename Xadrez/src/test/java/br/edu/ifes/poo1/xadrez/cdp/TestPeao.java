/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifes.poo1.xadrez.cdp;

import br.edu.ifes.poo1.xadrez.cdp.pecas.Peca;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class TestPeao {
    Tabuleiro tab;
    
    @Before
    public void before() {
        tab = Tabuleiro.getInstance();
    }
    
    @Test
    public void testValidarMovimento() {
        Peca peaoPreto = tab.getPosicao("47").getPeca();
        Peca peaoBranco = tab.getPosicao("32").getPeca();
        
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("47")));
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("46")));
        Assert.assertTrue(peaoPreto.validarMovimento(tab.getPosicao("45")));
        Assert.assertFalse(peaoPreto.validarMovimento(tab.getPosicao("44")));
        
        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("32")));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("33")));
        Assert.assertTrue(peaoBranco.validarMovimento(tab.getPosicao("34")));
        Assert.assertFalse(peaoBranco.validarMovimento(tab.getPosicao("35")));
    }
}

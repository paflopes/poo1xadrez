/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import br.edu.ifes.poo1.xadrez.cgt.JogoApl;
import br.edu.ifes.poo1.xadrez.cih.Impressora;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author phillipe
 */
public class ControleGeralTest {

    private ControleGeral controle;

    @Before
    public void before() {
        this.controle = new ControleGeral(new Impressora(), new JogoApl());
    }

    @Test
    public void testIdentificaOperacao() {
        Assert.assertEquals(Operacao.MOVIMENTO, controle.identificaOperacao("2346"));
        Assert.assertEquals(Operacao.CAPTURA, controle.identificaOperacao("11x22"));
        Assert.assertEquals(Operacao.PROMOCAO, controle.identificaOperacao("11=D"));
        Assert.assertEquals(Operacao.RMAIOR, controle.identificaOperacao("O-O-O"));
        Assert.assertEquals(Operacao.RMENOR, controle.identificaOperacao("O-O"));
        Assert.assertEquals(Operacao.XEQUE, controle.identificaOperacao("4523+"));
        Assert.assertEquals(Operacao.XMATE, controle.identificaOperacao("4523#"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIdentificaOperacaoArgInvalido() {
        controle.identificaOperacao("fdsa");
    }

    @Test
    public void testCriaJogada() {
        Jogada jogada = controle.criaJogada("1122");

        Assert.assertEquals("11", jogada.getPosicaoInicial().getId());
        Assert.assertEquals("22", jogada.getPosicaoFinal().getId());
        Assert.assertEquals(Operacao.MOVIMENTO, jogada.getOperacao());

        jogada = controle.criaJogada("33x54");
        Assert.assertEquals("33", jogada.getPosicaoInicial().getId());
        Assert.assertEquals("54", jogada.getPosicaoFinal().getId());
        Assert.assertEquals(Operacao.CAPTURA, jogada.getOperacao());
    }

}

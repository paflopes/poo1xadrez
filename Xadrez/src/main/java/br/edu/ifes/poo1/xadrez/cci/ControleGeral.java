package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorHumano;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorVirtual;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import br.edu.ifes.poo1.xadrez.cgt.JogoApl;
import br.edu.ifes.poo1.xadrez.cih.Impressora;

/**
 *
 * @author Lincoln
 */
public class ControleGeral {

    private final Impressora impressora;
    private final JogoApl apl;

    public ControleGeral(Impressora impressora, JogoApl apl) {
        this.impressora = impressora;
        this.apl = apl;
    }

    public void iniciarPartida() {
        this.impressora.imprimirMenu();
        int escolha = this.impressora.getOpcao();

        //Verifica se a escolha é válida.
        if (escolha == 1 || escolha == 2 || escolha == 3) {
            while (escolha != 3) {
                switch (escolha) {
                    case 1:
                        //Cadastra os jogadores e verifica se é um jogo a dois ou contra a máquina.
                        Jogador jogadorPreto;
                        Jogador jogadorBranco;

                        this.impressora.imprimirOpcaoJogarSozinho();
                        int opcao = this.impressora.getOpcao();

                        if (opcao == 1) {
                            jogadorPreto = new JogadorVirtual();
                        } else if (opcao == 2) {
                            jogadorPreto = this.cadastraJogador(Cor.PRETO);
                        } else {
                            impressora.imprimirArgumentoInvalido();
                            break;
                        }
                        jogadorBranco = this.cadastraJogador(Cor.BRANCO);

                        //Inicia a partida.
                        for (;;) {
                            impressora.pedirMovimento((JogadorHumano) jogadorBranco);
                            String jogadaStr = impressora.getString();

                            if (jogadaStr.matches("")) {

                            } else if (jogadaStr.equals("empate")) {

                            }

                            ((JogadorHumano) jogadorBranco).setJogada(criaJogada(jogadaStr));

                            //Faz a jogada.
                            while (true) {
                                try {
                                    this.apl.fazerJogada(jogadorBranco.getJogada());
                                    break;
                                } catch (JogadaInvalidaException ex) {
                                    impressora.imprimirJogadaInvalida();
                                }
                            }
                        }
                    case 2:
                        //imprimir dados.
                        break;
                }
                impressora.imprimirMenu();
                escolha = impressora.getOpcao();
            }
            //Se a escolha for inválida, então tentamos reiniciar a partida.
        } else {
            impressora.imprimirArgumentoInvalido();
            this.iniciarPartida();
        }
    }

    public void mostrarDados() {

    }

    public Jogador cadastraJogador(Cor cor) {
        impressora.pedirNomeJogador(cor.toString());
        JogadorHumano jogador = new JogadorHumano(cor);

        String nome = impressora.getString();
        jogador.setNome(nome);
        return jogador;
    }

    public Jogada criaJogada(String jogadaStr) {
        Jogada jogada = new Jogada();

        //Definimos a operação da jogada.
        jogada.setOperacao(identificaOperacao(jogadaStr));

        //Salva a posição inicial e final na jogada.
        jogadaStr = jogadaStr.replaceAll("\\D", "");
        jogada.setPosicaoInicial(apl.getPosicao("" + jogadaStr.charAt(0) + jogadaStr.charAt(1)));
        jogada.setPosicaoFinal(apl.getPosicao("" + jogadaStr.charAt(2) + jogadaStr.charAt(3)));

        return jogada;
    }

    /**
     * Define a operação da jogada.
     *
     * @param jogada O comando da jogada.
     * @return A operação identificada.
     */
    public Operacao identificaOperacao(String jogada) {
        Operacao operacao = null;

        if (jogada.contains("x")) {
            operacao = Operacao.CAPTURA;
        } else if (jogada.contains("=")) {
            operacao = Operacao.PROMOCAO;
        } else if (jogada.contains("O-O-O")) {
            operacao = Operacao.RMAIOR;
        } else if (jogada.contains("O-O")) {
            operacao = Operacao.RMENOR;
        } else if (jogada.contains("+")) {
            operacao = Operacao.XEQUE;
        } else if (jogada.contains("#")) {
            operacao = Operacao.XMATE;
        } else if (jogada.length() == 4 && jogada.matches("[0-9]+")) {
            operacao = Operacao.MOVIMENTO;
        } else {
            throw new IllegalArgumentException("Argumento Inválido!");
        }

        return operacao;
    }

}

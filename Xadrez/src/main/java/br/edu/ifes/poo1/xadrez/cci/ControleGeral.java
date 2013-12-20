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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lincoln
 */
public class ControleGeral {

    private final Impressora impressora;
    private final JogoApl apl;

    public ControleGeral() {
        this.impressora = new Impressora();
        this.apl = new JogoApl();
    }

    public void iniciarPrograma() {
        this.impressora.imprimirMenu();
        int escolha = this.impressora.getOpcao();

        //Verifica se a escolha é válida.
        if (escolha == 1 || escolha == 2 || escolha == 3) {
            while (escolha != 3) {
                switch (escolha) {
                    case 1:
                        try {
                            this.iniciarPartida();
                        } catch (PartidaEncerradaException ex) {
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
            this.iniciarPrograma();
        }
    }

    /**
     * Inicia uma partida.
     *
     * @throws br.edu.ifes.poo1.xadrez.cci.PartidaEncerradaException
     */
    public void iniciarPartida() throws PartidaEncerradaException {
        //Cadastra os jogadores e verifica se é um jogo a dois ou contra a máquina.
        Jogador jogadorPreto;
        Jogador jogadorBranco;

        this.apl.reiniciarTabuleiro();
        this.impressora.imprimirOpcaoJogarSozinho();
        int opcao = this.impressora.getOpcao();

        // Verificamos qual a opção que o usuário escolheu.
        // 1 para jogar sozinho e 2 para jogar contra outro humano.
        while (opcao != 1 && opcao != 2) {
            impressora.imprimirArgumentoInvalido();
            opcao = impressora.getOpcao();
        }

        if (opcao == 1) {
            jogadorPreto = new JogadorVirtual();
        } else {
            jogadorPreto = this.cadastraJogador(Cor.PRETO);
        }
        jogadorBranco = this.cadastraJogador(Cor.BRANCO);

        for (;;) {
            impressora.imprimirTabuleiro(this.apl.getTabuleiro());
            while (true) {
                try {
                    this.iniciarJogada((JogadorHumano) jogadorBranco);
                    break;
                } catch (JogadaInvalidaException ex) {
                    impressora.imprimirJogadaInvalida();
                }
            }

            impressora.imprimirTabuleiro(this.apl.getTabuleiro());
            if (opcao == 1) {
                try {
                    this.apl.fazerJogada(jogadorPreto);
                } catch (JogadaInvalidaException ex) {
                    Logger.getLogger(ControleGeral.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (opcao == 2) {
                while (true) {
                    try {
                        this.iniciarJogada((JogadorHumano) jogadorPreto);
                        break;
                    } catch (JogadaInvalidaException ex) {
                        impressora.imprimirJogadaInvalida();
                    }
                }
            }
        }
    }

    /**
     * Inicia a jogada de um player humano.
     *
     * @param jogador O jogador a efetuar a o jogada
     * @throws JogadaInvalidaException É lançada quando a jogada não é bem
     * sucedida.
     * @throws br.edu.ifes.poo1.xadrez.cci.PartidaEncerradaException Quando a partida é encerrada.
     */
    public void iniciarJogada(JogadorHumano jogador) throws JogadaInvalidaException, PartidaEncerradaException {
        impressora.pedirMovimento(jogador.getNome());
        String jogadaStr = impressora.getString();

        // Valida o comando dado pelo jogador.
        while (!this.validarEntrada(jogadaStr)) {
            impressora.imprimirArgumentoInvalido();
            impressora.pedirMovimento(jogador.getNome());
            jogadaStr = impressora.getString();
        }

        // Verifica se é desistência ou empate.
        if (jogadaStr.matches("\\D+") && (!jogadaStr.equals("O-O-O") || !jogadaStr.equals("O-O"))) {
            if (jogadaStr.equals("desistir") || jogadaStr.equals("empate")) {
                throw new PartidaEncerradaException("Partida encerrada!");
            }
        }

        ((JogadorHumano) jogador).setJogada(criaJogada(jogadaStr));

        this.apl.fazerJogada(jogador);
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

        if (jogada.getOperacao() != Operacao.RMAIOR && jogada.getOperacao() != Operacao.RMENOR) {
            //Salva a posição inicial e final na jogada.
            jogadaStr = jogadaStr.replaceAll("\\D", "");
            jogada.setPosicaoInicial(apl.getPosicao("" + jogadaStr.charAt(0) + jogadaStr.charAt(1)));
            jogada.setPosicaoFinal(apl.getPosicao("" + jogadaStr.charAt(2) + jogadaStr.charAt(3)));
        }

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
        } else if (jogada.matches("[1-8]{4}")) {
            operacao = Operacao.MOVIMENTO;
        }

        return operacao;
    }

    /**
     * Verifica se a string que o usuário digitou é válida.
     *
     * @param entrada A entrada a ser verificada.
     * @return {@code true} se for válido ou {@code false} se não for válido.
     */
    public boolean validarEntrada(String entrada) {
        // Se a entrada for só de caracteres.
        if (entrada.matches("\\D+")) {
            return entrada.equals("desistir") || entrada.equals("empate")
                    || entrada.equals("O-O") || entrada.equals("O-O-O");
        } else if (entrada.matches("[1-8]{4}") || entrada.matches("[1-8]{2}x[1-8]{2}")
                || entrada.matches("[1-8]{4}(\\+|#)") || entrada.matches("([1-8]1|[1-8]8)=(D|T|B|C)")) {
            return true;
        }

        return false;
    }
}

package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorHumano;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorVirtual;
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
                            //Faz
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

    public Jogada pedeJogada(JogadorHumano jogador) {
        impressora.pedirMovimento(jogador);
        String jogadaStr = impressora.getString();
        Jogada jogada = new Jogada();

        return null;
    }

//    private void jogada(Jogador jogador) {
//        impressora.imprimirTabuleiro(apl.getTabuleiro());
//        jogador.setJogada(pedeJogada(jogador));
//        processaJogada(jogador);
//
//        while (!jogador.getJogada().equals("valida") && !jogador.getJogada().equals("desistir")) {
//
//            if (!jogador.getJogada().equals("pontos") && !jogador.getJogada().equals("empate")) {
//                impressora.imprimiJogadaInvalida();
//            }
//            if (jogador.getJogada().equals("empate")) {
//                impressora.imprimiPedidoEmpate();
//                Scanner scanner = new Scanner(System.in);
//                String escolha = scanner.nextLine();
//                if (escolha.equals("S") || escolha.equals("s")) {
//                    impressora.imprimiEmpate();
//                    break;
//                }
//            }
//            jogador.setJogada(pedeJogada(jogador));
//            processaJogada(jogador);
//        }
//        jogador.setVitoria(controle.isXequeMate(jogador.getJogada().charAt(4)));
//    }
}

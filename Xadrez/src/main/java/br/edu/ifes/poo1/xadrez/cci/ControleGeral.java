package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
import br.edu.ifes.poo1.xadrez.cdp.jogo.DadoJogo;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogada;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadaInvalidaException;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Jogador;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorHumano;
import br.edu.ifes.poo1.xadrez.cdp.jogo.JogadorVirtual;
import br.edu.ifes.poo1.xadrez.cdp.jogo.Operacao;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Bispo;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Cavalo;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Rainha;
import br.edu.ifes.poo1.xadrez.cdp.pecas.Torre;
import br.edu.ifes.poo1.xadrez.cgd.Jogos;
import br.edu.ifes.poo1.xadrez.cgd.Persistencia;
import br.edu.ifes.poo1.xadrez.cgt.JogoApl;
import br.edu.ifes.poo1.xadrez.cih.Impressora;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Lincoln
 */
public class ControleGeral {

    private final Impressora impressora;
    private final JogoApl apl;
    private static Partida partida = null;
    private Persistencia<Jogos> persintencia = new Persistencia<Jogos>();
    private Jogos jogos = null;
    
    
    public ControleGeral() throws ClassNotFoundException {
        this.impressora = new Impressora();
        this.apl = new JogoApl();
        this.jogos = persintencia.load();
    }

    public void iniciarPrograma() throws ClassNotFoundException, PartidaEncerradaException {
        this.impressora.imprimirMenu();
        String escolha = this.impressora.getString();

        //Verifica se a escolha é válida.
        if (escolha.matches("[1-3]")) {
            while (!escolha.equals("3")) {
                switch (escolha) {
                    case "1":
                        try {
                            partida = new Partida();
                            partida.iniciaPartida();
                            this.iniciarPartida(partida);
                        } catch (PartidaEncerradaException ex) {
                        }
                        break;
                    
                    case "2":
                      
                        int numeroPartidas = partida.getPartidasNaoFinalizadas(jogos.getListPartidas()); //numero de partidas nao finalizadas
                        if(numeroPartidas>0){ //se existir partida para jogar                    
                            impressora.imprimirPartidas(jogos.getListPartidas());
                            escolha = impressora.getString(); //escolhe a partida
                            if(escolha.matches("[0 -"+(numeroPartidas-1)+"]")){ //verifica se a escolha é verdadeira
                                partida = jogos.getListPartidas().get(Integer.parseInt(escolha.trim())); //pega a partida escolhida
                                jogos.getListPartidas().remove(partida);
                                partida.recomeçarPartida(); //coloca false na variavel que indica se o usuario ja salvou, para poder sair
                                this.iniciarPartida(partida);
                            }else{ // se a escolha nao for verdadeira
                                impressora.imprimirArgumentoInvalido();
                                this.iniciarPrograma();
                            }
                        }else{ // se nao existir partidas
                            impressora.imprimirSemPartidas();
                            this.iniciarPrograma();
                        }
                        break;
                    
                    case "3":
                        impressora.imprimirDados(apl.getDados());
                        break;
                }
                impressora.imprimirMenu();
                escolha = impressora.getString();
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
     * @param partida
     * @throws br.edu.ifes.poo1.xadrez.cci.PartidaEncerradaException
     */
    public void iniciarPartida(Partida partida) throws PartidaEncerradaException {
        //Cadastra os jogadores e verifica se é um jogo a dois ou contra a máquina.

        this.impressora.imprimirOpcaoJogarSozinho();
        String opcao = this.impressora.getString();

        // Verificamos qual a opção que o usuário escolheu.
        // 1 para jogar sozinho e 2 para jogar contra outro humano.
        while (!(opcao.equals("1") || opcao.equals("2"))) {
            impressora.imprimirArgumentoInvalido();
            opcao = impressora.getString();
        }

        partida.setJogadorBranco(this.cadastraJogador(Cor.BRANCO));        
        
        if (opcao.equals("1")) {
            partida.setJogadorPreto(new JogadorVirtual());
        } else {
            partida.setJogadorPreto(this.cadastraJogador(Cor.PRETO));
        }
        

        for (;;) {
            impressora.imprimirTabuleiro(this.partida.getTabuleiro());
            while (true) {
                try {
                    this.iniciarJogada((JogadorHumano) partida.getJogadorBranco(), partida.getJogadorPreto());
                    break;
                } catch (JogadaInvalidaException ex) {
                    impressora.imprimirJogadaInvalida();
                }
            }

            impressora.imprimirTabuleiro(this.partida.getTabuleiro());
            if (opcao.equals("1")) {
                try {
                    this.apl.fazerJogada(partida.getJogadorPreto(), partida);
                } catch (JogadaInvalidaException ex) {
                    Logger.getLogger(ControleGeral.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else if (opcao.equals("2")) {
                while (true) {
                    try {
                        this.iniciarJogada((JogadorHumano) partida.getJogadorPreto(), (JogadorHumano) partida.getJogadorBranco());
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
     * @param jogadorAtual O jogador a efetuar a o jogada
     * @param jogadorProx O jogador que jogara na proxima jogada, necessario
     * para desistencia
     * @throws JogadaInvalidaException É lançada quando a jogada não é bem
     * sucedida.
     * @throws br.edu.ifes.poo1.xadrez.cci.PartidaEncerradaException Quando a
     * partida é encerrada.
     */
    public void iniciarJogada(JogadorHumano jogadorAtual, Jogador jogadorProx) throws JogadaInvalidaException, PartidaEncerradaException {
        impressora.pedirMovimento(jogadorAtual.getNome());
        String jogadaStr = impressora.getString();
        
        
        // Valida o comando dado pelo jogador.
        while (!this.validarEntrada(jogadaStr)) {
            impressora.imprimirArgumentoInvalido();
            impressora.pedirMovimento(jogadorAtual.getNome());
            jogadaStr = impressora.getString();
            
        }

        // Verifica se é desistência, empate ou se ele solicita ver os pontos.
        if (jogadaStr.matches("\\D+") && (!jogadaStr.equals("O-O-O") || !jogadaStr.equals("O-O"))) {
            switch (jogadaStr) {
                case "desistir":
                    if (!jogadorProx.getNome().equals("ZEUS")) {
                        jogadorProx.setVitoria(true);
                    }
                    DadoJogo.setListaDados(jogadorAtual, apl.getDados());
                    DadoJogo.setListaDados(jogadorProx, apl.getDados());
                    partida.encerrarPartida(jogadorProx.getNome());
                    this.jogos.getListPartidas().add(partida);
                    this.persintencia.save(this.jogos);
                    impressora.imprimirJogoSalvo();
                    impressora.imprimiFimJogo();
                    throw new PartidaEncerradaException("Partida encerrada!");
                case "empate":
                    String escolha = "";
                    while (!escolha.equals("S") && !escolha.equals("N")) {
                        impressora.imprimiPedidoEmpate();
                        Scanner scanner = new Scanner(System.in);
                        escolha = scanner.nextLine();
                        switch (escolha) {
                            case ("S"):
                                impressora.imprimiEmpate();
                                partida.encerrarPartida("Empate");
                                this.jogos.getListPartidas().add(partida);
                                this.persintencia.save(this.jogos);
                                impressora.imprimirJogoSalvo();
                                impressora.imprimiFimJogo();
                                throw new PartidaEncerradaException("Partida encerrada!");
                            case ("N"):
                                iniciarJogada(jogadorAtual, jogadorProx);
                                return;
                                
                        }
                    }
                case "pontos":
                    impressora.imprimirPontos(jogadorAtual);
                    iniciarJogada(jogadorAtual, jogadorProx);
                    return;
                   
                case "salvar":                    
                    jogadorAtual.setSave(true);  
                    this.jogos.getListPartidas().add(partida);
                    this.persintencia.save(this.jogos);
                    impressora.imprimirJogoSalvo();
                    iniciarJogada(jogadorAtual, jogadorProx);
                    return;
                    
                case "sair":
                    if(jogadorAtual.getSave()){
                        impressora.imprimiFimJogo();
                        throw new PartidaEncerradaException("Partida encerrada!");            
                    }else{
                        impressora.imprimiErroSaida();
                        iniciarJogada(jogadorAtual, jogadorProx);
                        return;
                    }
            }
        }

        ((JogadorHumano) jogadorAtual).setJogada(criaJogada(jogadaStr));

        this.apl.fazerJogada(jogadorAtual, partida);

        if (jogadorAtual.isVitoria()) {
            DadoJogo.setListaDados(jogadorAtual, apl.getDados());
            DadoJogo.setListaDados(jogadorProx, apl.getDados());
            partida.encerrarPartida(jogadorAtual.getNome());
            this.jogos.getListPartidas().add(partida);
            this.persintencia.save(this.jogos);
            impressora.imprimirJogoSalvo();
            impressora.imprimiFimJogo();
            throw new PartidaEncerradaException("Partida encerrada!");
        }
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

        if (jogada.getOperacao() == Operacao.PROMOCAO) {
            char tipoPeca = jogadaStr.charAt(3);

            switch (tipoPeca) {
                case 'D':
                    jogada.setPecaDesejada(Rainha.class);
                    break;
                case 'T':
                    jogada.setPecaDesejada(Torre.class);
                    break;
                case 'B':
                    jogada.setPecaDesejada(Bispo.class);
                    break;
                case 'C':
                    jogada.setPecaDesejada(Cavalo.class);
                    break;
            }

        }

        if (jogada.getOperacao() != Operacao.RMAIOR && jogada.getOperacao() != Operacao.RMENOR) {
            //Salva a posição inicial e final na jogada.
            jogadaStr = jogadaStr.replaceAll("\\D", "");
            jogada.setPosicaoInicial(apl.getPosicao("" + jogadaStr.charAt(0) + jogadaStr.charAt(1), partida));

            if (jogada.getOperacao() != Operacao.PROMOCAO) {
                jogada.setPosicaoFinal(apl.getPosicao("" + jogadaStr.charAt(2) + jogadaStr.charAt(3), partida));
            }
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
                    || entrada.equals("O-O") || entrada.equals("O-O-O")
                    || entrada.equals("pontos") || entrada.equals("salvar")
                    || entrada.equals("sair");
        } else if (entrada.matches("[1-8]{4}") || entrada.matches("[1-8]{2}x[1-8]{2}")
                || entrada.matches("[1-8]{4}(\\+|#)") || entrada.matches("([1-8]1|[1-8]8)=(D|T|B|C)")) {
            return true;
        }

        return false;
    }
}

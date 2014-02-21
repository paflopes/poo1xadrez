package br.edu.ifes.poo1.xadrez.cci;

import br.edu.ifes.poo1.xadrez.cdp.Cor;
import br.edu.ifes.poo1.xadrez.cdp.Partida;
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
import br.edu.ifes.poo1.xadrez.cdp.Jogos;
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
    private Partida partida;
    private final Persistencia<Jogos> persintencia = new Persistencia<>();
    private Jogos jogos = null;
    
    
    public ControleGeral() throws ClassNotFoundException {
        this.impressora = new Impressora();
        this.apl = new JogoApl();
        
    }
    
    public void run() throws ClassNotFoundException, PartidaEncerradaException{
        
        this.impressora.imprimirMenu();
        String escolha = this.impressora.getString();
        
        //Verifica se a escolha é válida.
        
        
        
        if (escolha.matches("[1-4]")) {
            while (escolha.matches("[1-3]")) {
                iniciarPrograma(escolha);
                this.impressora.imprimirMenu();
                escolha = this.impressora.getString();
                
            }
        
        } else {
            impressora.imprimirArgumentoInvalido();
            this.run();
            return;
        }
    }

    public void iniciarPrograma(String escolha) throws ClassNotFoundException, PartidaEncerradaException {
               
        
                switch (escolha) {
                    case "1":
                        try {
                            
                            this.jogos = persintencia.load();
                            if(jogos == null){
                                jogos = new Jogos();
                            }
                            partida = new Partida();
                            partida.iniciaPartida();
                            this.iniciarPartida(partida);
                        } catch (PartidaEncerradaException ex) {
                        }
                        break;
                    
                    case "2":
                        this.jogos = (Jogos) persintencia.load();
                        if(jogos != null){
                            int numeroPartidas = jogos.getListPartidasNaoFinalizadas().size(); //numero de partidas nao finalizadas
                            if(numeroPartidas>0){                     
                                impressora.imprimirPartidas(jogos.getListPartidasNaoFinalizadas());
                                impressora.imprimirEscolhaPartida();
                                String opcao = impressora.getString(); //escolhe a partida
                                if(opcao.matches("[0 -"+(numeroPartidas-1)+"]")){ //verifica se a escolha é verdadeira
                                    partida = jogos.getListPartidasNaoFinalizadas().get(Integer.parseInt(opcao.trim())); //pega a partida escolhida
                                    jogos.getListPartidasNaoFinalizadas().remove(Integer.parseInt(opcao.trim()));
                                    partida.recomeçarPartida(); //coloca false na variavel que indica se o usuario ja salvou, para poder sair
                                    this.jogadas(partida);
                                }else{ // se a escolha nao for verdadeira
                                    impressora.imprimirArgumentoInvalido();
                                    return;
                                }                            
                            }else{
                                impressora.imprimirSemPartidas();
                                return;
                            }
                        }else{ // se nao existir partidas
                            impressora.imprimirSemPartidas();
                            return;
                        }
                        break;
                    
                    case "3":
                        jogos = persintencia.load(); 
                        if(jogos != null){
                            impressora.imprimirDados(jogos);                            
                        }else{
                            impressora.imprimirSemDados();
                        } 
                        break;
                         
                }
                                  
    }

    /**
     * Inicia uma partida.
     *
     * @param partida
     * @throws br.edu.ifes.poo1.xadrez.cci.PartidaEncerradaException
     */

    /**
     * Inicia uma partida.
     * @param partida
     * @throws br.edu.ifes.poo1.xadrez.cci.PartidaEncerradaException
     * @throws java.lang.ClassNotFoundException
     */
    public void iniciarPartida(Partida partida) throws PartidaEncerradaException, ClassNotFoundException {
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
        
        partida.setTurno(partida.getJogadorBranco().getNome());
        

        jogadas(partida);
        
        
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
    public void iniciarJogada(JogadorHumano jogadorAtual, Jogador jogadorProx) throws JogadaInvalidaException, PartidaEncerradaException, ClassNotFoundException {
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
                    jogos.setListDadosJogos(jogadorAtual, jogos.getListDadoJogo());
                    jogos.setListDadosJogos(jogadorProx, jogos.getListDadoJogo());
                    partida.encerrarPartida(jogadorProx.getNome());
                    this.jogos.getListPartidasFinalizadas().add(partida);
                    this.persintencia.save(this.jogos);
                    impressora.imprimirJogoSalvo();
                    impressora.imprimiFimJogo();
                    return;
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
                                this.jogos.getListPartidasFinalizadas().add(partida);
                                this.persintencia.save(this.jogos);
                                impressora.imprimirJogoSalvo();
                                impressora.imprimiFimJogo();
                                
                                return;
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
                    this.jogos.getListPartidasNaoFinalizadas().add(partida);
                    this.persintencia.save(this.jogos);
                    impressora.imprimirJogoSalvo();
                    iniciarJogada(jogadorAtual, jogadorProx);
                    return;
                    
                case "sair":
                    if(jogadorAtual.getSave()){
                        partida.setPartidaInterrompida(true);
                        
                        impressora.imprimiFimJogo();
                        return;
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
            jogos.setListDadosJogos(jogadorAtual, jogos.getListDadoJogo());
            jogos.setListDadosJogos(jogadorProx, jogos.getListDadoJogo());
            partida.encerrarPartida(jogadorAtual.getNome());
            this.jogos.getListPartidasFinalizadas().add(partida);
            this.persintencia.save(this.jogos);
            impressora.imprimirJogoSalvo();
            impressora.imprimiFimJogo();
            return;
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
        
        if(this.partida == null) {
            this.partida = new Partida();
            this.partida.iniciaPartida();
        }

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
    
    public void jogadas(Partida partida) throws PartidaEncerradaException, ClassNotFoundException{
        
        while(!partida.isFinalizada() && !partida.isPartidaInterrompida()){
            jogarJogador(partida);
        }
        
    }
    
    public void jogarJogador(Partida partida) throws PartidaEncerradaException, ClassNotFoundException{
        
        impressora.imprimirTabuleiro(partida.getTabuleiro());
        if(partida.getTurno().equals(partida.getJogadorBranco().getNome())){
            if(partida.getJogadorPreto().getNome().equals("ZEUS")){
                while (true) {
                     try {
                        this.iniciarJogada((JogadorHumano) partida.getJogadorBranco(), (JogadorVirtual) partida.getJogadorPreto());
                        partida.setTurno(partida.getJogadorPreto().getNome());
                        break;
                        } catch (JogadaInvalidaException ex) {
                            impressora.imprimirJogadaInvalida();
                        }
                }
            }else{
                while (true) {
                     try {
                        this.iniciarJogada((JogadorHumano) partida.getJogadorBranco(), (JogadorHumano) partida.getJogadorPreto());
                        partida.setTurno(partida.getJogadorPreto().getNome());
                        break;
                        } catch (JogadaInvalidaException ex) {
                            impressora.imprimirJogadaInvalida();
                        }
                }
            }                           
        }else if(partida.getTurno().equals("ZEUS")){
            try {
                this.apl.fazerJogada(partida.getJogadorPreto(), partida);
                partida.setTurno(partida.getJogadorBranco().getNome());
            } catch (JogadaInvalidaException ex) {
                Logger.getLogger(ControleGeral.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            while (true) {
                try {
                    this.iniciarJogada((JogadorHumano) partida.getJogadorPreto(), (JogadorHumano) partida.getJogadorBranco());
                    partida.setTurno(partida.getJogadorBranco().getNome());
                    break;
                } catch (JogadaInvalidaException ex) {
                    impressora.imprimirJogadaInvalida();
                }
            }
        }
    }
    
}

package br.edu.ifes.poo1.xadrez.cci;

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

        if (escolha == 1) {
            this.impressora.imprimirOpcaoJogarSozinho();
            int opcao = this.impressora.getOpcao();
            while (true) {
                if (opcao == 1) {
                    //Cadastrar ZEUS.
                } else if (opcao == 2) {
                    //Cadastrar os dois jogadores.
                } else {
                    impressora.imprimirArgumentoInvalido();
                }
            }
        }

        while (escolha != 3) {
            switch (escolha) {
                case 1:

            }
        }

    }

    public void mostrarDados() {

    }
}

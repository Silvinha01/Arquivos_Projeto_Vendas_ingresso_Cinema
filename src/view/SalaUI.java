package view;

import java.util.InputMismatchException;
import model.Sala;
import repositorio.RepositorioSalas;
import util.Console;
import view.menu.SalaMenu;

/**
 * Essa classe contém os métodos para salas.
 *
 * @author silvinha01
 */
public class SalaUI {

    private RepositorioSalas listaSalas;

    /**
     * Inicia a classe SalaUI com seus dados. listaSalas recebe listaSalas.
     */
    public SalaUI(RepositorioSalas listaSalas) {
        this.listaSalas = listaSalas;
    }

    /**
     * Esse método executar acessa o submenu SalaMenu e suas opções.
     *
     * @author silvinha01
     */
    public void executar() {
        int opcao = 0;
        do {
            try {
                System.out.println(SalaMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case SalaMenu.OP_CADASTRAR:
                        cadastrarSalas();
                        break;
                    case SalaMenu.OP_LISTAR:
                        listarSalas();
                        break;
                    case SalaMenu.OP_BUSCAR_NUMERO:
                        buscarNumeroSala();
                        break;
                    case SalaMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != SalaMenu.OP_VOLTAR);
    }

    /**
     * Esse método cadastra uma nova sala na lista de salas.
     *
     * @author silvinha01
     */
    private void cadastrarSalas() {
        int numero = Console.scanInt("Número da sala: ");
        if (listaSalas.buscarSalaPorNumero(numero) != null) {
            System.out.println("Sala já existente no cadastro");
        } else {
            int qtdAssentos = Console.scanInt("Quantidade de assentos: ");
            listaSalas.addSalas(new Sala(numero, qtdAssentos));
            System.out.println("Sala número " + numero + " cadastrada com sucesso!");
        }
    }

    /**
     * Esse método lista as salas cadastradas na lista de salas.
     *
     * @author silvinha01
     */
    public void listarSalas() {
        System.out.println("\nLista de Salas");
        if (!listaSalas.temSalas()) {
            System.out.println("Nenhuma sala foi cadastrada!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "NÚMERO") + "\t"
                    + String.format("%-20s", "|QUANTIDADE DE ASSENTOS"));
            for (Sala sala : listaSalas.getListaSalas()) {
                System.out.println(String.format("%-10s", sala.getNumeroSala()) + "\t"
                        + String.format("%-20s", "|" + sala.getQtdAssentos()));
            }
        }
    }

    /**
     * Esse método busca uma sala pelo número digitado na lista de salas.
     *
     * @author silvinha01
     */
    public void buscarNumeroSala() {
        System.out.println("\nBusca de sala por número");
        int numero = Console.scanInt("Digite o Número da sala: ");
        if (listaSalas.existeNumeroSala(numero)) {
            Sala sala = listaSalas.buscarSalaPorNumero(numero);

            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "NÚMERO") + "\t"
                    + String.format("%-20s", "|QUANTIDADE DE ASSENTOS"));

            System.out.println(String.format("%-10s", sala.getNumeroSala()) + "\t"
                    + String.format("%-20s", "|" + sala.getQtdAssentos()));
        } else {
            System.out.println("Este Número de sala não está cadastrado!");
        }
    }

}

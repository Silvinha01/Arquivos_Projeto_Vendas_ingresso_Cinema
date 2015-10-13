package view;

import java.text.ParseException;
import java.util.InputMismatchException;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSessoes;
import repositorio.RepositorioVendas;
import util.Console;
import view.menu.MainMenu;

/**
 * Essa classe acessa o menu principal e os submenus.
 *
 * @author silvinha01
 */
public class MainUI {

    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;
    private RepositorioVendas listaVendas;
    private RepositorioSessoes listaSecoes;

    /**
     * Inicia a classe MainUI com seus dados. listaFilmes recebe
     * RepositorioFilmes. listaSalas recebe RepositorioSalas. listaVendas recebe
     * RepositorioVendas. listaSessoes recebe RepositorioSessoes
     */
    public MainUI() {
        listaFilmes = new RepositorioFilmes();
        listaSalas = new RepositorioSalas();
        listaVendas = new RepositorioVendas();
        listaSecoes = new RepositorioSessoes();
    }

    /**
     * Esse método executar acessa o menu principal MainMenu e suas opções.
     *
     * @author silvinha01
     */
    public void executar() throws ParseException {
        int opcao = - 1;
        do {
            try {
                System.out.println(MainMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");

                switch (opcao) {
                    case MainMenu.OP_FILMES:
                        new FilmeUI(listaFilmes).executar();
                        break;
                    case MainMenu.OP_SALAS:
                        new SalaUI(listaSalas).executar();
                        break;
                    case MainMenu.OP_SECOES:
                        new SessaoUI(listaSalas, listaFilmes, listaSecoes).executar();
                        break;
                    case MainMenu.OP_VENDAS:
                        new VendaUI(listaVendas, listaSecoes).executar();
                        break;
                    case MainMenu.OP_RELATORIOS:
                    new RelatorioVendasUI(listaVendas).executar();
                        break;
                    case MainMenu.OP_SAIR:
                        System.out.println("Aplicação finalizada!!!");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != MainMenu.OP_SAIR);
    }

}

package view;

import java.util.InputMismatchException;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSecoes;
import repositorio.RepositorioVendas;
import util.Console;
import view.menu.MainMenu;

/**
 *
 * @author silvinha01
 */
public class MainUI {

    private RepositorioFilmes listaFilmes;
    private RepositorioSalas listaSalas;
    private RepositorioSecoes listaSecoes;
    private RepositorioVendas listaVendas;

    public MainUI() {
        listaFilmes = new RepositorioFilmes();
        listaSalas = new RepositorioSalas();
        listaSecoes = new RepositorioSecoes();
        listaVendas = new RepositorioVendas();
    }

    public void executar() {
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
                    case MainMenu.OP_SECAO:
                        new SecaoUI(listaSalas, listaFilmes, listaSecoes).executar();
                        break;
                    case MainMenu.OP_VENDAS:
                        new VendaUI(listaSecoes, listaVendas).executar();
                        break;
                    case MainMenu.OP_RELATORIOS:
                        //new RelatorioUI(listaRelatorios).executar();
                        break;
                    case MainMenu.OP_SAIR:
                        System.out.println("Aplicação finalizada!!!");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }

            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras!");
            }

        } while (opcao != MainMenu.OP_SAIR);
    }

}

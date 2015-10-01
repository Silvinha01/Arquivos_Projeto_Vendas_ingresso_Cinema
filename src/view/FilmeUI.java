package view;

import java.util.InputMismatchException;
import model.Filme;
import repositorio.RepositorioFilmes;
import util.Console;
import view.menu.FilmeMenu;

/**
 * Essa classe contém os métodos para filmes.
 *
 * @author silvinha01
 */
public class FilmeUI {

    private RepositorioFilmes listaFilmes;

    /**
     * Inicia a classe FilmeUI com seus dados. listaFilmes recebe listaFilmes.
     */
    public FilmeUI(RepositorioFilmes listaFilmes) {
        this.listaFilmes = listaFilmes;
    }

    /**
     * Esse método executar acessa o submenu FilmeMenu e suas opções.
     *
     * @author silvinha01
     */
    public void executar() {
        int opcao = 0;
        do {
            try {
                System.out.println(FilmeMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case FilmeMenu.OP_CADASTRAR:
                        cadastrarFilmes();
                        break;
                    case FilmeMenu.OP_LISTAR:
                        listarFilmes();
                        break;
                    case FilmeMenu.OP_BUSCAR_CODIGO:
                        buscarCodigoFilme();
                        break;
                    case FilmeMenu.OP_BUSCAR_NOME:
                        buscarNomeFilme();
                        break;
                    case FilmeMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != FilmeMenu.OP_VOLTAR);
    }

    /**
     * Esse método cadastra um novo filme na lista de filmes.
     *
     * @author silvinha01
     */
    private void cadastrarFilmes() {
        String nome = Console.scanString("Nome do filme: ");
        if (listaFilmes.buscarFilmePorNome(nome) != null) {
            System.out.println("Filme já existente no cadastro");
        } else {
            String genero = Console.scanString("Gênero: ");
            String sinopse = Console.scanString("Sinopse: ");
            listaFilmes.addFilmes(new Filme(nome, genero, sinopse));
            System.out.println("Filme " + "'" + nome + "'" + " cadastrado com sucesso!");
        }
    }

    /**
     * Esse método lista os filmes cadastrados na lista de filmes.
     *
     * @author silvinha01
     */
    public void listarFilmes() {
        System.out.println("\nLista de Filmes");
        if (!listaFilmes.temFilmes()) {
            System.out.println("Nenhum filme foi cadastrado!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-20s", "|GÊNERO") + "\t"
                    + String.format("%-20s", "|SINOPSE"));
            for (Filme filme : listaFilmes.getListaFilmes()) {
                System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                        + String.format("%-20s", "|" + filme.getNomeFilme()) + "\t"
                        + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                        + String.format("%-20s", "|" + filme.getSinopse()));
            }
        }
    }

    /**
     * Esse método busca um filme pelo código digitado na lista de filmes.
     *
     * @author silvinha01
     */
    public void buscarCodigoFilme() {
        System.out.println("\nBusca de filme por Código");
        int codigo = Console.scanInt("Digite o Código do filme: ");
        if (listaFilmes.existeCodigoFilme(codigo)) {
            Filme filme = listaFilmes.buscarFilmePorCodigo(codigo);

            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-20s", "|GÊNERO") + "\t"
                    + String.format("%-20s", "|SINOPSE"));

            System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + filme.getNomeFilme()) + "\t"
                    + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                    + String.format("%-20s", "|" + filme.getSinopse()));
        } else {
            System.out.println("Este Código não está cadastrado na lista de filmes!");
        }
    }

    /**
     * Esse método busca um filme pelo nome digitado na lista de filmes.
     *
     * @author silvinha01
     */
    public void buscarNomeFilme() {
        System.out.println("\nBusca de filme por Nome");
        String nome = Console.scanString("Digite o Nome do filme: ");
        if (listaFilmes.existeNomeFilme(nome)) {
            Filme filme = listaFilmes.buscarFilmePorNome(nome);

            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "CÓDIGO") + "\t"
                    + String.format("%-20s", "|NOME") + "\t"
                    + String.format("%-20s", "|GÊNERO") + "\t"
                    + String.format("%-20s", "|SINOPSE"));

            System.out.println(String.format("%-10s", filme.getCodigo()) + "\t"
                    + String.format("%-20s", "|" + filme.getNomeFilme()) + "\t"
                    + String.format("%-20s", "|" + filme.getGenero()) + "\t"
                    + String.format("%-20s", "|" + filme.getSinopse()));
        } else {
            System.out.println("Este nome não está cadastrado na lista de filmes!");
        }
    }

}

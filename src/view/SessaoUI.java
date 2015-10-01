package view;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import model.Filme;
import model.Sala;
import model.Sessao;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSessoes;
import util.Console;
import util.DateUtil;
import view.menu.SessaoMenu;

/**
 * Essa classe contém os métodos para sessões.
 *
 * @author silvinha01
 */
public class SessaoUI {

    private RepositorioSalas listaSalas;
    private RepositorioFilmes listaFilmes;
    private RepositorioSessoes listaSessoes;

    /**
     * Inicia a classe SessaoUI com seus dados. listaSalas recebe listaSalas.
     * listaFilmes recebe listaFilmes. listaSessoes recebe listaSessoes.
     */
    public SessaoUI(RepositorioSalas listaSalas, RepositorioFilmes listaFilmes, RepositorioSessoes listaSessoes) {
        this.listaSalas = listaSalas;
        this.listaFilmes = listaFilmes;
        this.listaSessoes = listaSessoes;
    }

    /**
     * Inicia a classe SessaoUI com seus dados. listaSessoes recebe
     * RepositorioSessoes
     */
    public SessaoUI(RepositorioSessoes listaSessoes) {
        this.listaSessoes = listaSessoes;
    }

    /**
     * Esse método executar acessa o submenu SessaoMenu e suas opções.
     *
     * @author silvinha01
     */
    public void executar() throws ParseException {
        int opcao = 0;
        do {
            try {
                System.out.println(SessaoMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case SessaoMenu.OP_CADASTRAR:
                        cadastrarSessao();
                        break;
                    case SessaoMenu.OP_LISTAR:
                        listarSessoes();
                        break;
                    case SessaoMenu.OP_BUSCAR_FILME:
                        buscarSessoesPorFilme();
                        break;
                    case SessaoMenu.OP_BUSCAR_SALA:
                        buscarSessoesPorSala();
                        break;
                    case SessaoMenu.OP_BUSCAR_HORARIO:
                        buscarSessoesPorHorario();
                        break;
                    case SessaoMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != SessaoMenu.OP_VOLTAR);
    }

    /**
     * Esse método cadastra uma nova sessão na lista de sessões.
     *
     * @author silvinha01
     */
    private void cadastrarSessao() {
        //Relaciona as salas:
        System.out.println("\nRelacione a sala abaixo para a sessão: ");
        //Mostra todas as salas cadastradas no repositório de salas. A SalaUI tem uma função exclusiva para mostrar na tela.
        new SalaUI(listaSalas).listarSalas();
        int numero = Console.scanInt("\nDigite o Número da Sala: ");

        if (listaSalas.existeNumeroSala(numero)) {
            Sala sala = listaSalas.buscarSalaPorNumero(numero);
            String hora = Console.scanString("Hora (hh:mm): ");
            Date horario;
            try {
                horario = DateUtil.stringToHour(hora);
                if (listaSessoes.sessaoSalaHorarioOcupados(numero, horario)) {
                    System.out.println("Sala e horário já estão ocupados!");
                } else {
                    //Relaciona os filmes:
                    System.out.println("\nRelacione o filme abaixo para a seção: ");
                    //Mostra todos os filmes cadastrados no repositório de filmes. O FilmeUI tem uma função exclusiva para mostrar na tela.
                    new FilmeUI(listaFilmes).listarFilmes();
                    int codigo = Console.scanInt("\nDigite o Código do filme: ");

                    if (listaFilmes.existeCodigoFilme(codigo)) {
                        Filme filme = listaFilmes.buscarFilmePorCodigo(codigo);

                        //Instancia a sessão
                        Sessao sessao = new Sessao(sala, horario, filme);

                        //Adiciona sessao no repositório
                        listaSessoes.addSecao(sessao);
                        System.out.println("Sessão cadastrada com sucesso!");
                    } else {
                        System.out.println("Filme não encontrado!");
                    }
                }
            } catch (ParseException ex) {
                System.out.println("Hora no formato inválido!");
            }
        } else {
            System.out.println("Sala não encontrada!");
        }
    }

    /**
     * Esse método lista as sessões cadastradas na lista de sessões.
     *
     * @author silvinha01
     */
    public void listarSessoes() {
        System.out.println("\nLista de Sessões");
        if (!listaSessoes.temSessoes()) {
            System.out.println("Nenhuma sessão foi cadastrada!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-15s", "CÓDIGO SESSÃO") + "\t"
                    + String.format("%-10s", "|SALA") + "\t"
                    + String.format("%-10s", "|HORÁRIO") + "\t"
                    + String.format("%-20s", "|FILME"));
            for (Sessao secao : listaSessoes.getListaSessoes()) {
                System.out.println(String.format("%-15s", secao.getCodigo()) + "\t"
                        + String.format("%-10s", "|" + secao.getSala().getNumeroSala()) + "\t"
                        + String.format("%-10s", "|" + DateUtil.hourToString(secao.getHorario())) + "\t"
                        + String.format("%-20s", "|" + secao.getFilme().getNomeFilme()));
            }
        }
    }

    /**
     * Esse método busca uma sessão pelo filme digitado na lista de sessões.
     *
     * @author silvinha01
     */
    private void buscarSessoesPorFilme() {
        System.out.println("\nBusca de Sessão por Filme");
        String nome = Console.scanString("Digite o Nome do filme: ");

        if (listaSessoes.sessaoFilmeExiste(nome)) {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "SALA") + "\t"
                    + String.format("%-10s", "|HORÁRIO") + "\t"
                    + String.format("%-20s", "|FILME"));
            for (Sessao sessao : listaSessoes.getListaSessoesPorFilme(nome)) {
                System.out.println(String.format("%-10s", sessao.getSala().getNumeroSala()) + "\t"
                        + String.format("%-10s", "|" + DateUtil.hourToString(sessao.getHorario())) + "\t"
                        + String.format("%-20s", "|" + sessao.getFilme().getNomeFilme()));
            }
        } else {
            System.out.println("Este filme não está cadastrado ou não será exibido em nenhuma sessão!");
        }
    }

    /**
     * Esse método busca uma sessão pela sala digitada na lista de sessões.
     *
     * @author silvinha01
     */
    private void buscarSessoesPorSala() {
        System.out.println("\nBusca de Sessão por Sala");
        int numero = Console.scanInt("Digite o Número da Sala: ");

        if (listaSessoes.sessaoSalaExiste(numero)) {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "SALA") + "\t"
                    + String.format("%-10s", "|HORÁRIO") + "\t"
                    + String.format("%-20s", "|FILME"));
            for (Sessao sessao : listaSessoes.getListaSessoesPorSala(numero)) {
                System.out.println(String.format("%-10s", sessao.getSala().getNumeroSala()) + "\t"
                        + String.format("%-10s", "|" + DateUtil.hourToString(sessao.getHorario())) + "\t"
                        + String.format("%-20s", "|" + sessao.getFilme().getNomeFilme()));
            }
        } else {
            System.out.println("Esta sala não está cadastrada ou não exibirá nenhuma sessão!");
        }
    }

    /**
     * Esse método busca uma sessão pelo horário digitado na lista de sessões.
     *
     * @author silvinha01
     */
    private void buscarSessoesPorHorario() throws ParseException {
        System.out.println("\nBusca de Sessão por Horário");
        String hora = Console.scanString("Digite o Horário: (hh:mm): ");
        Date horario;
        try {
            horario = DateUtil.stringToHour(hora);

            if (listaSessoes.sessaoHorarioExiste(horario)) {
                System.out.println("-----------------------------\n");
                System.out.println(String.format("%-10s", "SALA") + "\t"
                        + String.format("%-10s", "|HORÁRIO") + "\t"
                        + String.format("%-20s", "|FILME"));
                for (Sessao sessao : listaSessoes.getListaSessoesPorHorario(horario)) {
                    System.out.println(String.format("%-10s", sessao.getSala().getNumeroSala()) + "\t"
                            + String.format("%-10s", "|" + DateUtil.hourToString(sessao.getHorario())) + "\t"
                            + String.format("%-20s", "|" + sessao.getFilme().getNomeFilme()));
                }
            } else {
                System.out.println("Neste Horário não existem sessões cadastradas!");
            }
        } catch (ParseException ex) {
            System.out.println("Hora no formato inválido!");
        }
    }

}

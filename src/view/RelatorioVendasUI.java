package view;

import java.text.ParseException;
import java.util.Date;
import java.util.InputMismatchException;
import model.Venda;
import repositorio.RepositorioVendas;
import util.Console;
import util.DateUtil;
import view.menu.RelatorioVendasMenu;

/**
 * Essa classe contém os métodos para relatórios.
 *
 * @author silvinha01
 */
public class RelatorioVendasUI {

    private RepositorioVendas listaVendas;

    /**
     * Inicia a classe RelatorioUI com seus dados. listaVendas recebe
     * listaVendas.
     */
    public RelatorioVendasUI(RepositorioVendas listaVendas) {
        this.listaVendas = listaVendas;
    }

    /**
     * Esse método executar acessa o submenu RelatorioVendasMenu e suas opções.
     *
     * @author silvinha01
     */
    public void executar() throws ParseException {
        int opcao = 0;
        do {
            try {
                System.out.println(RelatorioVendasMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case RelatorioVendasMenu.OP_LISTAR_VENDAS:
                        listarVendas();
                        break;
                    case RelatorioVendasMenu.OP_VENDAS_FILME:
                        listarVendasPorFilme();
                        break;
                    case RelatorioVendasMenu.OP_VENDAS_HORARIO:
                        listarVendasPorHorario();
                        break;
                    case RelatorioVendasMenu.OP_VENDAS_SALA:
                        listarVendasPorSala();
                        break;
                    case RelatorioVendasMenu.OP_VENDAS_SESSOES:
                        listarVendasPorSessao();
                        break;
                    case RelatorioVendasMenu.OP_VOLTAR:
                        System.out.println("Retornando ao menu principal..");
                        break;
                    default:
                        System.out.println("Opção inválida..");
                }
            } catch (InputMismatchException ime) {
                System.out.println("Opção Inválida! Não pode digitar letras ou caracteres especiais!");
            }
        } while (opcao != RelatorioVendasMenu.OP_VOLTAR);
    }

    /**
     * Esse método lista as vendas cadastradas na lista de vendas.
     *
     * @author silvinha01
     */
    private void listarVendas() {
        System.out.println("\nLista de Vendas");
        if (!listaVendas.temVendas()) {
            System.out.println("Nenhuma venda foi cadastrada!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "CÓDIGO SESSÃO") + "\t"
                    + String.format("%-10s", "|NÚMERO DA SALA") + "\t"
                    + String.format("%-20s", "|QUANTIDADE DE ASSENTOS") + "\t"
                    + String.format("%-10s", "|HORÁRIO") + "\t"
                    + String.format("%-20s", "|FILME"));
            for (Venda venda : listaVendas.getListaVendas()) {
                System.out.println(String.format("%-10s", venda.getSessao().getCodigo()) + "\t"
                        + String.format("%-10s", "|" + venda.getSessao().getSala().getNumeroSala()) + "\t"
                        + String.format("%-20s", "|" + venda.getSessao().getSala().getQtdAssentos()) + "\t"
                        + String.format("%-10s", "|" + DateUtil.hourToString(venda.getSessao().getHorario())) + "\t"
                        + String.format("%-20s", "|" + venda.getSessao().getFilme().getNomeFilme()));
            }
        }
    }

    /**
     * Esse método lista as vendas pelo filme digitado na lista de vendas.
     *
     * @author silvinha01
     */
    private void listarVendasPorFilme() {
        System.out.println("\nBusca de Vendas por Filme");
        String nome = Console.scanString("Digite o Nome do filme: ");

        if (listaVendas.vendasFilmeExiste(nome)) {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-20s", "FILME") + "\t"
                    + String.format("%-15s", "|CÓDIGO SESSÃO") + "\t"
                    + String.format("%-10s", "|NÚMERO DA SALA") + "\t"
                    + String.format("%-20s", "|QUANTIDADE DE ASSENTOS") + "\t"
                    + String.format("%-10s", "|HORÁRIO"));
            for (Venda venda : listaVendas.getListaVendasPorFilme(nome)) {
                System.out.println(String.format("%-20s", venda.getSessao().getFilme().getNomeFilme())
                        + String.format("%-15s", "|" + venda.getSessao().getCodigo()) + "\t"
                        + String.format("%-10s", "|" + venda.getSessao().getSala().getNumeroSala()) + "\t"
                        + String.format("%-20s", "|" + venda.getSessao().getSala().getQtdAssentos()) + "\t"
                        + String.format("%-10s", "|" + DateUtil.hourToString(venda.getSessao().getHorario())));
            }
        } else {
            System.out.println("Este filme não está cadastrado ou não será exibido em nenhuma sessão!");
        }
    }

    /**
     * Esse método lista as vendas pelo horario digitado na lista de vendas.
     *
     * @author silvinha01
     */
    private void listarVendasPorHorario() throws ParseException {
        System.out.println("\nBusca de vendas por Horário");
        String hora = Console.scanString("Digite o Horário: (hh:mm): ");
        Date horario;
        try {
            horario = DateUtil.stringToHour(hora);

            if (listaVendas.vendasHorarioExiste(horario)) {
                System.out.println("-----------------------------\n");
                System.out.println(String.format("%-10s", "HORÁRIO") + "\t"
                        + String.format("%-15s", "|CÓDIGO SESSÃO") + "\t"
                        + String.format("%-10s", "|NÚMERO DA SALA") + "\t"
                        + String.format("%-20s", "|QUANTIDADE DE ASSENTOS") + "\t"
                        + String.format("%-20s", "|FILME"));
                for (Venda venda : listaVendas.getListaVendasPorHorario(horario)) {
                    System.out.println(String.format("%-10s", DateUtil.hourToString(venda.getSessao().getHorario())) + "\t"
                            + String.format("%-15s", "|" + venda.getSessao().getCodigo()) + "\t"
                            + String.format("%-10s", "|" + venda.getSessao().getSala().getNumeroSala()) + "\t"
                            + String.format("%-20s", "|" + venda.getSessao().getSala().getQtdAssentos()) + "\t"
                            + String.format("%-20s", "|" + venda.getSessao().getFilme().getNomeFilme()));
                }
            } else {
                System.out.println("Neste Horário não existem vendas cadastradas!");
            }
        } catch (ParseException ex) {
            System.out.println("Hora no formato inválido!");
        }
    }

    /**
     * Esse método lista as vendas pela sala digitada na lista de vendas.
     *
     * @author silvinha01
     */
    private void listarVendasPorSala() {
        System.out.println("\nBusca de Vendas por Sala");
        int numero = Console.scanInt("Digite o Número da Sala: ");

        if (listaVendas.vendasSalaExiste(numero)) {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "NÚMERO DA SALA") + "\t"
                    + String.format("%-15s", "|CÓDIGO SESSÃO") + "\t"
                    + String.format("%-20s", "|QUANTIDADE DE ASSENTOS") + "\t"
                    + String.format("%-10s", "|HORÁRIO") + "\t"
                    + String.format("%-20s", "|FILME"));
            for (Venda venda : listaVendas.getListaVendasPorSala(numero)) {
                System.out.println(String.format("%-10s", venda.getSessao().getSala().getNumeroSala()) + "\t"
                        + String.format("%-15s", "|" + venda.getSessao().getCodigo()) + "\t"
                        + String.format("%-20s", "|" + venda.getSessao().getSala().getQtdAssentos()) + "\t"
                        + String.format("%-10s", "|" + DateUtil.hourToString(venda.getSessao().getHorario())) + "\t"
                        + String.format("%-20s", "|" + venda.getSessao().getFilme().getNomeFilme()));
            }
        } else {
            System.out.println("Esta sala não está cadastrada ou não realizou nenhuma venda!");
        }
    }

    /**
     * Esse método lista as vendas pela sessão na lista de vendas.
     *
     * @author silvinha01
     */
    private void listarVendasPorSessao() {
        System.out.println("\nLista de Vendas por Sessão");
        int numSessao = Console.scanInt("Digite o Código da Sessão: ");

        if (!listaVendas.temVendas()) {
            System.out.println("Nenhuma venda foi cadastrada!");
        } else {
            if (listaVendas.vendaExiste(numSessao)) {
                System.out.println("-----------------------------\n");
                System.out.println(String.format("%-15s", "CÓDIGO SESSÃO") + "\t"
                        + String.format("%-10s", "|NÚMERO DA SALA") + "\t"
                        + String.format("%-20s", "|QUANTIDADE DE ASSENTOS") + "\t"
                        + String.format("%-10s", "|HORÁRIO") + "\t"
                        + String.format("%-20s", "|FILME"));
                for (Venda venda : listaVendas.getListaVendasPorSessao(numSessao)) {
                    System.out.println(String.format("%-15s", venda.getSessao().getCodigo()) + "\t"
                            + String.format("%-10s", "|" + venda.getSessao().getSala().getNumeroSala()) + "\t"
                            + String.format("%-20s", "|" + venda.getSessao().getSala().getQtdAssentos()) + "\t"
                            + String.format("%-10s", "|" + DateUtil.hourToString(venda.getSessao().getHorario())) + "\t"
                            + String.format("%-20s", "|" + venda.getSessao().getFilme().getNomeFilme()));
                }
            } else {
                System.out.println("Esta sessão não está cadastrada ou não realizou nenhuma venda!");
            }
        }
    }

}

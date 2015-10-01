package view;

import java.util.InputMismatchException;
import model.Sessao;
import model.Venda;
import repositorio.RepositorioSessoes;
import repositorio.RepositorioVendas;
import util.Console;
import util.DateUtil;
import view.menu.SessaoMenu;
import view.menu.VendaMenu;

/**
 * Essa classe contém os métodos para vendas.
 *
 * @author silvinha01
 */
public class VendaUI {

    private RepositorioVendas listaVendas;
    private RepositorioSessoes listaSessoes;

    /**
     * Inicia a classe VendaUI com seus dados. listaVendas recebe listaVendas.
     * listaSessoes recebe listaSessoes.
     */
    public VendaUI(RepositorioVendas listaVendas, RepositorioSessoes listaSessoes) {
        this.listaVendas = listaVendas;
        this.listaSessoes = listaSessoes;
    }

    /**
     * Esse método executar acessa o submenu VendaMenu e suas opções.
     *
     * @author silvinha01
     */
    public void executar() {
        int opcao = 0;
        do {
            try {
                System.out.println(VendaMenu.getOpcoes());
                opcao = Console.scanInt("Digite sua opção: ");
                switch (opcao) {
                    case VendaMenu.OP_CADASTRAR:
                        cadastrarVendas();
                        break;
                    case VendaMenu.OP_LISTAR:
                        listarVendas();
                        break;
                    case VendaMenu.OP_VOLTAR:
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
     * Esse método cadastra uma nova venda na lista de vendas.
     *
     * @author silvinha01
     */
    private void cadastrarVendas() {
        //Relaciona as sessões:
        System.out.println("\nRelacione a sessão abaixo para efetuar a venda: ");
        //Mostra todas as sessões cadastradas no repositório de sessões. A SessãoUI tem uma função exclusiva para mostrar na tela.
        new SessaoUI(listaSessoes).listarSessoes();
        int codigo = Console.scanInt("\nDigite o Código da sessão: ");

        if (listaSessoes.sessaoExiste(codigo)) {
            Sessao sessao = listaSessoes.buscarSessaoPorCodigo(codigo);

            int qtdIngressos = Console.scanInt("\nDigite a quantidade de ingressos que irá comprar: ");
            if ((listaVendas.ingressosVendidosPorSessao(codigo) + qtdIngressos) > sessao.getSala().getQtdAssentos()) {
                System.out.println("Esta sessão está com lotação esgotada ou a quantidade de ingressos disponíveis é inferior à solicitação!");
            } else {

                //Instancia a venda
                Venda venda = new Venda(sessao, qtdIngressos);
                System.out.println("Quantidade de ingressos disponíveis para venda: " + qtdIngressos);

                //Adiciona venda no repositório
                listaVendas.addVenda(venda);
                System.out.println("Venda cadastrada com sucesso!");
            }
        } else {
            System.out.println("Código da sessão não encontrado!");
        }
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

}

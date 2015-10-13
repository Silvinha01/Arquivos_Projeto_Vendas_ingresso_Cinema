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
                System.out.println("A quantidade de ingressos disponíveis é inferior à solicitação!");

                System.out.println("Ingressos disponíveis para venda: " + (sessao.getSala().getQtdAssentos() - listaVendas.ingressosVendidosPorSessao(codigo)));
            } else {

                //Instancia a venda
                Venda venda = new Venda(sessao, qtdIngressos);

                //Adiciona venda no repositório
                listaVendas.addVenda(venda);
                System.out.println("Venda cadastrada com sucesso!");
                if ((listaVendas.ingressosVendidosPorSessao(codigo)) == sessao.getSala().getQtdAssentos()) {
                    System.out.println("Esta sessão está com lotação esgotada!");
                }
            }
        } else {
            System.out.println("Código da sessão não encontrado!");
        }
    }

}

package view;

import java.text.ParseException;
import java.util.Date;
import model.Filme;
import model.Sala;
import model.Secao;
import repositorio.RepositorioFilmes;
import repositorio.RepositorioSalas;
import repositorio.RepositorioSecoes;
import util.Console;
import util.DateUtil;
import view.menu.SecaoMenu;

/**
 *
 * @author silvinha01
 */
public class SecaoUI {

    private RepositorioSalas listaSalas;
    private RepositorioFilmes listaFilmes;
    private RepositorioSecoes listaSecoes;

    public SecaoUI(RepositorioSalas listaSalas, RepositorioFilmes listaFilmes, RepositorioSecoes listaSecoes) {
        this.listaSalas = listaSalas;
        this.listaFilmes = listaFilmes;
        this.listaSecoes = listaSecoes;
    }

    public void executar() {
        int opcao = 0;
        do {
            System.out.println(SecaoMenu.getOpcoes());
            opcao = Console.scanInt("Digite sua opção: ");
            switch (opcao) {
                case SecaoMenu.OP_CADASTRAR:
                    cadastrarSecao();
                    break;
                case SecaoMenu.OP_LISTAR:
                    listarSecoes();
                    break;
                case SecaoMenu.OP_BUSCAR_FILME:
                    buscarSecoesPorFilme();
                    break;
                case SecaoMenu.OP_BUSCAR_SALA:
                    buscarSecoesPorSala();
                    break;
                case SecaoMenu.OP_BUSCAR_HORA:
                    buscarSecoesPorHora();
                    break;
                case SecaoMenu.OP_VOLTAR:
                    System.out.println("Retornando ao menu principal..");
                    break;
                default:
                    System.out.println("Opção inválida..");

            }
        } while (opcao != SecaoMenu.OP_VOLTAR);
    }

    private void cadastrarSecao() {
        //Relaciona as salas:
        System.out.println("\nRelacione a sala abaixo para a seção: ");
        //Mostra todas as salas cadastradas no repositório de salas. A SalaUI tem uma função exclusiva para mostrar na tela.
        new SalaUI(listaSalas).listarSalas();
        int numero = Console.scanInt("\nEscolha o Número da sala: ");

        if (listaSalas.existeNumeroSala(numero)) {
            Sala sala = listaSalas.buscarSalaPorNumero(numero);
            String hora = Console.scanString("Hora (hh:mm): ");
            Date horario;
            try {
                horario = DateUtil.stringToDateHour(hora);

                //Relaciona os filmes:
                System.out.println("\nRelacione o filme abaixo para a seção: ");
                //Mostra todos os filmes cadastrados no repositório de filmes. O FilmeUI tem uma função exclusiva para mostrar na tela.
                new FilmeUI(listaFilmes).listarFilmes();
                int codigo = Console.scanInt("\nEscolha o Código do filme: ");

                if (listaFilmes.existeCodigoFilme(codigo)) {
                    Filme filme = listaFilmes.buscarFilmePorCodigo(codigo);

                    //Instancia a secao
                    Secao secao = new Secao(sala, horario, filme);

                    //Adiciona secao no repositório
                    listaSecoes.addSecao(secao);
                    System.out.println("Seção cadastrada com sucesso!");

                } else {
                    System.out.println("Filme não encontrado!");
                }
            } catch (ParseException ex) {
                System.out.println("Hora no formato inválido!");
            }
        } else {
            System.out.println("Sala não encontrada!");
        }

    }

    private void listarSecoes() {
        System.out.println("\nLista de Seções");
        if (!listaSecoes.temSecoes()) {
            System.out.println("Nenhuma seção foi cadastrada!");
        } else {
            System.out.println("-----------------------------\n");
            System.out.println(String.format("%-10s", "SALA") + "\t"
                    + String.format("%-10s", "|HORÁRIO") + "\t"
                    + String.format("%-20s", "|FILME"));
            for (Secao secao : listaSecoes.getListaSecoes()) {
                System.out.println(String.format("%-10s", secao.getSala()) + "\t"
                        + String.format("%-10s", "|" + secao.getHorario()) + "\t"
                        + String.format("%-20s", "|" + secao.getFilme()));
            }
        }
    }

    private void buscarSecoesPorFilme() {

    }

    private void buscarSecoesPorSala() {

    }

    private void buscarSecoesPorHora() {

    }

}

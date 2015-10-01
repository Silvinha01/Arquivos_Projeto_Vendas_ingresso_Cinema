package view.menu;

/**
 * Essa classe RelatorioMenu acessa as opções do submenu.
 *
 * @author silvinha01
 */
public class RelatorioMenu {

    public static final int OP_VENDAS_FILME = 1;
    public static final int OP_VENDAS_HORARIO = 2;
    public static final int OP_VENDAS_SALA = 3;
    public static final int OP_VENDAS_SESSOES = 4;
    public static final int OP_FILMES_MAIS_SESSOES = 5;
    public static final int OP_SALAS_MAIS_UTILIZADAS = 6;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Relatório de vendas por Filme\n"
                + "2 - Relatório de vendas por Horário\n"
                + "3 - Relatório de vendas por Sala\n"
                + "4 - Relatório de vendas por Sessão\n"
                + "5 - Relatório de filmes que estiveram em mais sessões\n"
                + "6 - Relatório de salas mais utilizadas\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }
}

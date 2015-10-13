package view.menu;

/**
 * Essa classe RelatorioVendasMenu acessa as opções do submenu.
 *
 * @author silvinha01
 */
public class RelatorioVendasMenu {

    public static final int OP_LISTAR_VENDAS = 1;
    public static final int OP_VENDAS_FILME = 2;
    public static final int OP_VENDAS_HORARIO = 3;
    public static final int OP_VENDAS_SALA = 4;
    public static final int OP_VENDAS_SESSOES = 5;    
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Listar Vendas\n"
                + "2 - Buscar vendas por Filme\n"
                + "3 - Buscar vendas por Horário\n"
                + "4 - Buscar vendas por Sala\n"
                + "5 - Buscar vendas por Sessão\n"               
                + "0 - Voltar"
                + "\n--------------------------------------");
    }
}

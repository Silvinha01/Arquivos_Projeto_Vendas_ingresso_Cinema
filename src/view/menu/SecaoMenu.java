package view.menu;
/**
 *
 * @author silvinha01
 */
public class SecaoMenu {
    
    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_BUSCAR_FILME = 3;
    public static final int OP_BUSCAR_SALA = 4;
    public static final int OP_BUSCAR_HORA = 5;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Cadastrar Seções\n"
                + "2 - Listar Seções\n"
                + "3 - Buscar Seção por Filme\n"
                + "4 - Buscar Seção por Sala\n"
                + "5 - Buscar Seção por Hora\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }
    
}

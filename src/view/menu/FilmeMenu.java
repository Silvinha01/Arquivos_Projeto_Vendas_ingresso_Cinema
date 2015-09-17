package view.menu;

/**
 *
 * @author silvinha01
 */
public class FilmeMenu {

    public static final int OP_CADASTRAR = 1;
    public static final int OP_LISTAR = 2;
    public static final int OP_BUSCAR_CODIGO = 3;
    public static final int OP_BUSCAR_NOME = 4;
    public static final int OP_VOLTAR = 0;

    public static String getOpcoes() {
        return ("\n--------------------------------------\n"
                + "1 - Cadastrar Filmes\n"
                + "2 - Listar Filmes\n"
                + "3 - Buscar Filme por Código\n"
                + "4 - Buscar Filme por Nome\n"
                + "0 - Voltar"
                + "\n--------------------------------------");
    }

}

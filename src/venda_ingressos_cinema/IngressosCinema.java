package venda_ingressos_cinema;

import java.text.ParseException;
import view.MainUI;

/**
 *
 * @author silvinha01
 */
public class IngressosCinema {

    /**
     * Inicia a classe static void main
     *
     * @param args
     * @throws java.text.ParseException Executa a view mainUI que irá acessar
     * MainMenu
     */
    public static void main(String[] args) throws ParseException {
        new MainUI().executar();
    }

}

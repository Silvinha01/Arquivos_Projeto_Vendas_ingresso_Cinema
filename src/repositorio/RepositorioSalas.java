package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Sala;

/**
 * Essa classe contém os repositórios para salas.
 *
 * @author silvinha01
 */
public class RepositorioSalas {

    private List<Sala> listaSalas;

    /**
     * Inicia o repositório salas com seus dados. listaSalas recebe ArrayList
     */
    public RepositorioSalas() {
        listaSalas = new ArrayList<Sala>();
    }

    /**
     * Esse método adiciona sala na lista de salas.
     *
     * @author silvinha01
     */
    public boolean addSalas(Sala sala) {
        return (listaSalas.add(sala));
    }

    /**
     * Esse método mostra lista de salas.
     *
     * @author silvinha01
     */
    public List<Sala> getListaSalas() {
        return listaSalas;
    }

    /**
     * Esse método verifica se existe um número especifico na lista de salas.
     *
     * @author silvinha01
     */
    public boolean existeNumeroSala(int numero) {
        for (Sala sala : listaSalas) {
            if (sala.getNumeroSala() == numero) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca um número na lista de salas e retorna uma sala.
     *
     * @author silvinha01
     */
    public Sala buscarSalaPorNumero(int numero) {
        for (Sala sala : listaSalas) {
            if (sala.getNumeroSala() == numero) {
                return sala;
            }
        }
        return null;
    }

    /**
     * Esse método verifica se existem salas na lista de salas.
     *
     * @author silvinha01
     */
    public boolean temSalas() {
        return !listaSalas.isEmpty();
    }

}

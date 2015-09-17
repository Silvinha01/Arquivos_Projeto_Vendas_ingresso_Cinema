package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Sala;

/**
 *
 * @author silvinha01
 */
public class RepositorioSalas {

    private List<Sala> listaSalas;

    public RepositorioSalas() {
        listaSalas = new ArrayList<Sala>();
    }

    public boolean addSalas(Sala sala) {
        return (listaSalas.add(sala));
    }

    public List<Sala> getListaSalas() {
        return listaSalas;
    }

    public boolean existeNumeroSala(int numero) {
        for (Sala sala : listaSalas) {
            if (sala.getNumeroSala() == numero) {
                return true;
            }
        }
        return false;
    }

    public Sala buscarSalaPorNumero(int numero) {
        for (Sala sala : listaSalas) {
            if (sala.getNumeroSala() == numero) {
                return sala;
            }
        }
        return null;
    }

    public boolean temSalas() {
        return !listaSalas.isEmpty();
    }

}

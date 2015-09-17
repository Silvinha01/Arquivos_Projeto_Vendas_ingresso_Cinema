package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

/**
 *
 * @author silvinha01
 */
public class RepositorioFilmes {

    private List<Filme> listaFilmes;

    public RepositorioFilmes() {
        listaFilmes = new ArrayList<Filme>();
    }

    public boolean addFilmes(Filme filme) {
        return (listaFilmes.add(filme));
    }

    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    public boolean existeCodigoFilme(int codigo) {
        for (Filme filme : listaFilmes) {
            if (filme.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    public Filme buscarFilmePorCodigo(int codigo) {
        for (Filme filme : listaFilmes) {
            if (filme.getCodigo() == codigo) {
                return filme;
            }
        }
        return null;
    }

    public boolean existeNomeFilme(String nome) {
        if (this.buscarFilmePorNome(nome) != null) {
            return true;
        } else {
            return false;
        }
    }

    public Filme buscarFilmePorNome(String nome) {
        for (Filme filme : listaFilmes) {
            if (filme.getNomeFilme().toLowerCase().contains(nome)) {
                return filme;
            }else if (filme.getNomeFilme().toUpperCase().contains(nome)) {
                return filme;
            }
        }
        return null;
    }

    public boolean temFilmes() {
        return !listaFilmes.isEmpty();
    }
}

package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Filme;

/**
 * Essa classe contém os repositórios para filmes.
 *
 * @author silvinha01
 */
public class RepositorioFilmes {

    private List<Filme> listaFilmes;

    /**
     * Inicia o repositório filmes com seus dados. listaFilmes recebe ArrayList
     */
    public RepositorioFilmes() {
        listaFilmes = new ArrayList<Filme>();
    }

    /**
     * Esse método adiciona filme na lista de filmes.
     *
     * @author silvinha01
     */
    public boolean addFilmes(Filme filme) {
        return (listaFilmes.add(filme));
    }

    /**
     * Esse método mostra lista de filmes.
     *
     * @author silvinha01
     */
    public List<Filme> getListaFilmes() {
        return listaFilmes;
    }

    /**
     * Esse método verifica se existe um código especifico na lista de filmes.
     *
     * @author silvinha01
     */
    public boolean existeCodigoFilme(int codigo) {
        for (Filme filme : listaFilmes) {
            if (filme.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca um código na lista de filmes e retorna um filme.
     *
     * @author silvinha01
     */
    public Filme buscarFilmePorCodigo(int codigo) {
        for (Filme filme : listaFilmes) {
            if (filme.getCodigo() == codigo) {
                return filme;
            }
        }
        return null;
    }

    /**
     * Esse método verifica se existe um nome específico na lista de filmes.
     *
     * @author silvinha01
     */
    public boolean existeNomeFilme(String nome) {
        if (this.buscarFilmePorNome(nome) != null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Esse método busca um nome na lista de filmes e retorna um filme.
     *
     * @author silvinha01
     */
    public Filme buscarFilmePorNome(String nome) {
        for (Filme filme : listaFilmes) {
            if (filme.getNomeFilme().toLowerCase().contains(nome)) {
                return filme;
            } else if (filme.getNomeFilme().toUpperCase().contains(nome)) {
                return filme;
            }
        }
        return null;
    }

    /**
     * Esse método verifica se existem filmes na lista de filmes.
     *
     * @author silvinha01
     */
    public boolean temFilmes() {
        return !listaFilmes.isEmpty();
    }
}

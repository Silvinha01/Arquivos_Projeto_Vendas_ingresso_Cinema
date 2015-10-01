package repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Sessao;

/**
 * Essa classe contém os repositórios para sessões.
 *
 * @author silvinha01
 */
public class RepositorioSessoes {

    private List<Sessao> listaSessoes;

    /**
     * Inicia o repositório sessões com seus dados. listaSessoes recebe
     * ArrayList.
     */
    public RepositorioSessoes() {
        listaSessoes = new ArrayList<Sessao>();
    }

    /**
     * Esse método adiciona sessão na lista de sessões.
     *
     * @author silvinha01
     */
    public boolean addSecao(Sessao sessao) {
        return (listaSessoes.add(sessao));
    }

    /**
     * Esse método mostra lista de sessões.
     *
     * @author silvinha01
     */
    public List<Sessao> getListaSessoes() {
        return listaSessoes;
    }

    /**
     * Esse método mostra lista de sessões por filme.
     *
     * @author silvinha01
     */
    public List<Sessao> getListaSessoesPorFilme(String nome) {
        List<Sessao> sessoesPorFilme = new ArrayList<Sessao>();
        for (Sessao sessao : listaSessoes) {
            if (sessao.getFilme().getNomeFilme().equals(nome)) {
                sessoesPorFilme.add(sessao);
            }
        }
        return (sessoesPorFilme);
    }

    /**
     * Esse método mostra lista de sessões por sala.
     *
     * @author silvinha01
     */
    public List<Sessao> getListaSessoesPorSala(int numero) {
        List<Sessao> sessoesPorSala = new ArrayList<Sessao>();
        for (Sessao sessao : listaSessoes) {
            if (sessao.getSala().getNumeroSala() == numero) {
                sessoesPorSala.add(sessao);
            }
        }
        return (sessoesPorSala);
    }

    /**
     * Esse método mostra lista de sessões por horário.
     *
     * @author silvinha01
     */
    public List<Sessao> getListaSessoesPorHorario(Date horario) {
        List<Sessao> sessoesPorHorario = new ArrayList<Sessao>();
        for (Sessao sessao : listaSessoes) {
            if (sessao.getHorario().equals(horario)) {
                sessoesPorHorario.add(sessao);
            }
        }
        return (sessoesPorHorario);
    }

    /**
     * Esse método verifica se existe um código especifico na lista de sessões.
     *
     * @author silvinha01
     */
    public boolean sessaoExiste(int codigo) {
        for (Sessao sessao : listaSessoes) {
            if (sessao.getCodigo() == codigo) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca um código na lista de sessões e retorna uma sessão.
     *
     * @author silvinha01
     */
    public Sessao buscarSessaoPorCodigo(int codigo) {
        for (Sessao sessao : listaSessoes) {
            if (sessao.getCodigo() == codigo) {
                return sessao;
            }
        }
        return null;
    }

    /**
     * Esse método verifica se uma determinada sala e um determinado horário
     * estão ocupados na lista de sessões.
     *
     * @author silvinha01
     */
    public boolean sessaoSalaHorarioOcupados(int numero, Date horario) {
        for (Sessao sessao : listaSessoes) {
            if ((sessao.getHorario().equals(horario)) && (sessao.getSala().getNumeroSala() == numero)) {
                return true;
            }
        }
        return false;
    }    

    /**
     * Esse método verifica se existe uma sessão com um filme especifico na
     * lista de sessões.
     *
     * @author silvinha01
     */
    public boolean sessaoFilmeExiste(String nome) {
        for (Sessao sessao : listaSessoes) {
            if (sessao.getFilme().getNomeFilme().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca um filme na lista de sessões e retorna uma sessão.
     *
     * @author silvinha01
     */
    public List<Sessao> buscarSessaoPorFilme(String nome) {
        List<Sessao> sessoes = new ArrayList<Sessao>();
        for (Sessao sessao : listaSessoes) {
            if (sessao.getFilme().getNomeFilme().equals(nome)) {
                sessoes.add(sessao);
            }
        }
        return (sessoes);
    }

    /**
     * Esse método verifica se existe uma sessão em uma sala especifica na lista
     * de sessões.
     *
     * @author silvinha01
     */
    public boolean sessaoSalaExiste(int numero) {
        for (Sessao sessao : listaSessoes) {
            if (sessao.getSala().getNumeroSala() == numero) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca uma sala na lista de sessões e retorna uma sessão.
     *
     * @author silvinha01
     */
    public List<Sessao> buscarSessoesPorSala(int numero) {
        List<Sessao> sessoes = new ArrayList<>();
        for (Sessao sessao : listaSessoes) {
            if (sessao.getSala().getNumeroSala() == numero) {
                sessoes.add(sessao);
            }
        }
        return sessoes;
    }

    /**
     * Esse método verifica se existe uma sessão em um horário especifico na
     * lista de sessões.
     *
     * @author silvinha01
     */
    public boolean sessaoHorarioExiste(Date horario) {
        for (Sessao sessao : listaSessoes) {
            if (sessao.getHorario().equals(horario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca um horário na lista de sessões e retorna uma sessão.
     *
     * @author silvinha01
     */
    public List<Sessao> buscarSessoesPorHorario(Date horario) {
        List<Sessao> sessoes = new ArrayList<>();
        for (Sessao sessao : listaSessoes) {
            if (sessao.getHorario().equals(horario)) {
                sessoes.add(sessao);
            }
        }
        return sessoes;
    }

    /**
     * Esse método verifica se existem sessões na lista de sessões.
     *
     * @author silvinha01
     */
    public boolean temSessoes() {
        return !listaSessoes.isEmpty();
    }

}

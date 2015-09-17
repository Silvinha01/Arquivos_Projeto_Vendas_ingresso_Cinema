package repositorio;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import model.Secao;

/**
 *
 * @author silvinha01
 */
public class RepositorioSecoes {

    private List<Secao> listaSecoes;

    public RepositorioSecoes() {
        listaSecoes = new ArrayList<Secao>();
    }

    public boolean addSecao(Secao secao) {
        return (listaSecoes.add(secao));
    }

    public List<Secao> getListaSecoes() {
        return listaSecoes;
    }

    public List<Secao> getListaSecoesPorFilme(String nome) {
        List<Secao> secoesPorFilme = new ArrayList<Secao>();
        for (Secao secao : listaSecoes) {
            if (secao.getFilme().getNomeFilme().equals(nome)) {
                secoesPorFilme.add(secao);
            }
        }
        return (secoesPorFilme);
    }

    public List<Secao> getListaSecoesPorSala(int numero) {
        List<Secao> secoesPorSala = new ArrayList<Secao>();
        for (Secao secao : listaSecoes) {
            if (secao.getSala().getNumeroSala() == numero) {
                secoesPorSala.add(secao);
            }
        }
        return (secoesPorSala);
    }

    public List<Secao> getListaSecaoPorHora(int minuto, int hora) {
        List<Secao> secoesPorHora = new ArrayList<Secao>();
        Calendar calendario = Calendar.getInstance();

        for (Secao secao : listaSecoes) {
            calendario.setTime(secao.getHorario());
            if (calendario.get(Calendar.MINUTE) == (minuto)
                    && calendario.get(Calendar.HOUR) == hora) {
                secoesPorHora.add(secao);
            }
        }
        return (secoesPorHora);
    }

    public boolean secaoExiste(Date horario) {
        for (Secao secao : listaSecoes) {
            if (secao.getHorario() == horario) {
                return true;
            }
        }
        return false;
    }

    public List<Secao> buscarSecaoPorFilme(String nome) {
        List<Secao> secoes = new ArrayList<Secao>();
        for (Secao secao : listaSecoes) {
            if (secao.getFilme().getNomeFilme().equals(nome)) {
                secoes.add(secao);
            }
        }
        return (secoes);
    }

    public List<Secao> buscarSecoesPorSala(int numero) {
        List<Secao> secoes = new ArrayList<>();
        for (Secao secao : listaSecoes) {
            if (secao.getSala().getNumeroSala() == numero) {
                secoes.add(secao);
            }
        }
        return secoes;
    }

    public List<Secao> buscarSecoesPorHora(int minuto, int hora) {
        List<Secao> secoes = new ArrayList<>();
        Calendar calendario = Calendar.getInstance();

        for (Secao secao : listaSecoes) {
            if (calendario.get(Calendar.MINUTE) == (minuto)
                    && calendario.get(Calendar.HOUR) == hora) {
                secoes.add(secao);
            }
        }
        return (secoes);
    }

    public boolean temSecoes() {
        return !listaSecoes.isEmpty();
    }

}

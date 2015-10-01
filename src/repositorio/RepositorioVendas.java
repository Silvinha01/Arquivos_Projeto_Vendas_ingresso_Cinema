package repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Sessao;
import model.Venda;

/**
 * Essa classe contém os repositórios para vendas.
 *
 * @author silvinha01
 */
public class RepositorioVendas {

    private List<Venda> listaVendas;

    /**
     * Inicia o repositório vendas com seus dados. listaVendas recebe ArrayList.
     */
    public RepositorioVendas() {
        listaVendas = new ArrayList<Venda>();

    }

    /**
     * Esse método adiciona venda na lista de vendas.
     *
     * @author silvinha01
     */
    public boolean addVenda(Venda venda) {
        return (listaVendas.add(venda));
    }

    /**
     * Esse método mostra lista de vendas.
     *
     * @author silvinha01
     */
    public List<Venda> getListaVendas() {
        return listaVendas;
    }

    /**
     * Esse método verifica se existe uma sessão especifica na lista de vendas.
     *
     * @author silvinha01
     */
    public boolean vendaExiste(int codSessao) {
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getCodigo() == codSessao) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método mostra lista de vendas por filme.
     *
     * @author silvinha01
     */
    public List<Venda> getListaVendasPorFilme(String nome) {
        List<Venda> vendasPorFilme = new ArrayList<Venda>();
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getFilme().getNomeFilme().equals(nome)) {
                vendasPorFilme.add(venda);
            }
        }
        return (vendasPorFilme);
    }

    /**
     * Esse método verifica se existe uma venda com um filme especifico na lista
     * de vendas.
     *
     * @author silvinha01
     */
    public boolean vendaFilmeExiste(String nome) {
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getFilme().getNomeFilme().equals(nome)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca um filme na lista de vendas e retorna um ArrayList de
     * vendas.
     *
     * @author silvinha01
     */
    public List<Venda> buscarVendaPorFilme(String nome) {
        List<Venda> vendas = new ArrayList<Venda>();
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getFilme().getNomeFilme().equals(nome)) {
                vendas.add(venda);
            }
        }
        return (vendas);
    }

    /**
     * Esse método mostra lista de vendas por horário.
     *
     * @author silvinha01
     */
    public List<Venda> getListaVendasPorHorario(Date horario) {
        List<Venda> vendas = new ArrayList<>();
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getHorario().equals(horario)) {
                vendas.add(venda);
            }
        }
        return vendas;
    }

    /**
     * Esse método verifica se existe uma venda com um horário especifico na
     * lista de vendas.
     *
     * @author silvinha01
     */
    public boolean vendaHorarioExiste(Date horario) {
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getHorario().equals(horario)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca um horário na lista de vendas e retorna um ArrayList de
     * vendas.
     *
     * @author silvinha01
     */
    public List<Venda> buscarVendaPorHorario(Date horario) {
        List<Venda> vendas = new ArrayList<Venda>();
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getHorario().equals(horario)) {
                vendas.add(venda);
            }
        }
        return (vendas);
    }

    /**
     * Esse método mostra lista de vendas por sala.
     *
     * @author silvinha01
     */
    public List<Venda> getListaVendasPorSala(int numero) {
        List<Venda> vendasPorSala = new ArrayList<Venda>();
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getSala().getNumeroSala() == numero) {
                vendasPorSala.add(venda);
            }
        }
        return (vendasPorSala);
    }

    /**
     * Esse método verifica se existe uma venda em uma sala especifica na lista
     * de vendas.
     *
     * @author silvinha01
     */
    public boolean vendaSalaExiste(int numero) {
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getSala().getNumeroSala() == numero) {
                return true;
            }
        }
        return false;
    }

    /**
     * Esse método busca uma sala na lista de vendas e retorna um ArrayList de
     * vendas.
     *
     * @author silvinha01
     */
    public List<Venda> buscarVendasPorSala(int numero) {
        List<Venda> vendas = new ArrayList<>();
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getSala().getNumeroSala() == numero) {
                vendas.add(venda);
            }
        }
        return vendas;
    }

    /**
     * Esse método busca uma sessão na lista de vendas e retorna vendas.
     *
     * @author silvinha01
     */
    public List<Venda> buscarVendasPorSessao(int codSessao) {
        List<Venda> listaNova = new ArrayList<Venda>();
        for (Venda venda : listaVendas) {
            if (venda.getSessao().getCodigo() == codSessao) {
                listaNova.add(venda);
            }
        }
        return listaNova;
    }

    /**
     * Esse método efetua o somatório da quantidade de ingressos vendidos por
     * sessão.
     *
     * @author silvinha01
     */
    public int ingressosVendidosPorSessao(int codSessao) {
        int ingressosVendidos = 0;
        for (Venda venda : buscarVendasPorSessao(codSessao)) {
            ingressosVendidos += venda.getQtdIngressosPorVenda();
        }
        return ingressosVendidos;
    }

    /**
     * Esse método verifica se existem vendas na lista de vendas.
     *
     * @author silvinha01
     */
    public boolean temVendas() {
        return !listaVendas.isEmpty();
    }

}

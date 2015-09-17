package repositorio;

import java.util.ArrayList;
import java.util.List;
import model.Venda;

/**
 *
 * @author silvinha01
 */
public class RepositorioVendas {

    private List<Venda> listaVendas;

    public RepositorioVendas() {
        listaVendas = new ArrayList<Venda>();
    }

    public boolean addVenda(Venda venda) {
        return (listaVendas.add(venda));
    }

    public List<Venda> getListaVendas() {
        return listaVendas;
    }

}

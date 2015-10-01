package model;

/**
 *
 * @author silvinha01
 */
public class Venda {

    private Sessao sessao;
    private int qtdIngressosPorVenda;

    /**
     * Inicia o objeto venda com seus dados.
     *
     * @param sessao Objeto Sessao voltado para especificar a sessão de uma
     * venda.
     * @param qtdIngressosPorVenda inteiro que referencia o atributo quantidade
     * de ingressos por venda.
     */
    public Venda(Sessao sessao, int qtdIngressosPorVenda) {
        this.sessao = sessao;
        this.qtdIngressosPorVenda = qtdIngressosPorVenda;
    }

    /**
     * Retorna a sessão de uma venda
     *
     * @return objeto sessão da venda
     */
    public Sessao getSessao() {
        return sessao;
    }

    /**
     * Retorna a quantidade de ingressos por venda de uma venda.
     *
     * @return int qtdIngressosPorVenda
     */
    public int getQtdIngressosPorVenda() {
        return qtdIngressosPorVenda;
    }

}

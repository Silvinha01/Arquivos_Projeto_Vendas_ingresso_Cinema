package model;

/**
 * Essa classe serve para trabalhar com o objeto sala. Trabalha com informações:
 * númeroSala, qtdAssentos.
 *
 *
 * @author silvinha01
 */
public class Sala {

    private int numeroSala;
    private int qtdAssentos;

    /**
     * Inicia o objeto sala com seus dados.
     *
     * @param numeroSala Inteiro que referencia o atributo número da sala.
     * @param qtdAssentos Inteiro que referencia o atributo quantidade de
     * assentos.
     */
    public Sala(int numeroSala, int qtdAssentos) {
        this.numeroSala = numeroSala;
        this.qtdAssentos = qtdAssentos;
    }

    /**
     * Retorna o número de uma sala.
     *
     * @return int numeroSala.
     */
    public int getNumeroSala() {
        return numeroSala;
    }

    /**
     * Altera o número de uma sala.
     *
     * @param numeroSala String numeroSala.
     */
    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    /**
     * Retorna a quantidade de assentos de uma sala.
     *
     * @return int qtdAssentos.
     */
    public int getQtdAssentos() {
        return qtdAssentos;
    }

    /**
     * Altera a quantidade de assentos de uma sala.
     *
     * @param qtdAssentos int qtdAssentos.
     */
    public void setQtdAssentos(int qtdAssentos) {
        this.qtdAssentos = qtdAssentos;
    }
}

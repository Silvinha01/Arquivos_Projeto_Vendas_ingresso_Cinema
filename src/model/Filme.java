package model;

/**
 * Essa classe serve para trabalhar com o objeto filme. Trabalha com
 * informações: código, nomeFilme, genero e sinopse.
 *
 * @author silvinha01
 */
public class Filme {

    private static int CODIGO_GERADO = 1;
    private int codigo;
    private String nomeFilme;
    private String genero;
    private String sinopse;

    /**
     * Inicia o objeto filme com seus dados.
     *
     * @codigo Cóigo voltado para receber o código gerado do filme.
     * @param nomeFilme String que referencia o atributo nome do filme.
     * @param genero String que referencia o atributo genero do filme.
     * @param sinopse String que referencia o atributo sinopse do filme.
     */
    public Filme(String nomeFilme, String genero, String sinopse) {
        this.codigo = generateCodigo();
        this.nomeFilme = nomeFilme;
        this.genero = genero;
        this.sinopse = sinopse;
    }

    /**
     * Retorna o código de um filme.
     *
     * @return código de um filme.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna o nome de um filme.
     *
     * @return String nomeFilme.
     */
    public String getNomeFilme() {
        return nomeFilme;
    }

    /**
     * Altera o nome de um filme.
     *
     * @param nomeFilme String nomeFilme.
     */
    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    /**
     * Retorna o gênero de um filme.
     *
     * @return String genero.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Altera o gênero de um filme.
     *
     * @param genero String genero.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Retorna a sinopse de um filme.
     *
     * @return String sinopse.
     */
    public String getSinopse() {
        return sinopse;
    }

    /**
     * Altera a sinopse de um filme.
     *
     * @param sinopse String sinopse.
     */
    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }

    /**
     * Gerador de código.
     *
     * @return Código gerado + 1.
     */
    private int generateCodigo() {
        return (CODIGO_GERADO++);
    }

}

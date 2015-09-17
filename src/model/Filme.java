package model;
/**
 * Essa classe serve para trabalhar com o objeto filme.
 * Trabalha com informações: código, nomeFilme, genero e sinopse. 
 * @author silvinha01
 */
public class Filme {
    
    private static int CODIGO_GERADO = 1;
    private int codigo;
    private String nomeFilme;
    private String genero;
    private String sinopse;

    public Filme(String nomeFilme, String genero, String sinopse) {
        this.codigo = generateCodigo();
        this.nomeFilme = nomeFilme;
        this.genero = genero;
        this.sinopse = sinopse;
    }
   
    public int getCodigo() {
        return codigo;
    }    
    /**
     * 
     * @return 
     */
    public String getNomeFilme() {
        return nomeFilme;
    }

    public void setNomeFilme(String nomeFilme) {
        this.nomeFilme = nomeFilme;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getSinopse() {
        return sinopse;
    }

    public void setSinopse(String sinopse) {
        this.sinopse = sinopse;
    }    
    
    private int generateCodigo() {
        return (CODIGO_GERADO++);
    }
    
}

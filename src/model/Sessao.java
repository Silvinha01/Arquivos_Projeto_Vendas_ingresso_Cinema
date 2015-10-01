package model;

import java.util.Date;

/**
 *
 * @author silvinha01
 */
public class Sessao {

    private static int CODIGO_GERADO = 1;
    private int codigo;
    private Sala sala;
    private Date horario;
    private Filme filme;

    /**
     * Inicia o objeto sessao com seus dados.
     *
     * @codigo Código recebe o código gerado de uma sessão.
     * @param sala Objeto Sala voltado especifica a sala de uma sessão.
     * @param horario Objeto da Classe Date especifica o horário de uma sessão.
     * @param filme Objeto Filme especifica o filme de uma sessão.
     */
    public Sessao(Sala sala, Date horario, Filme filme) {
        this.codigo = generateCodigo();
        this.sala = sala;
        this.horario = horario;
        this.filme = filme;
    }

    /**
     * Retorna o código de uma sessão.
     *
     * @return código de uma sessão.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Retorna a sala de uma sessão
     *
     * @return objeto sala da sessão
     */
    public Sala getSala() {
        return sala;
    }

    /**
     * Altera a sala de uma sessão
     *
     * @param sala objeto sala da sessão
     */
    public void setSala(Sala sala) {
        this.sala = sala;
    }

    /**
     * Retorna o horário de uma sessão
     *
     * @return objeto horário da sessão
     */
    public Date getHorario() {
        return horario;
    }

    /**
     * Altera o horário de uma sessão
     *
     * @param horario objeto horário da sessão
     */
    public void setHorario(Date horario) {
        this.horario = horario;
    }

    /**
     * Retorna o filme de uma sessão
     *
     * @return objeto filme da sessão
     */
    public Filme getFilme() {
        return filme;
    }

    /**
     * Altera o filme de uma sessão
     *
     * @param filme objeto filme da sessão
     */
    public void setFilme(Filme filme) {
        this.filme = filme;
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

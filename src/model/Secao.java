package model;

import java.util.Date;

/**
 *
 * @author silvinha01
 */
public class Secao {
    
    private Sala sala;
    private Date horario;
    private Filme filme;

    public Secao(Sala sala, Date horario, Filme filme) {
        this.sala = sala;
        this.horario = horario;
        this.filme = filme;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

    public Filme getFilme() {
        return filme;
    }

    public void setFilme(Filme filme) {
        this.filme = filme;
    }     
        
}

package model;

import java.util.Date;

/**
 *
 * @author silvinha01
 */
public class HorarioSecao implements Comparable<HorarioSecao> {
    private Date horario;
    private Secao secao;
    private Sala sala;

    public HorarioSecao(Date horario, Secao secao) {
        this.horario = horario;
        this.secao = secao;
    }

    public Date getHorario() {
        return horario;
    }

    public Secao getSecao() {
        return secao;
    }

    public void setSecao(Secao secao) {
        this.secao = secao;
    }
    
    @Override
    public int compareTo (HorarioSecao o){
       return (this.getHorario().compareTo(o.getHorario()));
    }
}

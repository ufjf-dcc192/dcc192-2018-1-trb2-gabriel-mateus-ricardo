package amigo.oculto;

import java.util.Date;
import java.util.List;


public class Evento {
    private Integer codigo;
    private String titulo;
    private Double minimo;
    private Date data;
    private Date sorteio;
    private String senha;
    private List<Participante> participantes;

    public Evento() {
    }

    public Evento(String titulo, Double minimo, String senha) {
        this.titulo = titulo;
        this.minimo = minimo;
        this.data = new Date();
        this.sorteio = new Date();
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getMinimo() {
        return minimo;
    }

    public void setMinimo(Double minimo) {
        this.minimo = minimo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getSorteio() {
        return sorteio;
    }

    public void setSorteio(Date sorteio) {
        this.sorteio = sorteio;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(List<Participante> participantes) {
        this.participantes = participantes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}

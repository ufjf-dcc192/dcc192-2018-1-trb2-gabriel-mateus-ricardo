package Funcionamento;

import java.util.ArrayList;
import java.util.Collections;
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
    private Integer sorteioRealizado;
    private Integer codigoCriador;

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

    public Integer getSorteioRealizado() {
        return sorteioRealizado;
    }

    public void setSorteioRealizado(Integer sorteioRealizado) {
        this.sorteioRealizado = sorteioRealizado;
    }
    
    public void sorteia()
    {
        List<Participante> participantesAposSorteio = new ArrayList<>();
        Collections.shuffle(participantes);
        for (int i = 0; i < participantes.size(); i++)
        {
            if (i == participantes.size()-1)
            {
                participantes.get(i).setCodigoAmigoOculto(participantes.get(0).getCodigo());
            }
            else
            {
                participantes.get(i).setCodigoAmigoOculto(participantes.get(i+1).getCodigo());
            }
            participantesAposSorteio.add(participantes.get(i));
        }
        this.participantes = participantesAposSorteio;
    }

    public Integer getCodigoCriador() {
        return codigoCriador;
    }

    public void setCodigoCriador(Integer codigoCriador) {
        this.codigoCriador = codigoCriador;
    }
}

package controlBD;

import Funcionamento.Evento;
import Funcionamento.Participante;
import java.util.Date;
import java.util.List;

public interface EventoDAO {
    public void criar (String titulo, Double minimo, Date data, Date sorteio, String senha, Integer id) throws Exception;
    public Evento listarEvento (Integer id) throws Exception;
    public Integer varrerEvento () throws Exception;
    public List<Evento> listarTodos() throws Exception;
    public void alterar(String titulo, Double valor, Date data, Date sorteio, Integer id) throws Exception;
    public void excluir (Integer evento) throws Exception; 
    public void sorteioRealizado(Integer numeroEvento) throws Exception;
}

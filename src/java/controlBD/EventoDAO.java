package controlBD;

import amigo.oculto.Evento;
import amigo.oculto.Participante;
import java.util.Date;
import java.util.List;

public interface EventoDAO {
    //Definir funções para adicionar ao Banco
    public void criar (String titulo, Double minimo, Date data, Date sorteio, String senha, Integer id) throws Exception;
    //public Integer listarEvento () throws Exception;
    public Integer varrerEvento () throws Exception;
    public List<Evento> listarTodos() throws Exception;
    //public void alterar (Evento evento) throws Exception;
    //public void excluir (Evento evento) throws Exception; 
}

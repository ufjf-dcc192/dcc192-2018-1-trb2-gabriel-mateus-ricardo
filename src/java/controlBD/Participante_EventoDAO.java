package controlBD;

import Funcionamento.Evento;
import Funcionamento.Participante;
import java.util.List;

public interface Participante_EventoDAO {
     public void criar (Integer idParticipante, Integer idEvento) throws Exception;
     public boolean busca (Integer idParticipante, Integer idEvento) throws Exception;
     public List<Integer> listarUsuarioEvento (Evento evento) throws Exception;
     public List<Participante> listarUsuarioEventoAmigoOculto (Evento evento) throws Exception;
     public void inserirAmigoOculto (List<Participante> participantes, Integer codigoEvento) throws Exception;
     public void excluir (Integer idEvento) throws Exception;
}

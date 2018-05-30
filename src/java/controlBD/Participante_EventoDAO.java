package controlBD;

import Funcionamento.Evento;
import java.util.List;

public interface Participante_EventoDAO {
     public void criar (Integer idParticipante, Integer idEvento) throws Exception;
     public boolean busca (Integer idParticipante, Integer idEvento) throws Exception;
     public List<Integer> listarUsuarioEvento (Evento evento) throws Exception;
}

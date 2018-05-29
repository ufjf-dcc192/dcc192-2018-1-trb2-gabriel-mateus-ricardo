package controlBD;

import java.sql.Connection;
import java.util.Date;

public interface Participante_EventoDAO {
     public void criar (Integer idParticipante, Integer idEvento) throws Exception;
}

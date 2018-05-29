package controlBD;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Participante_EventoDAOJDBC implements Participante_EventoDAO{
    private Connection conexao;
    
    public Participante_EventoDAOJDBC() {
        try {
            try {
                conexao = BdConnection.getConnection();
            } catch (Exception ex) {
                Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

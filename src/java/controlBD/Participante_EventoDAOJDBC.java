package controlBD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Participante_EventoDAOJDBC implements Participante_EventoDAO{
    private Connection conexao;
    private PreparedStatement operacaoCriar;
    
    public Participante_EventoDAOJDBC() {
        try {
            try {
                conexao = BdConnection.getConnection();
                operacaoCriar = conexao.prepareStatement("insert into evento_participante (fkid_codigoParticipante, fkid_codigoEvento) values (?, ?)");
            } catch (Exception ex) {
                Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void criar(Integer idParticipante, Integer idEvento) throws Exception {
        operacaoCriar.clearParameters();
        operacaoCriar.setInt(1, idParticipante);
        operacaoCriar.setInt(2, idEvento);
        operacaoCriar.executeUpdate();
    }
}

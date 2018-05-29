package controlBD;

import Funcionamento.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Participante_EventoDAOJDBC implements Participante_EventoDAO{
    private Connection conexao;
    private PreparedStatement operacaoCriar;
    private PreparedStatement operacaoBuscar;
    
    public Participante_EventoDAOJDBC() {
        try {
            try {
                conexao = BdConnection.getConnection();
                operacaoCriar = conexao.prepareStatement("insert into evento_participante (fkid_codigoParticipante, fkid_codigoEvento) values (?, ?)");
                operacaoBuscar = conexao.prepareStatement("select fkid_codigoEvento from evento_participante where fkid_codigoParticipante = ?");
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

    @Override
    public boolean busca(Integer idParticipante, Integer idEvento) throws Exception {
        List<Integer> idEventos = new ArrayList<>();
        operacaoBuscar.clearParameters();
        operacaoBuscar.setInt(1, idParticipante);
        ResultSet resultado = operacaoBuscar.executeQuery();
        while(resultado.next())
        {
            Integer id = resultado.getInt("fkid_codigoParticipante");
            idEventos.add(id);
        }    
        EventoDAO e = new EventoDAOJDBC();
        List<Evento> eventos = e.listarTodos();
        for (Evento evento : eventos) {
            for (Integer idev : idEventos) {
                if (evento.getCodigo() == idev)
                {
                    return true;
                }
            }
        }
        return false;
    }
}

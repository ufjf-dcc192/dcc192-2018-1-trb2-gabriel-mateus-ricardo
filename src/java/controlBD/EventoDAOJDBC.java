package controlBD;

import amigo.oculto.Evento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDAOJDBC implements EventoDAO {

    private Connection conexao;
    private PreparedStatement operacaoInsereEvento;
    private PreparedStatement operacaoVarrerEvento;

    public EventoDAOJDBC() {
        try {
            try {
                conexao = BdConnection.getConnection();
                operacaoInsereEvento = conexao.prepareStatement("insert into evento (titulo, minimo, dataInicial, dataSorteio, senhaEntrada) values"
                        + "(?,?,?,?,?)");
                operacaoVarrerEvento = conexao.prepareStatement("select codigoEvento from evento");
            } catch (Exception ex) {
                Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void criar(String titulo, Double minimo, Date evento, Date sorteio, String senha) throws Exception {
        java.util.Date dataEvento = evento;
        java.util.Date dataSorteio = sorteio;
        Calendar cal = Calendar.getInstance();
        cal.setTime(dataEvento);
        cal.setTime(dataSorteio);
        java.sql.Timestamp dataSqlEvento = new java.sql.Timestamp(dataEvento.getTime());
        java.sql.Timestamp dataSqlSorteio = new java.sql.Timestamp(dataSorteio.getTime());
        operacaoInsereEvento.clearParameters();
        operacaoInsereEvento.setString(1, titulo);
        operacaoInsereEvento.setDouble(2, minimo);
        operacaoInsereEvento.setTimestamp(3, dataSqlEvento);
        operacaoInsereEvento.setTimestamp(4, dataSqlSorteio);
        operacaoInsereEvento.setString(5, senha);
        operacaoInsereEvento.executeUpdate();
    }
    
    @Override
    public Integer varrerEvento() throws Exception {
        Integer i = 0;
        ResultSet resultado = operacaoVarrerEvento.executeQuery();
        while (resultado.next()) {
            i = resultado.getInt(1);
        }
        return i;
    }

    public List<Evento> listAll() {
        List<Evento> eventos = new ArrayList<>();
        try {
            Statement comando = conexao.createStatement();
            ResultSet resultado = comando.executeQuery(""); // Colocar comando aqui
            while (resultado.next()) {
                Evento evento = new Evento();
                evento.setCodigo(resultado.getInt("codigo"));
                evento.setTitulo(resultado.getString("titulo"));
                evento.setMinimo(resultado.getDouble("minimo"));
                evento.setData(resultado.getDate("data"));
                evento.setSorteio(resultado.getDate("sorteio"));
                eventos.add(evento);

            }
            resultado.close();
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }

    void delete(Integer codigo) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("", codigo)); // Colocar comando de deleção aqui
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

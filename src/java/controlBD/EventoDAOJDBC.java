package controlBD;

import amigo.oculto.Evento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDAOJDBC implements EventoDAO {

    private Connection conexao;
    private PreparedStatement operacaoInsereEvento;

    public EventoDAOJDBC() {
        try {
            try {
                conexao = BdConnection.getConnection();
                operacaoInsereEvento = conexao.prepareStatement("insert into evento (titulo, minimo, dataInicial, dataSorteio, senhaEntrada) values"
                        + "(?,?,?,?,?)");
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
        java.sql.Date dataSqlEvento = new java.sql.Date(dataEvento.getTime());
        java.sql.Date dataSqlSorteio = new java.sql.Date(dataSorteio.getTime());
        operacaoInsereEvento.clearParameters();
        operacaoInsereEvento.setString(1, titulo);
        operacaoInsereEvento.setDouble(2, minimo);
        operacaoInsereEvento.setDate(3, dataSqlEvento);
        operacaoInsereEvento.setDate(4, dataSqlSorteio);
        operacaoInsereEvento.setString(5, senha);
        operacaoInsereEvento.executeUpdate();
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

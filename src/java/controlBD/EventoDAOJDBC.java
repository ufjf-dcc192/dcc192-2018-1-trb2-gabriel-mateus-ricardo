package controlBD;

import Funcionamento.Evento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDAOJDBC implements EventoDAO {

    private Connection conexao;
    private PreparedStatement operacaoInsereEvento;
    private PreparedStatement operacaoAcharEvento;
    private PreparedStatement operacaoVarrerEvento;
    private PreparedStatement operacaoListarEvento;
    private PreparedStatement operacaoAtualizarSorteio;
    private PreparedStatement operacaoAtualizarDataSorteio;
    private PreparedStatement operacaoAtualizarDataEvento;
    private PreparedStatement operacaoAtualizarDataEventoSorteio;

    public EventoDAOJDBC() {
        try {
            try {
                conexao = BdConnection.getConnection();
                operacaoInsereEvento = conexao.prepareStatement("insert into evento (titulo, minimo, dataInicial, dataSorteio, senhaEntrada, sorteioRealizado, fk_codigoCriador) values"
                        + "(?,?,?,?,?,?,?)");
                operacaoAcharEvento = conexao.prepareStatement("select codigoEvento, titulo, minimo, dataInicial, dataSorteio, senhaEntrada from evento where codigoEvento = ?");
                operacaoVarrerEvento = conexao.prepareStatement("select codigoEvento from evento");
                operacaoListarEvento = conexao.prepareStatement("select codigoEvento, titulo, minimo, dataInicial, dataSorteio, senhaEntrada, sorteioRealizado, fk_codigoCriador from evento");
                operacaoAtualizarSorteio = conexao.prepareStatement("update evento set sorteioRealizado = 1 where codigoEvento = ?");
                operacaoAtualizarDataSorteio = conexao.prepareStatement("update evento set titulo = ?, minimo = ?, dataSorteio = ? where codigoEvento = ?");
                operacaoAtualizarDataEvento = conexao.prepareStatement("update evento set titulo = ?, minimo = ?, dataInicial = ? where codigoEvento = ?");
                operacaoAtualizarDataEventoSorteio = conexao.prepareStatement("update evento set titulo = ?, minimo = ?, dataSorteio = ?, dataInicial = ? where codigoEvento = ?");
            } catch (Exception ex) {
                Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void criar(String titulo, Double minimo, Date evento, Date sorteio, String senha, Integer id) throws Exception {
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
        operacaoInsereEvento.setInt(6, 0);
        operacaoInsereEvento.setInt(7, id);
        operacaoInsereEvento.executeUpdate();
    }

    @Override
    public Integer varrerEvento() throws Exception {
        Integer i = 0;
        ResultSet resultado = operacaoVarrerEvento.executeQuery();
        while (resultado.next()) {
            i = resultado.getInt("codigoEvento");
        }
        return i;
    }

    public List<Evento> listarTodos() {
        List<Evento> eventos = new ArrayList<>();
        try {
            operacaoListarEvento.clearParameters();
            ResultSet resultado = operacaoListarEvento.executeQuery();
            while (resultado.next()) {
                Evento evento = new Evento();
                evento.setCodigo(resultado.getInt("codigoEvento"));
                evento.setTitulo(resultado.getString("titulo"));
                evento.setMinimo(resultado.getDouble("minimo"));
                evento.setData(resultado.getTimestamp("dataInicial"));
                evento.setSorteio(resultado.getTimestamp("dataSorteio"));
                evento.setSenha(resultado.getString("senhaEntrada"));
                evento.setSorteioRealizado(resultado.getInt("sorteioRealizado"));
                evento.setCodigoCriador(resultado.getInt("fk_codigoCriador"));
                eventos.add(evento);
            }
            resultado.close();
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

    @Override
    public Evento listarEvento(Integer id) throws Exception {
        operacaoAcharEvento.clearParameters();
        operacaoAcharEvento.setInt(1, id);
        ResultSet resultado = operacaoAcharEvento.executeQuery();
        resultado.next();
        Evento evento = new Evento();
        evento.setCodigo(resultado.getInt("codigoEvento"));
        evento.setTitulo(resultado.getString("titulo"));
        evento.setMinimo(resultado.getDouble("minimo"));
        evento.setData(resultado.getTimestamp("dataInicial"));
        evento.setSorteio(resultado.getTimestamp("dataSorteio"));
        evento.setSenha(resultado.getString("senhaEntrada"));
        return evento;
    }

    @Override
    public void sorteioRealizado(Integer numeroEvento) throws Exception {
        operacaoAtualizarSorteio.clearParameters();
        operacaoAtualizarSorteio.setInt(1, numeroEvento);
        operacaoAtualizarSorteio.executeUpdate();
    }

    @Override
    public void alterar(String titulo, Double valor, Date data, Date sorteio, Integer id) throws Exception {
        if (data != null && sorteio != null) {
            java.sql.Timestamp dataSqlEvento = new java.sql.Timestamp(data.getTime());
            java.sql.Timestamp dataSqlSorteio = new java.sql.Timestamp(sorteio.getTime());
            operacaoAtualizarDataEventoSorteio.clearParameters();
            operacaoAtualizarDataEventoSorteio.setString(1, titulo);
            operacaoAtualizarDataEventoSorteio.setDouble(2, valor);
            operacaoAtualizarDataEventoSorteio.setTimestamp(3, dataSqlSorteio);
            operacaoAtualizarDataEventoSorteio.setTimestamp(4, dataSqlEvento);
            operacaoAtualizarDataEventoSorteio.setInt(5, id);
            operacaoAtualizarDataEventoSorteio.executeUpdate();
            operacaoAtualizarDataEvento.clearParameters();
        } else if (data != null) {
            java.sql.Timestamp dataSqlEvento = new java.sql.Timestamp(data.getTime());
            operacaoAtualizarDataEvento.clearParameters();
            operacaoAtualizarDataEvento.setString(1, titulo);
            operacaoAtualizarDataEvento.setDouble(2, valor);
            operacaoAtualizarDataEvento.setTimestamp(3, dataSqlEvento);
            operacaoAtualizarDataEvento.setInt(4, id);
            operacaoAtualizarDataEvento.executeUpdate();
        } else if (sorteio != null) {
            java.sql.Timestamp dataSqlSorteio = new java.sql.Timestamp(sorteio.getTime());
            operacaoAtualizarDataSorteio.clearParameters();
            operacaoAtualizarDataSorteio.setString(1, titulo);
            operacaoAtualizarDataSorteio.setDouble(2, valor);
            operacaoAtualizarDataSorteio.setTimestamp(3, dataSqlSorteio);
            operacaoAtualizarDataSorteio.setInt(4, id);
            operacaoAtualizarDataSorteio.executeUpdate();
        }

    }
}

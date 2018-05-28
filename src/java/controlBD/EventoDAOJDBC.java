package controlBD;

import amigo.oculto.Evento;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EventoDAOJDBC implements EventoDAO{

    private static Connection conexao;
    private static EventoDAOJDBC instancia;

    public static EventoDAOJDBC getInstance() {
        if (instancia == null) {
            instancia = new EventoDAOJDBC();
        }
        return instancia;
    }

    public EventoDAOJDBC() {
        try {
            if (conexao == null) {
                conexao = DriverManager.getConnection("", "usuario", "senha"); // Colocar o banco aqui 
            }
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    void create(String titulo) {
        try {
            Statement comando = conexao.createStatement();
            comando.executeUpdate(String.format("", titulo)); // Colocar comando de inclusão aqui
            comando.close();
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
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

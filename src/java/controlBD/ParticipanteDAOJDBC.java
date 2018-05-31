package controlBD;

import Funcionamento.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParticipanteDAOJDBC implements ParticipanteDAO {

    private Connection conexao;
    private PreparedStatement operacaoInsereParticipante;
    private PreparedStatement operacaoAcharParticipante;
    private PreparedStatement operacaoAcharParticipante2;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoVarrerParticipante;

    public ParticipanteDAOJDBC() {
        try {
            try {
                conexao = BdConnection.getConnection();
                operacaoInsereParticipante = conexao.prepareStatement("insert into participante (nome, email, senha) values"
                        + "(?,?,?)");
                operacaoAcharParticipante = conexao.prepareStatement("select codigoParticipante from participante where email = ? and senha = ?");
                operacaoAcharParticipante2 = conexao.prepareStatement("select nome from participante where codigoParticipante = ?");
                operacaoListar = conexao.prepareStatement("select nome, email from participante where codigoParticipante = ?");
                operacaoVarrerParticipante = conexao.prepareStatement("select codigoParticipante, nome, email, senha from participante");
            } catch (Exception ex) {
                Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (Exception ex) {
            Logger.getLogger(ParticipanteDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void criar(String nome, String email, String senha) throws Exception {
        operacaoInsereParticipante.clearParameters();
        operacaoInsereParticipante.setString(1, nome);
        operacaoInsereParticipante.setString(2, email);
        operacaoInsereParticipante.setString(3, senha);
        operacaoInsereParticipante.executeUpdate();
    }

    @Override
    public Integer listarParticipante(String email, String senha) throws Exception {
        operacaoAcharParticipante.clearParameters();
        operacaoAcharParticipante.setString(1, email);
        operacaoAcharParticipante.setString(2, senha);
        ResultSet resultado = operacaoAcharParticipante.executeQuery();
        resultado.next();
        Integer id = resultado.getInt("codigoParticipante");
        return id;
    }

    @Override
    public List<Participante> listarTodos() throws Exception {
        operacaoVarrerParticipante.clearParameters();
        ResultSet resultado = operacaoVarrerParticipante.executeQuery(); 
        while (resultado.next()) {
                Participante p = new Participante();
            }
            resultado.close();
        return null;
    }

    @Override
    public Integer varrerParticipante() throws Exception {
        Integer i = 0;
        ResultSet resultado = operacaoVarrerParticipante.executeQuery();
        while (resultado.next()) {
            i = resultado.getInt(1);
        }
        return i;
    }

    @Override
    public List<Participante> listarParticipanteEvento(List<Integer> ids)throws Exception{
        List<Participante> participantes = new ArrayList<>();
        for (Integer id : ids) {
            operacaoListar.clearParameters();
            operacaoListar.setInt(1, id);
            ResultSet resultado = operacaoListar.executeQuery();
            while (resultado.next())
            {
                Participante p = new Participante();
                p.setCodigo(id);
                p.setNome(resultado.getString("nome"));
                p.setNome(resultado.getString("email"));
                participantes.add(p);
            }
        }
        return participantes;
    }

    @Override
    public List<Participante> listarParticipanteEventoSorteioRealizado(List<Participante> participantes) throws Exception {
        List<Participante> p = new ArrayList<>();
        for (Participante participante : participantes) {
            operacaoListar.clearParameters();
            operacaoListar.setInt(1, participante.getCodigo());
            ResultSet resultado = operacaoListar.executeQuery();
            while (resultado.next())
            {
                Participante pa = new Participante();
                pa.setCodigo(participante.getCodigo());
                pa.setNome(resultado.getString("nome"));
                pa.setNome(resultado.getString("email"));
                pa.setCodigoAmigoOculto(participante.getCodigoAmigoOculto());
                p.add(pa);
            }
        }
        return p;
    }

    @Override
    public String listarParticipante2(Integer codigo) throws Exception {
        operacaoAcharParticipante2.clearParameters();
        operacaoAcharParticipante2.setInt(1, codigo);
        ResultSet resultado = operacaoAcharParticipante2.executeQuery();
        resultado.next();
        String nome = resultado.getString("nome");
        return nome;
    }

}

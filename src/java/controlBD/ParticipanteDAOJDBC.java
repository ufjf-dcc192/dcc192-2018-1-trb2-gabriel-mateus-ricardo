package controlBD;

import amigo.oculto.Participante;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ParticipanteDAOJDBC implements ParticipanteDAO{

    private Connection conexao;
    private PreparedStatement operacaoInsereParticipante;
    private PreparedStatement operacaoListar;
    private PreparedStatement operacaoAlterar;
    private PreparedStatement operacaoAlterar2;
    private PreparedStatement operacaoExcluir;
    private PreparedStatement operacaoVarrerParticipante;
    
    public ParticipanteDAOJDBC() {
                try {
            try {
                conexao = BdConnection.getConnection();
                operacaoInsereParticipante = conexao.prepareStatement("insert into participante (nome, email, senha) values"
                        + "(?,?,?)");
                operacaoListar = conexao.prepareStatement("select pesid, pesnome, pesmail from pessoa");
                operacaoAlterar = conexao.prepareStatement("update pessoa set PESNOME=? where PESID = ?");
                operacaoAlterar2 = conexao.prepareStatement("update pessoa set PESMAIL=? where PESID = ?");
                operacaoExcluir = conexao.prepareStatement("delete from pessoa where PESID = ?");
                operacaoVarrerParticipante = conexao.prepareStatement("select codigoParticipante from participante");
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
    public List<Participante> listarTodos() throws Exception {
        return null;
    
    }

    @Override
    public void alterar(Participante participante) throws Exception {
    
    }

    @Override
    public void excluir(Participante participante) throws Exception {
    
    }

    @Override
    public Integer varrerParticipante() throws Exception {
        Integer i = 0;
        ResultSet resultado = operacaoVarrerParticipante.executeQuery();
        while (resultado.next())
        {
            i = resultado.getInt(1);
        }
        return i;  
    }
    
}

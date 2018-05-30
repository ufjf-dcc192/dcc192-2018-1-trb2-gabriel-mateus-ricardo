package controlBD;

import Funcionamento.Participante;
import java.util.List;

public interface ParticipanteDAO {
    public void criar (String nome, String email, String senha) throws Exception;
    public Integer listarParticipante (String email, String senha) throws Exception;
    public Integer varrerParticipante () throws Exception;
    public List<Participante> listarTodos() throws Exception;
    public void alterar (Participante participante) throws Exception;
    public void excluir (Participante participante) throws Exception; 

    public List<Participante> listarParticipanteEvento(List<Integer> ids) throws Exception;

    public List<Participante> listarParticipanteEventoSorteioRealizado(List<Participante> participantes) throws Exception;
}

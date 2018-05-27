package amigo.oculto;

import controlBD.ParticipanteDAO;
import controlBD.ParticipanteDAOJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CadastroCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ParticipanteDAO p = new ParticipanteDAOJDBC();
            String nomeUsuario = request.getParameter("nomeUsuario");
            String email = request.getParameter("emailUsuario");
            String senha = request.getParameter("senhaUsuario");
            p.criar(nomeUsuario, email, senha);
            Integer id = p.varrerParticipante();
            
        } catch (Exception e) {
        }
    }
    
}

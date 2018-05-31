package command;

import controlBD.ParticipanteDAO;
import controlBD.ParticipanteDAOJDBC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ParticipanteDAO p = new ParticipanteDAOJDBC();
            String email = request.getParameter("emailUsuario");
            String senha = request.getParameter("senhaUsuario");
            Integer id;
            try {
                id = p.listarParticipante(email, senha);
                response.sendRedirect("eventos.html?id="+id);
            } catch (Exception ex) {
                response.sendRedirect("login.html?erro=0");
            }
    }
    
}

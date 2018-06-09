package command;

import controlBD.ParticipanteDAO;
import controlBD.ParticipanteDAOJDBC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostCadastroCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ParticipanteDAO p = new ParticipanteDAOJDBC();
            String nomeUsuario = request.getParameter("nomeUsuario");
            String email = request.getParameter("emailUsuario");
            String senha = request.getParameter("senhaUsuario");
            try {
                p.listarParticipante(email, senha);
                response.sendRedirect("erro.html");
            }
            catch(Exception ex)
            {
                p.criar(nomeUsuario, email, senha);
                response.sendRedirect("index.html");
            }         
        } catch (Exception e) {
            response.sendRedirect("cadastro.html?erro=0");
        }
    }
    
}

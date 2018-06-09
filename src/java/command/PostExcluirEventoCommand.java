package command;

import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import controlBD.ParticipanteDAO;
import controlBD.ParticipanteDAOJDBC;
import controlBD.Participante_EventoDAO;
import controlBD.Participante_EventoDAOJDBC;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostExcluirEventoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ParticipanteDAO pD = new ParticipanteDAOJDBC();
        String email = request.getParameter("emailUsuario");
        String senha = request.getParameter("senhaUsuario");
        Integer idParticipante = Integer.parseInt(request.getParameter("idParticipante"));
        Integer idEvento = Integer.parseInt(request.getParameter("idEvento"));
        Integer id;
        try
        {
            id = pD.listarParticipante(email, senha);
            EventoDAO e = new EventoDAOJDBC();
            Participante_EventoDAO p = new Participante_EventoDAOJDBC();
            p.excluir(idEvento);
            e.excluir(idEvento);
            response.sendRedirect("eventos.html?id="+idParticipante);
        }
        catch (Exception ex)
        {
            request.setAttribute("excluir", false);
            request.setAttribute("id", idParticipante);
            request.setAttribute("id2", idEvento);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/excluirevento.jsp");
            despachante.forward(request, response);
        }
    }
    
}

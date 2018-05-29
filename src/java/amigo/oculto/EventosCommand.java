package amigo.oculto;

import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import controlBD.ParticipanteDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventosCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventoDAO e = new EventoDAOJDBC();
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Evento> evento;
        try {
            evento = e.listarTodos();
            request.setAttribute("evento", evento);
            request.setAttribute("id", id);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/eventos.jsp");
            despachante.forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(EventosCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

package command;

import Funcionamento.Evento;
import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEventosCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            EventoDAO e = new EventoDAOJDBC();
            Integer id = Integer.parseInt(request.getParameter("id"));
            List<Evento> evento;
            evento = e.listarTodos();
            request.setAttribute("evento", evento);
            request.setAttribute("id", id);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/eventos.jsp");
            despachante.forward(request, response);
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }
    
}

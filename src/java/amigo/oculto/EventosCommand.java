package amigo.oculto;

import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EventosCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        List<Evento> evento = ListaEventos.getInstance();
        request.setAttribute("evento", evento);
        request.setAttribute("id", id);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/eventos.jsp");
        despachante.forward(request, response);
    }
    
}

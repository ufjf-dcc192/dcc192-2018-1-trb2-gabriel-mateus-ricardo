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
        List<Evento> evento = ListaEventos.getInstance();
        request.setAttribute("evento", evento);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/eventos.jsp");
        despachante.forward(request, response);
    }
    
}

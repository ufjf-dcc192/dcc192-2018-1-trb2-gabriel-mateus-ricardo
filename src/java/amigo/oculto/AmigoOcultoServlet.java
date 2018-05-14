package amigo.oculto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AmigoOcultoServlet", urlPatterns = {"/AmigoOcultoServlet.html", "/eventos.html"})
public class AmigoOcultoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       if ("/eventos.html".equals(request.getServletPath())) {
            listarEventos(request, response);
        } 
    }

    private void listarEventos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Evento> evento = ListaEventos.getInstance();
        request.setAttribute("evento", evento);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/eventos.jsp");
        despachante.forward(request, response);
    }

    
}

package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetCriarNovoEventoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
            Integer id = Integer.parseInt(request.getParameter("id"));
            request.setAttribute("evento", true);
            request.setAttribute("id", id);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoevento.jsp");
            despachante.forward(request, response);
        }
        catch (Exception ex)
        {
            response.sendRedirect("erro.html");
        }
            
    }
}

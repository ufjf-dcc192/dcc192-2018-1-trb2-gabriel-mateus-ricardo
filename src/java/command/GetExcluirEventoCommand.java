package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetExcluirEventoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer id2 = Integer.parseInt(request.getParameter("id2"));
        request.setAttribute("excluir", true);
        request.setAttribute("id", id);
        request.setAttribute("id2", id2);
        RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/excluirevento.jsp");
        despachante.forward(request, response);
    }
    
}

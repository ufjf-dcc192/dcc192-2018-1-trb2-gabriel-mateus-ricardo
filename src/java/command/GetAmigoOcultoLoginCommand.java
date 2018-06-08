package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAmigoOcultoLoginCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("login", true);
            Integer idUsuario = Integer.parseInt(request.getParameter("id"));
            Integer idEvento = Integer.parseInt(request.getParameter("id2"));
            request.setAttribute("id", idUsuario);
            request.setAttribute("id2", idEvento);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/senhaamigooculto.jsp");
            despachante.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("login", false);
            Integer idUsuario = Integer.parseInt(request.getParameter("id"));
            Integer idEvento = Integer.parseInt(request.getParameter("id2"));
            request.setAttribute("id", idUsuario);
            request.setAttribute("id2", idEvento);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/senhaamigooculto.jsp");
            despachante.forward(request, response);
        }
    }
    
}

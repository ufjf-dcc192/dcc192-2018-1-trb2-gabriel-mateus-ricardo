package command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoCadastroCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer erro = Integer.parseInt(request.getParameter("erro"));
            request.setAttribute("cadastro", false);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/cadastro.jsp");
            despachante.forward(request, response);
        } catch (Exception e) {
            request.setAttribute("cadastro", true);
            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/cadastro.jsp");
            despachante.forward(request, response);
        }
    }
    
}

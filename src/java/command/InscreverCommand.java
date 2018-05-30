package command;

import command.Comando;
import controlBD.Participante_EventoDAO;
import controlBD.Participante_EventoDAOJDBC;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscreverCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer id2 = Integer.parseInt(request.getParameter("id2"));
        Participante_EventoDAO p = new Participante_EventoDAOJDBC();
        try {
            if (!p.busca(id, id2)) {
                request.setAttribute("id", id);
                request.setAttribute("id2", id2);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/inscricao.jsp");
                despachante.forward(request, response);
            } else {
                request.setAttribute("id", id);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/inscricaoRealizada.jsp");
                despachante.forward(request, response);
            }
        } catch (Exception ex) {
            //fazer uma tela mostrando que usuário está inscrito e seu amigo oculto
        }
    }
}

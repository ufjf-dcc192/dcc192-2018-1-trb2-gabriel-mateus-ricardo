package command;

import Funcionamento.Evento;
import Funcionamento.Participante;
import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import controlBD.ParticipanteDAO;
import controlBD.ParticipanteDAOJDBC;
import controlBD.Participante_EventoDAO;
import controlBD.Participante_EventoDAOJDBC;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AdministrarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer id2 = Integer.parseInt(request.getParameter("id2"));
        Participante_EventoDAO p = new Participante_EventoDAOJDBC();
        try {
            if (p.busca(id, id2)) {
                EventoDAO e = new EventoDAOJDBC();
                List<Evento> eventos = e.listarTodos();
                for (Evento evento : eventos) {
                    if (evento.getCodigo() == id2) {
                        if (evento.getCodigoCriador() == id) {
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id2);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/administrar.jsp");
                            despachante.forward(request, response);
                        }
                        else
                        {
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id2);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/acessoNegadoAdm.jsp");
                            despachante.forward(request, response);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }

}

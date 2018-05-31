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

public class InscreverCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer id2 = Integer.parseInt(request.getParameter("id2"));
        Participante_EventoDAO p = new Participante_EventoDAOJDBC();
        try {
            if (!p.busca(id, id2)) {
                EventoDAO e = new EventoDAOJDBC();
                Calendar c = Calendar.getInstance();
                Date data = c.getTime();
                List<Evento> eventos =  e.listarTodos();
                for (Evento evento : eventos) {
                    if (evento.getCodigo()==id2)
                    {
                        Integer idData = evento.getSorteio().compareTo(data);
                        if (idData == 1)
                        {   
                            request.setAttribute("inscricao", true);
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id2);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/inscricao.jsp");
                            despachante.forward(request, response);
                        }
                        else
                        {
                            request.setAttribute("inscricao", false);
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id2);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/inscricao.jsp");
                            despachante.forward(request, response);
                        }
                    }
                }
            } else {
                EventoDAO e = new EventoDAOJDBC();        
                Calendar c = Calendar.getInstance();
                Date data = c.getTime();        
                List<Evento> eventos =  e.listarTodos();
                for (Evento evento : eventos) {
                if (evento.getCodigo() == id2)
                    {
                        Integer idData = evento.getSorteio().compareTo(data);
                        if (idData == 1)
                        {
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id);
                            request.setAttribute("sorteioRealizado", false);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/inscricaoRealizada.jsp");
                            despachante.forward(request, response);
                        }
                        else if(idData == -1)
                        {
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id);                 
                            Participante_EventoDAO pa = new Participante_EventoDAOJDBC();
                            ParticipanteDAO pD = new ParticipanteDAOJDBC();
                            Participante participant = new Participante();
                            List<Participante> participantes = pa.listarUsuarioEventoAmigoOculto(evento);
                            participantes = pD.listarParticipanteEventoSorteioRealizado(participantes);
                            for (Participante participante : participantes) {
                                if (participante.getCodigo() == id)
                                {
                                    participant = participante;
                                }
                            }
                            request.setAttribute("participante", participant);
                            request.setAttribute("sorteioRealizado", true);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/inscricaoRealizada.jsp");
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

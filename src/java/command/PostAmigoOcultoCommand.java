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
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostAmigoOcultoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            ParticipanteDAO pD = new ParticipanteDAOJDBC();
            String email = request.getParameter("emailUsuario");
            String senha = request.getParameter("senhaUsuario");
            Integer idParticipante = Integer.parseInt(request.getParameter("id"));
            Integer idEvento = Integer.parseInt(request.getParameter("id2"));
            Integer id;
            try {
                id = pD.listarParticipante(email, senha);
                if (id == idParticipante)
                {
                    EventoDAO e = new EventoDAOJDBC();
                    List<Evento> eventos =  e.listarTodos();
                    for (Evento evento : eventos) {
                        if (evento.getCodigo() == idEvento)
                        {
                            Participante_EventoDAO pa = new Participante_EventoDAOJDBC();
                            List<Participante> participantes = pa.listarUsuarioEventoAmigoOculto(evento);
                            participantes = pD.listarParticipanteEventoSorteioRealizado(participantes);
                            for (Participante participante : participantes) {
                                if (participante.getCodigo() == idParticipante)
                                {                                                
                                    String nomeAmigoOculto = pD.listarParticipante2(participante.getCodigoAmigoOculto());
                                    request.setAttribute("nome", nomeAmigoOculto);
                                }
                            }
                            request.setAttribute("id", idParticipante);
                            request.setAttribute("id2", idEvento);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/amigooculto.jsp");
                            despachante.forward(request, response);
                        }
                    }
                }
                else
                {
                    request.setAttribute("login", false);
                    request.setAttribute("id", idParticipante);
                    request.setAttribute("id2", idEvento);
                    RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/senhaamigooculto.jsp");
                    despachante.forward(request, response);
                }
            } catch (Exception ex) {
                request.setAttribute("login", false);
                request.setAttribute("id", idParticipante);
                request.setAttribute("id2", idEvento);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/senhaamigooculto.jsp");
                despachante.forward(request, response);
        }
    }
    
}

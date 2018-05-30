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

public class VerInscritosCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventoDAO e = new EventoDAOJDBC();
        try {
            Evento evs = new Evento();
            Boolean jaRealizado = false;
            Integer idParticipante = Integer.parseInt(request.getParameter("id"));
            Integer idEvento = Integer.parseInt(request.getParameter("id2"));
            
            
            Calendar c = Calendar.getInstance();
            Date data = c.getTime();
            
            List<Evento> eventos =  e.listarTodos();
            for (Evento evento : eventos) {
                if (evento.getCodigo() == idEvento)
                {
                    Integer id = evento.getSorteio().compareTo(data);
                    if (id == 1)
                    {
                        evs = evento;
                        jaRealizado = false;
                        break;
                        //Mostrar os participantes com ?
                    }
                    else if (id == -1)
                    {
                        //Varrer o evento para saber se o sorteio já foi feito.
                        //Se sim, apenas mostrar os participantes que já saíram.
                        //Se não, realizar o sorteio e mostrar a possibilidade de visualizar o amigo oculto
                    }
                }
            }
            if (jaRealizado)
            {
                
            }
            else
            {
                ParticipanteDAO p = new ParticipanteDAOJDBC();
                Participante_EventoDAO pa = new Participante_EventoDAOJDBC();
                List<Integer> ids = pa.listarUsuarioEvento(evs);
                List<Participante> participantes = p.listarParticipanteEvento(ids);
                evs.setParticipantes(participantes);
                request.setAttribute("id", idParticipante);
                request.setAttribute("id2", idEvento);
                request.setAttribute("participantes", participantes);
                request.setAttribute("sorteioRealizado", false);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/inscritos.jsp");
                despachante.forward(request, response);
            }
        } catch (Exception ex) {
            
        }
        
    }
    
}

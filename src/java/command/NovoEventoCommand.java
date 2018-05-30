package command;

import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import controlBD.Participante_EventoDAO;
import controlBD.Participante_EventoDAOJDBC;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoEventoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            Integer idParticipante = Integer.parseInt(request.getParameter("id"));
            EventoDAO d = new EventoDAOJDBC();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");        
            String titulo = request.getParameter("titulo");
            Double valorMinimo = Double.parseDouble(request.getParameter("valorMinimo"));
            Date dataSorteio = (Date)formatter.parse(request.getParameter("dataDoSorteio"));
            Date dataEvento = (Date)formatter.parse(request.getParameter("dataDoEvento"));
            String senha = request.getParameter("senhaEvento");
            
            Calendar c = Calendar.getInstance();
            Date data = c.getTime();
            
            if(dataSorteio.compareTo(data)==1 && dataEvento.compareTo(data)==1 && dataEvento.compareTo(dataSorteio)==1)
            {
                d.criar(titulo, valorMinimo, dataEvento, dataSorteio, senha, idParticipante);
                Integer idEvento = d.varrerEvento();
                Participante_EventoDAO p = new Participante_EventoDAOJDBC();
                p.criar(idParticipante, idEvento);
                response.sendRedirect("eventos.html?id="+idParticipante);
            }
            else
            {                            
                request.setAttribute("id", idParticipante);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/novoevento.jsp");
                despachante.forward(request, response);
            }
        } catch (Exception e) {
            response.sendRedirect("erro.html");
        }
    }
}

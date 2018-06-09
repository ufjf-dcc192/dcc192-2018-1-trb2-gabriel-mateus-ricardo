package command;

import Funcionamento.Evento;
import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class PostAdministrarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Evento ev = new Evento();
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer id2 = Integer.parseInt(request.getParameter("id2"));
            Integer id3 = Integer.parseInt(request.getParameter("id3"));
            EventoDAO e = new EventoDAOJDBC();
            List<Evento> evento = e.listarTodos();
            for (Evento evento1 : evento) {
                if (evento1.getCodigo() == id2)
                {
                    ev = evento1;
                }
            }
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            String titulo = request.getParameter("titulo");
            Double valor = Double.parseDouble(request.getParameter("valorMinimo")); 
            Date dataEvento = (Date) formatter.parse(request.getParameter("dataDoEvento"));
            if (id3 == 0)
            {
                Date dataSorteio = (Date) formatter.parse(request.getParameter("dataDoSorteio"));
                Calendar c = Calendar.getInstance();
                Date data = c.getTime();
                if (dataSorteio.compareTo(data) == 1 && dataEvento.compareTo(data) == 1 && dataEvento.compareTo(dataSorteio) == 1)
                {
                    e.alterar(titulo, valor, dataEvento, dataSorteio, id2);
                    response.sendRedirect("eventos.html?id=" + id);
                }
            }
            if (id3 == 1)
            {
                Calendar c = Calendar.getInstance();
                Date data = c.getTime();
                if (dataEvento.compareTo(data) == 1 && dataEvento.compareTo(ev.getSorteio()) == 1)
                {
                    e.alterar(titulo, valor, dataEvento, ev.getSorteio(), id2);
                    response.sendRedirect("eventos.html?id=" + id);
                }
            }
            else
            {
                response.sendRedirect("erro.html");
            }
        } catch (ParseException ex) {
            response.sendRedirect("erro.html");
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }

}

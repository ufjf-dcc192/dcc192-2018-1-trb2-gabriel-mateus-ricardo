package command;

import Funcionamento.Evento;
import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerInscritosCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventoDAO e = new EventoDAOJDBC();
        try {
            Integer idEvento = Integer.parseInt(request.getParameter("id2"));
            
            Calendar c = Calendar.getInstance();
            Date data = c.getTime();
            
            List<Evento> eventos =  e.listarTodos();
            for (Evento evento : eventos) {
                if (evento.getCodigo() == idEvento)
                {
                    Integer id = evento.getSorteio().compareTo(data);
                    if (id == -1)
                    {
                        
                    }
                    else if (id == 1)
                    {
                        
                    }
                }
            }
        } catch (Exception ex) {
            
        }
        
    }
    
}

package command;

import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostAdministrarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer id2 = Integer.parseInt(request.getParameter("id2"));
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");
            Date dataSorteio = (Date) formatter.parse(request.getParameter("dataDoSorteio"));
            Date dataEvento = (Date) formatter.parse(request.getParameter("dataDoEvento"));
            EventoDAO e = new EventoDAOJDBC();
            //e.alterar(dataEvento, dataSorteio, id2);
            response.sendRedirect("eventos.html?id=" + id);

        } catch (ParseException ex) {
            Logger.getLogger(PostAdministrarCommand.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PostAdministrarCommand.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}

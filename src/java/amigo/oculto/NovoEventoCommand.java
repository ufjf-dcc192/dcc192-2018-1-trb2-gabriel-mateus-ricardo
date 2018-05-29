package amigo.oculto;

import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovoEventoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        try {
            EventoDAO d = new EventoDAOJDBC();
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");        
            String titulo = request.getParameter("titulo");
            Double valorMinimo = Double.parseDouble(request.getParameter("valorMinimo"));
            Date dataSorteio = (Date)formatter.parse(request.getParameter("dataDoSorteio"));
            Date dataEvento = (Date)formatter.parse(request.getParameter("dataDoEvento"));
            String senha = request.getParameter("senhaEvento");
            Integer id = Integer.parseInt(request.getParameter("id"));
            d.criar(titulo, valorMinimo, dataEvento, dataSorteio, senha);
            response.sendRedirect("eventos.html?id="+id);
        } catch (Exception e) {
        }
        
            
    }
    
}

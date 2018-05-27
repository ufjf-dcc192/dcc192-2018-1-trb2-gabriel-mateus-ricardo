package amigo.oculto;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CriarNovoEventoCommand implements Comando{

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
            SimpleDateFormat formatoData = new SimpleDateFormat("yyyy-mm-dd");
            String nomeUsuario = request.getParameter("nomeUsuario");
            String email = request.getParameter("emailUsuario");
            String senha = request.getParameter("senhaUsuario");
            String titulo = request.getParameter("titulo");
            Double valorMinimo = Double.parseDouble(request.getParameter("valorMinimo"));
            Date dataSorteio = formato.parse(request.getParameter("dataDoSorteio"));
            String dataSorteio1 = dataSorteio.toString();
            Date dataEvento = formato.parse(request.getParameter("dataDoEvento"));
            
            
        } catch (Exception e) {
        }
    }
    
}

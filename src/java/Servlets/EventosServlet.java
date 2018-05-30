package Servlets;

import command.Comando;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "EventosServlet", urlPatterns = {"/eventos.html", "/novoevento.html", "/inscricao.html", "/inscricaoRealizada.html", "/inscritos.html"})
public class EventosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Map<String, String> rotas = new HashMap<>();
       rotas.put("/eventos.html", "command.EventosCommand");
       rotas.put("/novoevento.html", "command.CriarNovoEventoCommand");
       rotas.put("/inscricao.html", "command.InscreverCommand");
       rotas.put("/inscricaoRealizada.html", "command.RetornarParaEventosCommand");
       rotas.put("/inscritos.html", "command.VerInscritosCommand");
       String clazzName = rotas.get(request.getServletPath());
       try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
       } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(EventosServlet.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> rotas = new HashMap<>();
       rotas.put("/novoevento.html", "command.NovoEventoCommand");
       rotas.put("/inscricao.html", "command.InscricaoCommand");
       String clazzName = rotas.get(request.getServletPath());
       try {
            Comando comando = (Comando) Class.forName(clazzName).newInstance();
            comando.exec(request, response);
       } catch (ClassNotFoundException|IllegalAccessException|InstantiationException ex) {
            response.sendError(500, "Erro: "+ex);
            Logger.getLogger(EventosServlet.class.getName()).log(Level.SEVERE, null, ex);
       } 
    }
    
    
    
}

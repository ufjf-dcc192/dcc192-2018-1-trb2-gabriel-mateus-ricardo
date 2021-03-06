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

@WebServlet(name = "EventosServlet", urlPatterns = {"/eventos.html", "/novoevento.html", "/inscricao.html", "/inscritos.html", "/amigo.html", "/administrar.html", "/excluirevento.html"})
public class EventosServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Map<String, String> rotas = new HashMap<>();
       rotas.put("/eventos.html", "command.GetEventosCommand");
       rotas.put("/novoevento.html", "command.GetCriarNovoEventoCommand");
       rotas.put("/inscricao.html", "command.GetInscreverCommand");
       rotas.put("/inscritos.html", "command.GetVerInscritosCommand");
       rotas.put("/amigo.html", "command.GetAmigoOcultoLoginCommand");
       rotas.put("/administrar.html", "command.GetAdministrarCommand");
       rotas.put("/excluirevento.html", "command.GetExcluirEventoCommand");
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
       rotas.put("/novoevento.html", "command.PostNovoEventoCommand");
       rotas.put("/inscricao.html", "command.PostInscricaoCommand");
       rotas.put("/amigo.html","command.PostAmigoOcultoCommand");
       rotas.put("/administrar.html", "command.PostAdministrarCommand");
       rotas.put("/excluirevento.html", "command.PostExcluirEventoCommand");
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

package amigo.oculto;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GerenciadorServlet", urlPatterns = {"/index.html", "/cadastrar.html", "/login.html"})
public class InicialServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       Map<String, String> rotas = new HashMap<>();
       rotas.put("/index.html", "amigo.oculto.IndexCommand");
       rotas.put("/cadastrar.html", "amigo.oculto.NovoCadastroCommand");
       rotas.put("/login.html", "amigo.oculto.RealizarLoginCommand");
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
       rotas.put("/cadastrar.html", "amigo.oculto.CadastroCommand");
       rotas.put("/login.html", "amigo.oculto.LoginCommand");
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
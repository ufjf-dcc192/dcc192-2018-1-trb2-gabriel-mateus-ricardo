package command;

import command.Comando;
import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InscricaoCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EventoDAO e = new EventoDAOJDBC();
        String senha = request.getParameter("senhaEvento");
    }
}

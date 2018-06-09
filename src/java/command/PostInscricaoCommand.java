package command;

import Funcionamento.Evento;
import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import controlBD.Participante_EventoDAO;
import controlBD.Participante_EventoDAOJDBC;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PostInscricaoCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Integer id = Integer.parseInt(request.getParameter("id"));
            Integer id2 = Integer.parseInt(request.getParameter("id2"));
            Participante_EventoDAO p = new Participante_EventoDAOJDBC();
            if (!p.busca(id, id2)) {
                EventoDAO e = new EventoDAOJDBC();
                String senha = request.getParameter("senhaEvento");
                Evento ev = e.listarEvento(id2);
                if (ev.getSenha().equals(senha)) {
                    try {
                        p.criar(id, id2);
                        response.sendRedirect("eventos.html?id=" + id);
                    } catch (Exception ex) {

                    }
                } else {
                    response.sendRedirect("inscricao.html?id=" + id + "&" + "id2=" + id2);
                }
            } else {
                response.sendRedirect("inscricao.html?id=" + id + "&" + "id2=" + id2);
            }
        } catch (Exception e) {
            response.sendRedirect("erro.html");
        }

    }
}

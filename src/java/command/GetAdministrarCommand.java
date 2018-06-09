package command;

import Funcionamento.Evento;
import controlBD.EventoDAO;
import controlBD.EventoDAOJDBC;
import controlBD.Participante_EventoDAO;
import controlBD.Participante_EventoDAOJDBC;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetAdministrarCommand implements Comando {

    @Override
    public void exec(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("id"));
        Integer id2 = Integer.parseInt(request.getParameter("id2"));
        Participante_EventoDAO p = new Participante_EventoDAOJDBC();
        try {
            if (p.busca(id, id2)) {
                EventoDAO e = new EventoDAOJDBC();
                List<Evento> eventos = e.listarTodos();
                for (Evento evento : eventos) {
                    if (evento.getCodigo() == id2)
                    {
                        if (evento.getCodigoCriador() == id)
                        {
                            //verificar se a data do evento já foi, se sim, não é possível alterar dado nenhum.
                            //Necessário um if else. Se evento já ocorreu, emite tela que evento já foi. Se não, ele pode trocar tudo.
                            //verificar se o sorteio já foi realizado, se sim, não é possível alterar a data do sorteio
                            //Necessário um if else. Se sorteio já realizado ou data do sorteio já passou, passa o evento como false.
                            //Para fazer o segundo verificar, é só usar o when do JSP. 
                            //request.setAttribute("evento", false);
                            request.setAttribute("evento", true);
                            request.setAttribute("eventoModificar", evento);
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id2);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/administrar.jsp");
                            despachante.forward(request, response);
                        }
                        else
                        {
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id2);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/acessoNegadoAdm.jsp");
                            despachante.forward(request, response);
                        }
                    }
                }
            }
            else
            {
                request.setAttribute("id", id);
                request.setAttribute("id2", id2);
                RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/acessoNegadoAdm.jsp");
                despachante.forward(request, response);
            }
            /* 
            {
                EventoDAO e = new EventoDAOJDBC();
                List<Evento> eventos = e.listarTodos();
                for (Evento evento : eventos) {
                    if (evento.getCodigo() == id2) {
                        if (evento.getCodigoCriador() == id) {
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id2);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/administrar.jsp");
                            despachante.forward(request, response);
                        }
                        else
                        {
                            request.setAttribute("id", id);
                            request.setAttribute("id2", id2);
                            RequestDispatcher despachante = request.getRequestDispatcher("/WEB-INF/acessoNegadoAdm.jsp");
                            despachante.forward(request, response);
                        }
                    }
                }
            }*/
        } catch (Exception ex) {
            response.sendRedirect("erro.html");
        }
    }

}

package amigo.oculto;

import java.util.ArrayList;
import java.util.List;

public class ListaEventos {

    private static List<Evento> eventos;
    private int i = 0;

    public static List<Evento> getInstance() {
        if (eventos == null) {
            eventos = new ArrayList<>();
            Evento e = new Evento();
            e.setTitulo("Teste");
            eventos.add(e);
        }
        return eventos;
    }
}

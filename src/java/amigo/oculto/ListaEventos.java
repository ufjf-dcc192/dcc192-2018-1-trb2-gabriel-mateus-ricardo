package amigo.oculto;

import java.util.ArrayList;
import java.util.List;

public class ListaEventos {

    private static List<Evento> eventos;
    private int i = 0;

    public static List<Evento> getInstance() {
        if (eventos == null) {
            eventos = new ArrayList<>();
            eventos.add(new Evento());
            eventos.add(new Evento());
        }
        return eventos;
    }
}

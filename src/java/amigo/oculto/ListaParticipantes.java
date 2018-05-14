package amigo.oculto;

import java.util.ArrayList;
import java.util.List;

public class ListaParticipantes {
    private static List<Participante> participantes;

    public static List<Participante> getInstance() {
        if (participantes == null) {
            participantes = new ArrayList<>();
            participantes.add(new Participante());
            participantes.add(new Participante());
            participantes.add(new Participante());
        }
        return participantes;
    }
}

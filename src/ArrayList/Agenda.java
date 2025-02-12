package ArrayList;

import java.util.ArrayList;

public class Agenda {
    private ArrayList<Contacto> Contacto;


    public Agenda(ArrayList<Contacto> contacto) {
        Contacto = contacto;
    }

    public boolean nuevoContacto(Contacto contacto){
        boolean nuevo = false;

        if (!Contacto.contains(contacto)){
            Contacto.add(contacto);
            nuevo = true;
        }

        return nuevo;
    }

}

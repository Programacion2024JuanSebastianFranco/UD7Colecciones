package ArrayList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class Agenda {
    private ArrayList<Contacto> contactos;

    private static final Comparator<Contacto> COMPARAR_POR_NOMBRE = new Comparator<Contacto>() {
        @Override
        public int compare(Contacto o1, Contacto o2) {
            return o1.getNombre().compareTo(o2.getNombre());
        }
    };

    private static final Comparator<Contacto> COMPARAR_POR_APELLIDO = new Comparator<Contacto>() {
        @Override
        public int compare(Contacto o1, Contacto o2) {
            return o2.getApellido().compareTo(o1.getApellido());
        }
    };

    public Agenda(ArrayList<Contacto> contacto) {
        contactos = contacto;
    }

    public boolean nuevoContacto(Contacto contacto) {
        boolean nuevo = false;

        if (!contactos.contains(contacto)) {
            contactos.add(contacto);
            nuevo = true;
        }

        return nuevo;
    }

    public boolean borrarContacto(String nombre, String apellido) {
        boolean borrar = false;

        try {
            Contacto contacto = new Contacto(nombre, apellido, "1235456789");

            if (contactos.contains(contacto)) {
                contactos.remove(contacto);
                borrar = true;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return borrar;
    }

    public boolean modificarContacto(String nombre, String apellido, String telefono) {
        boolean modificar = false;

        try {
            Contacto contacto = new Contacto(nombre, apellido, telefono);
            int pos = contactos.indexOf(contacto);
            if (pos != -1) {
                contacto.setNumero(telefono);
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        return modificar;
    }

    @Override
    public String toString() {
        Collections.sort(contactos);
        return getListado(contactos);
    }

    private String getListado(ArrayList<Contacto> list) {
        StringBuilder formato = new StringBuilder(Contacto.FORMATO_CONTACTO);

        for (Contacto contacto : contactos) {
            formato.append(contacto.toString()).append("\n");
        }

        return String.valueOf(formato);
    }


    public String ordenarPorNombre() {
        contactos.sort(COMPARAR_POR_NOMBRE);
        return getListado(contactos);
    }

    public String ordenarPorApellido() {
        contactos.sort(COMPARAR_POR_APELLIDO);
        return getListado(contactos);
    }

    public String buscarContacto(String nombre) {
        ArrayList<Contacto> correcto = new ArrayList<>();

        for (Contacto contacto : contactos) {
            if (contacto.getNombre().contains(nombre) || contacto.getApellido().contains(nombre)) {
                correcto.add(contacto);
            }
        }

        return getListado(correcto);
    }

    public String borrarPorNombre(String nombre) {
        Iterator<Contacto> iterator = contactos.iterator();
        while (iterator.hasNext()){
            Contacto contacto = iterator.next();
            if (contacto.getNombre().contains(nombre)){
                iterator.remove();
            }
        }
        return getListado(contactos);
    }

}

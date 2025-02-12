package ArrayList;

import java.lang.Comparable;

public class Contacto implements Comparable<Contacto> {
    private String nombre;
    private String apellido;
    private String numero;

    private static final String FORMATO_CONTACTO = "%-15s %-15s %-15s";
    private static final String CABECERA_CONTACTO = String.format(FORMATO_CONTACTO, "Nombre", "Apellidos", "Numero");

    public Contacto(String nombre, String apellidos, String numero) {
        setNombre(nombre);
        setApellido(apellidos);
        setNumero(numero);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede quedar vacio");
        }
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        if (apellido == null || apellido.trim().isEmpty()) {
            throw new IllegalArgumentException("los apellidos no puede quedar vacios");
        }
        this.apellido = apellido;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        if (numero == null || numero.length() != 9) {
            throw new IllegalArgumentException("Tiene que ser 9 digitos");
        }

        try {
            Integer.valueOf(numero);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El numero solo puede contener digitos");
        }
        this.numero = numero;
    }

    @Override
    public String toString() {
        return String.format(FORMATO_CONTACTO, nombre, apellido, numero);
    }

    @Override
    public int compareTo(Contacto o) {
        return this.apellido.compareTo((o.apellido));
    }



}

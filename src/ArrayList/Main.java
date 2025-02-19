package ArrayList;

import java.util.Scanner;

public class Main {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.generarContactos();

        int opc;
        do {
            opc = menu();
            switch (opc) {
                case 1 -> System.out.println(agenda);
                case 2 -> {
                    System.out.print("Nombre: ");
                    String nombre = scan.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scan.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = scan.nextLine();
                    Contacto contacto = new Contacto(nombre,apellido,telefono);
                    System.out.println(agenda.nuevoContacto(contacto));
                }
                case 3 -> {
                    System.out.print("Nombre: ");
                    String nombre = scan.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scan.nextLine();
                    System.out.print("Telefono: ");
                    String telefono = scan.nextLine();
                    System.out.println(agenda.modificarContacto(nombre, apellido, telefono));
                }
                case 4 -> {
                    System.out.print("Nombre: ");
                    String nombre = scan.nextLine();
                    System.out.print("Apellido: ");
                    String apellido = scan.nextLine();
                    System.out.println(agenda.borrarContacto(nombre, apellido));
                }
                case 5 -> System.out.println(agenda.ordenarPorNombre());
                case 6 -> System.out.println(agenda.ordenarPorApellido());
                case 7 -> {
                    System.out.println("Nombre y apellido:");
                    String nombre = scan.nextLine();
                    System.out.println(agenda.borrarPorNombre(nombre));
                }
                default -> System.out.println("Introduzca un valor valido");
            }
        } while (opc != 8);

        scan.close();
    }

    private static int menu() {
        int opc;
        do {
            System.out.println("""
            1. Mostrar contactos
            2. Agregar nuevo contacto
            3. Actualizar contacto
            4. Eliminar contacto
            5. Mostrar ordenado por nombre
            6. Mostrar ordenado por apellido
            7. Eliminar los que se llaman...
            8. Salir
            """);
            opc = scan.nextInt();
        } while (opc < 1 || opc > 8);
        scan.nextLine();
        return opc;
    }
}
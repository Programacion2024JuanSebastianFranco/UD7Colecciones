package MapSet.Empresa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Empresa {
    Map<String, List<String>> empresa = new HashMap<>();

    public void nuevoEmpleado(String departamento, String empleado) {
        if (!empresa.containsKey(departamento)) {
            empresa.put(departamento, new ArrayList<>());
        }

        List<String> empleados = empresa.get(departamento);

        if (!empleados.contains(empleado)) {
            empleados.add(empleado);
        } else {
            throw new IllegalArgumentException("YA existe el empleado");
        }

    }

    public void listaDepartamentos() {
        for (String key : empresa.keySet()) {
            System.out.println(key);
        }
    }

    public void listaEmpleado(String departamento) {
        if (empresa.containsKey(departamento)) {
            System.out.println(departamento + ": " + empresa.get(departamento));
        } else {
            throw new IllegalArgumentException("No existe dicha empresa");
        }
    }

    public void listaTodos() {
        for (String key : empresa.keySet()) {
            System.out.println(key + ": " + empresa.get(key));
        }
    }

    public static void main(String[] args) {
        Empresa empresa = new Empresa();
        empresa.nuevoEmpleado("Lol", "Salva");
        empresa.nuevoEmpleado("Lol", "Carlos");
        empresa.nuevoEmpleado("IT", "Ana");
        empresa.listaDepartamentos();
        empresa.listaEmpleado("Lol");
        empresa.listaTodos();
    }

}

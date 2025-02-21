package MapSet.Traductor;

import java.util.TreeMap;

public class Traductor {
    TreeMap<String, String> diccionario = new TreeMap<>();

    public void nueva(String es, String en) {
        if (diccionario.containsKey(es) || diccionario.containsKey(en)){
            diccionario.replace(es, en);
        } else {
            diccionario.put(es,en);
        }
    }

    public void eliminar(String es) {
        if (diccionario.containsKey(es)){
            diccionario.remove(es);
        } else {
            throw new IllegalArgumentException("No existe");
        }
    }

    public String traducir(String frase){
        String[] palabras = frase.split(" ");
        StringBuilder salida = new StringBuilder();

        for (String palabra : palabras) {
            salida.append(diccionario.get(palabra)).append(" ");
        }

        return salida.toString();
    }

    public void mostrarLista(){
        for(String key: diccionario.keySet()) {
            System.out.println(key + ": " + diccionario.get(key));
        }
    }

    public static void main(String[] args) {
        Traductor traductor = new Traductor();
        traductor.nueva("Perro", "Dog");
        traductor.nueva("Hola", "Hello");
        traductor.nueva("Buen", "Good");
        traductor.nueva("Feliz", "Happy");
        traductor.mostrarLista();
        traductor.eliminar("Feliz");
        traductor.mostrarLista();
        String trad = traductor.traducir("Hola Buen Perro");
        System.out.println(trad);
    }
}

package MapSet.Traductor;

import java.util.HashMap;
import java.util.Map;

public class Traductor {
    Map<String, String> diccionario = new HashMap<>();

    public Traductor(String frase) {
        this.diccionario = new HashMap<>();
        String[] palabras = frase.split(" ");

        for (String palabra : palabras){
            diccionario.put(palabra, diccionario.getOrDefault(palabra, ""));
        }
    }

    public void nueva(String es, String en) {
        if (diccionario.containsKey(es)){
            diccionario.replace(es, en);
        } else if (diccionario.containsKey(en)){
            diccionario.replace(en,es);
        } else {
            diccionario.put(es,en);
        }
    }

    public void eliminar(String es, String en) {
        if (diccionario.containsKey(es)){
            diccionario.remove(es, en);
        } else if (diccionario.containsKey(en)){
            diccionario.remove(en,es);
        } 
    }

    public void mostrarLista(){
        for(String key: diccionario.keySet()) {
            System.out.println(key + ": " + diccionario.get(key));
        }
    }

    public static void main(String[] args) {
        Traductor traductor = new Traductor("Hola Hello");
        traductor.mostrarLista();
        
    }
}

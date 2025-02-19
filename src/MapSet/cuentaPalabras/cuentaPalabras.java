package MapSet.cuentaPalabras;

import java.util.HashMap;
import java.util.Map;

public class cuentaPalabras {
    Map<String, Integer> mapPalabras = new HashMap<>();

    public cuentaPalabras(String frase) {
        this.mapPalabras = new HashMap<>();
        String[] palabras = frase.split(" ");

        for (String palabra : palabras){
            mapPalabras.put(palabra, mapPalabras.getOrDefault(palabra, 0) + 1);
        }
    }

    public void mostrarLista(){
        for(String key: mapPalabras.keySet()) {
            System.out.println(key + ": " + mapPalabras.get(key));
        }
    }

    public static void main(String[] args) {
        cuentaPalabras cuenta = new cuentaPalabras("hola mundo hola que tal mundo");
        cuenta.mostrarLista();
    }
}

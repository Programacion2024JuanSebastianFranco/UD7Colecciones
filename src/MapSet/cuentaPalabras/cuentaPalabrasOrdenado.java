package MapSet.cuentaPalabras;

import java.util.TreeMap;

public class cuentaPalabrasOrdenado {

    TreeMap<String, Integer> mapPalabras = new TreeMap<>();

    public cuentaPalabrasOrdenado(String frase) {
        this.mapPalabras = new TreeMap<>();
        String[] palabras = frase.split(" ");

        for (String palabra : palabras) {
            mapPalabras.put(palabra, mapPalabras.getOrDefault(palabra, 0) + 1);
        }
    }

    public void mostrarLista() {
        for (String key : mapPalabras.keySet()) {
            System.out.println(key + ": " + mapPalabras.get(key));
        }
    }

    public static void main(String[] args) {
        cuentaPalabrasOrdenado cuenta = new cuentaPalabrasOrdenado("hola mundo hola que tal mundo");
        cuenta.mostrarLista();
    }
}

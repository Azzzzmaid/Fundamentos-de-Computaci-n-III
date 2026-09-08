/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package inviertecadenas;

import java.util.ArrayDeque;
import java.util.Deque;

public class InvierteCadenas {

    
    public static void main(String[] args) {
        String cadena = args.length > 0 ? args[0] : "Hola, mundo!";
        String cadenaInvertida = invertirCadena(cadena);
        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena invertida: " + cadenaInvertida);
        
    }//close main
    
    public static String invertirCadena(String cadena){
        Deque<String> pila = new ArrayDeque<>();
        String[] palabras= cadena.split(" ");
        for (String palabra : palabras) {
            pila.push(palabra);
        }
        
        StringBuilder cadenaInvertida = new StringBuilder();
        while (!pila.isEmpty()) {
            cadenaInvertida.append(pila.pop()).append(" ");
        }
        
        return cadenaInvertida.toString().trim();
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package inviertecadenas;

import static inviertecadenas.InvierteCadenas.invertirCadena;
import java.util.ArrayDeque;
import java.util.Deque;

public class esPalindromo {
    
    public static void main(String[] args) {
        String cadena = args.length > 0 ? args[0] : "Hola, mundo!";
        String cadenaInvertida = invertirCadena(cadena);
        System.out.println("Cadena original: " + cadena);
        System.out.println("Cadena invertida: " + cadenaInvertida);
        
    }
    
    public static boolean esPalindromo (String cadena){
        String cadenaSinEspacio = cadena.replace("\\s+","").toLowerCase();
        Deque<Character> pila=new ArrayDeque();
        for (char c : cadena.toCharArray()) 
            pila.push(c);
        
        char[] cadenaInvertida=new char [cadena.length()];
        
        while (!pila.isEmpty()) {            
            cadenaInvertida[cadena.length()-pila.size()]= pila.pop();
        }
        
        String cadenaInvertidaStr=new String (cadenaInvertida);
        
        System.out.println("Cadena invertida: "+ cadenaInvertidaStr);
        
        return cadena.equals(cadenaInvertidaStr);
    }
    
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package rover;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Queue;
import java.util.LinkedList;

public class Rover {

    public static void main(String[] args) {
        String cadena = args.length > 0 ? args[0] : "path1.txt";
        ArrayList<String> lineas = leerArchivo(cadena);
        Queue<String> queue =addToQueue(lineas);
        travelQueue(queue);
        queue=addToQueue(lineas);
        Deque<String> stack= queueToStack(queue);
        queue = stackToQueue(stack);
        travelQueue(queue);
        
        
        
        
    }
    
    public static Queue<String> stackToQueue(Deque<String> stack){
        Queue<String> queue = new LinkedList<>();
        
        while (!stack.isEmpty()) {
            String linea= stack.pop();
            if (linea !=null) {
                queue.add(linea);
            }
        }
        return queue;
        
    } 
    
    public static Deque<String> queueToStack(Queue<String> queue){
        Deque<String> deque = new ArrayDeque<>();
        while (!queue.isEmpty()){
            String linea =queue.poll();
            if (linea != null)
                deque.push(linea);
        }
        return deque;
            
    }
    
    public static Queue<String> addToQueue (ArrayList<String> lineas){
        Queue<String> queue= new java.util.LinkedList<>();
        for (String linea : lineas) {
            queue.add(linea);
        }
        return queue;
    }
    
     public static ArrayList<String> leerArchivo(String nombreArchivo) {
        ArrayList<String> lineas = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                lineas.add(linea);
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        return lineas;
    }
    
    public static void travelQueue (Queue<String> queue){
        System.out.println(queue.size());
        while (!queue.isEmpty()){
            String linea =queue.poll();
            if (linea !=null) {
                if (linea.trim().toUpperCase().equals("A")) {
                    System.out.print("^");
                }
                if (linea.trim().toUpperCase().equals("D")) {
                    System.out.print("V");
                }
                if (linea.trim().toUpperCase().equals("S")) {
                    System.out.print("-");
                }
            }        
        }
        System.out.println("");
    }
     
}

package tanoi.s_tower;
//Author Azzzzmaid (Andres Chavez)

import java.util.Scanner;
import java.util.Stack;


public class TanoiS_Tower {
    

    static Scanner sc = new Scanner(System.in);
    public static int numeroDeDiscos = 0;
    static Stack<Integer>[] torres = new Stack[3];
    
    
    public static void main(String[] args) { 
        menuPrincipal();
        
    }
    
    static int leerEnteros(){
        while (!sc.hasNextInt()){
            System.out.println("Ingrese número válido");
            sc.next();
        }
        return sc.nextInt();
    }
    
    public static void menuPrincipal(){
        int opcion;
        do {            
            System.out.println("\n==== TORRES DE HANOI =======");
            System.out.println("Numero de discos actual: "+numeroDeDiscos);
            System.out.println("1.- Elegir número de discos (3-8)");
            System.out.println("2.- Jugar manualmente");
            System.out.println("3.- Mostrar solución automática");
            System.out.println("4.- Salir");
            System.out.println("Elige una opción");
            opcion = leerEnteros();
            
            switch (opcion){
                case 1: 
                    elegirNumeroDiscos();
                    break;
                case 2: 
                    jugarManual();
                    break;
                case 3: 
                    mostrarSolucion();
                    break;
                case 4:
                    System.out.println("Hasta luego");
                default: System.out.println("Opción invalida");
                    break;
                    
            }
            
        } while (opcion != 4);
    }//Close menuPrincipal
    
    public static void inicializaTorres(){
        for (int i = 0; i < 3; i++) {
            torres[i]= new Stack<>();
        }
        for (int i = numeroDeDiscos; i >=1; i--) {
            torres[0].push(i);
        }
    }
    
    static void despliegaTorre(int torre){
        System.out.println("\nTorre: "+(char)('A'+torre)+": ");
        for (int disco : torres[torre]) {
            System.out.println(disco + " ");
        }
        System.out.println();
    }
    
    static void despliegaTorres(){
        for (int i = 0; i < 3; i++) {
            despliegaTorre(i);
        }
    }
    
    private static void elegirNumeroDiscos() {
        int n;
        do{
            System.out.println("Elige un número de discos (3-8)");
            n=leerEnteros();
            if (n<3 || n>8) {
                System.out.println("Número invalido, ingrese un valor adecuado");
            }
        
        }while(n<3 || n>8);
        
        numeroDeDiscos = n;
        
        
    }//Close elegirNumeroDiscos

    private static void jugarManual() {
        inicializaTorres();
       
        while (torres[2].size()<numeroDeDiscos) {            
            despliegaTorres();
            String origen = eligeTorre("Ingrese la torre de origen (A, B, C)");
            String destino = eligeTorre("Elige la torre de destino (A, B, C)");
            int torreOrigen = origen.charAt(0) - 'A';
            int torreDestino = destino.charAt(0) - 'A';
            if (torres[torreOrigen].isEmpty()) {
                System.out.println("La Torre de origen está vacia. Intenta de nuevo");
                continue;
            }
            if (torreOrigen == torreDestino) {
                System.out.println("La torre de origen y de destino son las mismas. Intente de nuevo");
                continue;
            }
            moverDisco(torreOrigen, torreDestino);
        }
        System.out.println("\n\n");
        System.out.println("Ganaste El juego!!");
    }
    
    public static boolean moverDisco (int origen, int destino){
        if (torres[origen].isEmpty()) {
            System.out.println("No hay discos en la torre de origen");
            return false;
        }
        if (!torres[destino].isEmpty() && torres[origen].peek() > torres[destino].peek()) {
            System.out.println("Movimeinto invalido. No puedes colocar un disco"
                    + " más grande sobre uno más pequeño");
            return false;
        }
        int disco = torres[origen].pop();
        torres[destino].push(disco);
        System.out.println("Moviste el disco "+ disco + " de la torre "+ (char)('A'+ origen)+
                " a la torre "+ (char)('A'+destino)+".");
        return true;
    }
    
    public static String eligeTorre (String mensaje){
        String torre;
        do {
            System.out.print(mensaje);
            torre=sc.next().toUpperCase();
            if (!torre.equals("A") && !torre.equals("B") && !torre.equals("C")) {
                System.out.println("Torre invalida, eliga A, B ó C");
            }
        } while (!torre.equals("A") && !torre.equals("B") && !torre.equals("C"));
        return torre;
    }

    private static void mostrarSolucion() {
       
    }
    
    
    
}

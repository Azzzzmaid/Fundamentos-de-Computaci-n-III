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
       
        while (true) {            
            despliegaTorres();
            System.out.println("Ingrese ka tirre de origen (A, B, C) ó ");
        }
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

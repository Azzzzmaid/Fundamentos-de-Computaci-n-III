/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursividad;


public class Recursividad {

    public static void main(String[] args) {
        long startTime= System.nanoTime();
//        System.out.println("Factorial de 31: "+ factorial(31));
        System.out.println("Fibonacci de 40: "+ fibonacci(36));
        long endTime= System.nanoTime();
        System.out.println("Tiempo de ejecucion: "+ (endTime - startTime)/1000000 + " ms");
    }//Close main
    
    public static int factorial (int n){
        if (n==0) {
            return 1;
        }else{
            return n * factorial(n-1);
        }
    }
    
    public static int fibonacci (int n){
        if (n==0)
            return 0;
        if (n==1) 
            return 1;
        else{
            return fibonacci(n-1)+ fibonacci(n-2);
        }
    }
    
}//Close class recursividad

package recursividad;

import java.util.HashMap;
import java.util.Map;


public class Recursividad {

    static Map<Integer, Long> memo = new HashMap<>();
    
    public static void main(String[] args) {
//        int[] arr= {7, 15, 30, 45, 60};
//        long startTime= System.nanoTime();
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println("Fibonacci de: "+arr[i] + ": "+ fib(arr[i]));
//            long endTime= System.nanoTime();
//            System.out.println("Tiempo de ejecucion: "+ (endTime - startTime)/1000000 + " ms");
//        }
        int [] array = {20,21,22,23,24,25,26,27,28,29,30};
        int x = 30;
        int indice = buscar( array, x, 0, array.length - 1);
        if (indice !=-1) {
            System.out.println("Numero encontrado en el indice: "+indice);
        }else {
            System.out.println("no encontrado");
        }
        
        
        }//Close main
    
    public static long fib (int n){
        if (n <=1) {
            return n;
        }
        Long guardado = memo.get(n);
        
        if (guardado != null) {
            return guardado;
        }
        
        long resultado = fib(n-1) + fib(n-2);
        memo.put(n, resultado);
        return resultado;
    }
    
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
    
    //Busqueda Binaria
    static int buscar (int [] a, int x, int ini, int fin){
        if (ini>fin) return -1;
        int mid = (ini + fin)>>>1; //Lo que hace el >>> es recorrer hacia la derecha los bits una vez, si fuera >>>2 seria dos posiciones
        if (x==a[mid]) return mid;
        if (x<a[mid]) return buscar(a,x, ini, mid-1);
        return buscar(a,x,mid+1, fin);
    }
}//Close class recursividad

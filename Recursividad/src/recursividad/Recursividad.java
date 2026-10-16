package recursividad;

import java.util.HashMap;
import java.util.Map;


class Nodo{
    int valor;
    Nodo izquierda;
    Nodo derecha;
    
    public Nodo (int valor){
        this.valor=valor;
        this.izquierda =  null;
        this.derecha = null;
    }
    
}//Close Class Nodo

class ArbolBinario {
    Nodo raiz;
    public ArbolBinario(){
        this.raiz=null;
    }
    public void insertar(int valor){
        raiz=insertarRecursivo(raiz, valor);
    }
    
    private Nodo insertarRecursivo(Nodo nodo, int valor){
        if (nodo== null) {
            return new Nodo(valor);
        }
        if (valor<nodo.valor) {
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
        }
        else if(valor > nodo.valor){
            nodo.derecha= insertarRecursivo(nodo.derecha, valor);
        }
        return nodo;
    }//close insertarRecursivo
    
    public void preOrden(){
        preOrdenRecursivo(raiz);
    }//Close preOrden
    
    public void preOrdenRecursivo(Nodo nodo){
        if (nodo != null) {
            System.out.println(nodo.valor + " ");
            preOrdenRecursivo(nodo.izquierda);
            preOrdenRecursivo(nodo.derecha);
        }
    }
    
    public void inOrden(){
        inOrdenRecursivo(raiz);
    }
    
    public void inOrdenRecursivo(Nodo nodo){
        if (nodo!= null) {
            inOrdenRecursivo(nodo.izquierda);
            System.out.println(nodo.valor + " ");
            inOrdenRecursivo(nodo.derecha);
        }
    }
}//Close Class ArbolBinario

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
        int [] array = {20,21,22,23,24,25,26,27,28,29,30,102,55,21,7,225,633,4};
        int x = 30;
        int indice = buscar( array, x, 0, array.length - 1);
//        if (indice !=-1) {
//            System.out.println("Numero encontrado en el indice: "+indice);
//        }else {
//            System.out.println("no encontrado");
//        }
        
        //Creacion de ArbolBinario
        ArbolBinario ArbolB = new ArbolBinario();
        for(int a: array){
            ArbolB.insertar(a);
            
        }
        ArbolB.preOrden();
        System.out.println();
        ArbolB.inOrden();
        
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

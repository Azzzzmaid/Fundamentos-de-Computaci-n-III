/*
IDEA ES PODER INSERTAR, SORTEAR DESC Y ASC POR ORDEN ALFABETICO
izquiera es el mayor
 */
package arbolbinarionombre;

class Nodo{
    String valor;
    Nodo izquierda;
    Nodo derecha;
    
    public Nodo (String valor){
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
    public void insertar(String valor){
        raiz=insertarRecursivo(raiz, valor);
    }
    
    private Nodo insertarRecursivo(Nodo nodo, String valor){
        if (nodo== null) {
            return new Nodo(valor);
        }
        
        int resultado = valor.compareTo(nodo.valor);
        
        if (resultado>0) { //Si el nuevo valor es mayor va a la izquierda
            nodo.izquierda = insertarRecursivo(nodo.izquierda, valor);
        }
        else if(resultado<0){ //Si el nuevo valor es menor va a la derecha
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
    
    public void inOrdenDesc(){
        inOrdenDescRecursivo(raiz);
    }
    
    public void inOrdenRecursivo(Nodo nodo){
        if (nodo!= null) {
            inOrdenRecursivo(nodo.derecha);
            inOrdenRecursivo(nodo.izquierda);
            System.out.println(nodo.valor + " ");
            
        }
    }
    
    public void inOrdenDescRecursivo(Nodo nodo){
        if (nodo!= null) {
            
            inOrdenDescRecursivo(nodo.izquierda);
            System.out.println(nodo.valor + " ");
            inOrdenDescRecursivo(nodo.derecha);
            
        }
    }
    
}//Close Class ArbolBinario

public class ArbolBinarioNombre {

    public static void main(String[] args) {
        String[] personas = {"Alan Aldama Andre", "Isabel Domíngues Ochoa",
        "Ernesto Ozuna Ramirez", "Ada Pino López", "Bruno Díaz Henández", "Luis Caro Durazo"};       
        ArbolBinario ArbolB = new ArbolBinario();
        for(String persona: personas){
            ArbolB.insertar(persona);
            
        }
        //ArbolB.preOrden();
        System.out.println();
        System.out.println("Orden alfabetico A-z");
        ArbolB.inOrden();
        
        System.out.println();
        System.out.println("Orden Alfabetico Z-a");
        ArbolB.inOrdenDesc();
    }
    
}

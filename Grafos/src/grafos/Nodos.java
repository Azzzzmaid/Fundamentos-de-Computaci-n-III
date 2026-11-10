package grafos;
import java.util.ArrayList;        
public class Nodos {
    String nombre;
    ArrayList<Nodos> adyacentes;
    int peso;
    public Nodos (String nombre, int peso){
        this.nombre = nombre;
        this.peso=peso;
        this.adyacentes= new ArrayList<>();
    }
    public void agregarAdyacentes(Nodos nodo, int peso){
        adyacentes.add(nodo);
        nodo.peso=peso;
    }
    public void display(){
        System.out.println(nombre);
        System.out.println("| Adyacentes: ");
        for (Nodos nodo : adyacentes) {
            System.out.println(nodo.nombre + ": "+ nodo.peso + " ");
        }
        System.out.println();
    }
}

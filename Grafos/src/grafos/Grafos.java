package grafos;

class GrafoArrays{
    private String[] vertices;
    private int numVertices;
    private int[][] matrizAdyacencia;
    
    public GrafoArrays(String origen){
        creaTablaVertices(origen);
        matrizAdyacencia = new int[numVertices][numVertices];
    }
    
    private void creaTablaVertices(String origen){
        String[] lineas = origen.split("\\R");
        vertices = new String[lineas.length * 2];
        numVertices=0;
        for (String linea : lineas) {
            String arista = linea.trim();
            if (arista.startsWith("{")) {
                arista=arista.substring(1).trim();
            }
            int etiqueta = arista.indexOf('[');
            if (etiqueta>=0) {
                arista= arista.substring(0,etiqueta);
            }
            String[] extremos = arista.split("--", 2);
            if (extremos.length ==2) {
                agregarVertice(extremos[0].trim());
                agregarVertice(extremos[1].trim());
            }
        }
    }
    
    private void agregarVertice(String vertice){
        for(int i = 0; i<numVertices; i++){
            if (vertices[i].equals(vertice)) {
                return;
            }
        }
        vertices[numVertices]= vertice;
        numVertices++;
    }
    
    public void display(){
        System.out.println("Vertices del grafo:");
        displayVertices();
    }
        
    private void displayVertices(){
        for (int i = 0; i < numVertices; i++) {
            System.out.println(vertices[i]);
        }
    }
    
    private int obtenerIndiceVertice(String vertice){
        for (int i = 0; i < numVertices; i++) {
            if (vertices[i].equals(vertice)) {
                return i;
            }
        }
        return -1;
    }
    
    private void agregarArista (String vertice1, String vertice2, int peso){
        int indice1 = obtenerIndiceVertice(vertice1);
        int indice2= obtenerIndiceVertice(vertice2);
        if (indice1>=0 && indice2>=0) {
            matrizAdyacencia[indice1][indice2] = peso;
            matrizAdyacencia[indice2][indice1] = peso;
        }
    }
    
    //Crear metodo de crear repetir un poco del codigo de creaTablaVertices
    public void crearMatriz(String origen){
        String[] lineas = origen.split("\\R");
        int peso=0;
        for (String linea : lineas) {
            peso=0;
            String arista = linea.trim();
            if (arista.startsWith("graph") || arista.isEmpty()) {continue; }
            if (arista.startsWith("{")) {
                arista=arista.substring(1).trim();
            }
            int primeracomilla = arista.indexOf("\"");
            int segundacomilla = arista.indexOf("\"", primeracomilla+1);
            if (primeracomilla>=0 && segundacomilla>primeracomilla) {
                String valorPeso = arista.substring(primeracomilla+1, segundacomilla);
                peso = Integer.parseInt(valorPeso);
            int etiqueta = arista.indexOf('[');
            if (etiqueta>=0) {
                arista= arista.substring(0,etiqueta);
            }
            
            
            }
            String[] extremos = arista.split("--", 2);
            if (extremos.length ==2) {
                agregarArista(extremos[0].trim(), extremos[1].trim(), peso);
            }
        }
    }
    //crear metodo para desplegar
    
    public void desplegarMatriz(){
        System.out.println("================MATRIZ DE ADYACENCIA=====================");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices[i].substring(0, 3)+" ");
            for (int j = 0; j < numVertices; j++) {
                System.out.printf("%d   ", matrizAdyacencia[i][j]);
            }
            System.out.println();
        }
        System.out.print("   ");
        for (int i = 0; i < numVertices; i++) {
            System.out.print(vertices[i].substring(0, 3)+" ");
            
        }
    }
    //populate matrizAdyacencia(origen)
}

public class Grafos {

    public static void main(String[] args) {
        String texto = cargaArchivo("grafo_salon.txt");
        System.out.println("Contenido del archivo:\n\n"+ texto);
        
        GrafoArrays grafo =new GrafoArrays(texto);
        grafo.display();
        System.out.println();
        grafo.crearMatriz(texto);
        grafo.desplegarMatriz();
    }
    
    public static String cargaArchivo(String ruta){
        String contenido = "";
        try {
            java.io.File archivo = new java.io.File(ruta);
            java.util.Scanner scanner = new java.util.Scanner(archivo);
            while (scanner.hasNextLine()) {
                contenido += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (java.io.FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + ruta);
        }
        return contenido;
    }
    
}

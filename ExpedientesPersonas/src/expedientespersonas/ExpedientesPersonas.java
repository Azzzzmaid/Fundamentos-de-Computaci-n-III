/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package expedientespersonas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


class Personas{
    private String nombre;
    private long expediente;
    private int edad;

    public Personas(String nombre, long expediente, int edad) {
        this.nombre = nombre;
        this.expediente = expediente;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public long getExpediente() {
        return expediente;
    }

    public int getEdad() {
        return edad;
    }
    
    
    
}//Close class Personas

public class ExpedientesPersonas {
    public static ArrayList<Personas> cargarArchivoPersonas(String nombreArchivo){
        ArrayList<Personas> personas = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader (nombreArchivo))){
            String linea;
            br.readLine();
            while ((linea=br.readLine()) != null){
                String[] partes = linea.split(",");
                if (partes.length ==3) {
                    String nombre = partes[0].trim();
                    long expediente = Long.parseLong(partes[1].trim());
                    int edad = Integer.parseInt(partes[2].trim());
                    personas.add(new Personas(nombre, expediente, edad));
                }
            }
        }catch (IOException ex){
            System.out.println("Error al leer el archivo "+ ex.getMessage());
        }
        return personas;
    }//Close cargarArchivoPErsonas
    
    
    public static void main(String[] args) {
        String nombreArchivo= "listado_personas_expediente.csv";
        ArrayList <Personas> personas = cargarArchivoPersonas(nombreArchivo);
        Personas personaEncontrada= personas.get(10);
        if (personaEncontrada != null) {
            System.out.println("Nombre: " + personaEncontrada.getNombre());
            System.out.println("Expediente: "+ personaEncontrada.getExpediente());
            System.out.println("Edad: "+ personaEncontrada.getEdad());
        }
    }
    
}//Close class ExpedientesPersonas

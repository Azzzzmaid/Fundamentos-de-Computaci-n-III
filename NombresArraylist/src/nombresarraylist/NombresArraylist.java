package nombresarraylist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class NombresArraylist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        Path filePath = Paths.get("/home/azmaid/Documentos/FundamentosIII_AhoraSi/NombresArraylist/listado.txt");
        System.out.println(filePath.toAbsolutePath().toString());

        ArrayList<String> namelist= readNamesFromFile(filePath.toString());
        
        //printNames(namelist);
        
        ArrayList<String> repeticiones = countRepeat(namelist);
        
        printNames(repeticiones);
        
        
        
    }

    public static void printNames(ArrayList<String> names){
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static ArrayList<String> readNamesFromFile(String filePath) {
        ArrayList<String> names = new ArrayList<>();
        try {
            Stream<String> lines = Files.lines(Paths.get(filePath));
            for (String line : (Iterable<String>) lines::iterator) {
                names.add(line);
            }
            lines.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
    
    private static ArrayList<String> countRepeat(ArrayList<String> names){
        ArrayList<String> nombresVirtual= new ArrayList<>();
        ArrayList<String> resultado= new ArrayList<>();

        
        for (String name : names) {
            String primerNombre = name.split(" ")[0];
            if (nombresVirtual.contains(primerNombre)) {
                continue;
            }
            
            nombresVirtual.add(primerNombre);
            int contador = 0;
            
            
            for (String name1 : names) {
                String nombreComponente= name1.split(" ")[0];
                if (primerNombre.equals(nombreComponente)) {
                    contador++;
                }
            }
            resultado.add(primerNombre + " "+ contador+ " veces");
        }
        
        return resultado;
    }
    
    
}

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
        Path filePath = Paths.get("/home/azmaid/Documentos/FundamentosIII_AhoraSi/NombresArrayList/listado.txt");
        System.out.println(filePath.toAbsolutePath().toString());

        ArrayList<String> namelist= readNamesFromFile(filePath.toString());
        
        printNames(namelist);
        
        
    }

    public static void printNames(ArrayList filePath){
        
    }

    private static ArrayList<String> readNamesFromFile(String filePath) {
        ArrayList<String> names = new ArrayList<>();
    try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
        for (String line : (Iterable<String>) lines::iterator) {
            names.add(line);
        }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }
    
    
}

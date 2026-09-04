package nombresarraylist;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

class nameCount {
    String name;
    int count;

    public nameCount(String name) {
        this.name = name;
        this.count = 1;
    }

    public void incrementCount() {
        this.count++;
    }

    public String getName() {
        return this.name + " (" + this.count + ")";
    }
}

public class NombresArraylist {

    public static void main(String[] args) {

        Path filePath = Paths.get("/home/azmaid/Documentos/FundamentosIII_AhoraSi/NombresArraylist/listado.txt");
        System.out.println(filePath.toAbsolutePath().toString());

        ArrayList<String> namesList = readNamesFromFile(filePath.toString());

        // ArrayList<String> repeticiones = countRepeat(namesList);
        // printNames(repeticiones);

       int FIRSTNAME = 0,FIRST_LASTNAME = 1, LAST_LASTNAME=2; 
        printNames(namesList);
        ArrayList<String> countedNames = countNames(namesList, FIRSTNAME);
        printNames(countedNames);
        ArrayList<String> countedFirstLastNames = countNames(namesList, FIRST_LASTNAME);
        printNames(countedFirstLastNames);
        System.out.println("Last Last Names count:");
        ArrayList<String> countedLastLastNames = countNames(namesList, LAST_LASTNAME);
        printNames(countedLastLastNames);
    }

    public static void printNames(ArrayList<String> names) {
        for (String name : names) {
            System.out.println(name);
        }
    }

    private static ArrayList<String> readNamesFromFile(String filePath) {
        ArrayList<String> names = new ArrayList<>();
        try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
            for (String line : (Iterable<String>) lines::iterator) {
                if (!line.trim().isEmpty()) {
                    names.add(line.trim());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return names;
    }

    // Método para contar creado por mi
    private static ArrayList<String> countRepeat(ArrayList<String> names) {
        ArrayList<String> nombresVirtual = new ArrayList<>();
        ArrayList<String> resultado = new ArrayList<>();

        for (String name : names) {
            String primerNombre = name.split(" ")[0];
            if (nombresVirtual.contains(primerNombre)) {
                continue;
            }

            nombresVirtual.add(primerNombre);
            int contador = 0;

            for (String name1 : names) {
                String nombreComponente = name1.split(" ")[0];
                if (primerNombre.equals(nombreComponente)) {
                    contador++;
                }
            }
            resultado.add(primerNombre + " " + contador + " veces");
        }

        return resultado;
    }

    // Método creado por mi profesor
    public static ArrayList<String> countNames(ArrayList<String> names, int pos) {
        ArrayList<nameCount> countedNames = new ArrayList<>();
        //int pos = 0; // track the position of the name 
        for (String name : names) {
            String[] splitName = name.split(" ");
            boolean found = false;
            for (nameCount nc : countedNames) {
                if (nc.name.equals(splitName[pos])) {
                    nc.incrementCount();
                    found = true;
                    break;  
                }
            }
            if (!found) {
                countedNames.add(new nameCount(splitName[pos]));
            }
        }
        ArrayList<String> result = new ArrayList<>();
        for (nameCount nc : countedNames) {
            result.add(nc.getName());
        }
        return result;
    }
}
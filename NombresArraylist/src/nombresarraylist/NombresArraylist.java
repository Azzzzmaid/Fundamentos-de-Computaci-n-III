package nombresarraylist;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NombresArraylist {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Path filePath = Paths.get("listado.txt");
        System.out.println(filePath.toAbsolutePath().toString());
    }

}

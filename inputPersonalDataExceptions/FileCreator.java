package inputPersonalDataExceptions;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class FileCreator {
    protected static void createPersonalDataFile(String[] humanDataArray) {
        try {
            String fileName = humanDataArray[0] + ".txt";
            String currentDirectory = System.getProperty("user.dir");
            currentDirectory = currentDirectory + File.separator + "inputPersonalDataExceptions";

            File f = new File(currentDirectory + File.separator + fileName);
        
            if (f.createNewFile()) {
                System.out.println("Файл создан!");
                PrintWriter pw = new PrintWriter(f);
                pw.println(Arrays.toString(humanDataArray));
                pw.close();
            }
            else {
                System.out.println("\nФайл с таким названием уже существует!");
                System.out.println("Люди являются однофамильцами, существующий файл обновлен.");
                PrintWriter pw = new PrintWriter(new FileWriter(f, true));
                pw.append("\n" + Arrays.toString(humanDataArray));
                pw.close();
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }
}


package database;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import models.Employee;

/**
 *
 * @author Asus
 */
public class XFile {
    public static ArrayList<Employee> read(String fileName)
            throws FileNotFoundException,
            IOException,
            ClassNotFoundException {
        FileInputStream fis
                = new FileInputStream(fileName);
        ObjectInputStream ois
                = new ObjectInputStream(fis);
        ArrayList<Employee> list
                = (ArrayList<Employee>) ois.readObject();
        ois.close();
        fis.close();
        return list;
    }

    public static void write(ArrayList<Employee> list,
            String fileName)
            throws FileNotFoundException,
            IOException {
        FileOutputStream fos
                = new FileOutputStream(fileName);
        ObjectOutputStream oos
                = new ObjectOutputStream(fos);
        oos.writeObject(list);
        oos.close();
        fos.close();
    }
    
    public static boolean checkEmptyFile(String path) {
        File file = new File(path);
        if (file.length() == 0) {
            return false;
        }
        
        return true;
    }
}

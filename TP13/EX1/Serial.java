package TP13;

import java.io.*;
import java.util.List;
 
public class Serial {
 
    public static void serial(String path, List<Employer> data) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeObject(data);
        }
    }
 
    @SuppressWarnings("unchecked")
    public static List<Employer> serial(String path) throws Exception {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            return (List<Employer>) ois.readObject();
        }
    }
 
}
 
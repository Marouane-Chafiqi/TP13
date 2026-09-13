package TP13;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
 
public class Histories {
 
    public static void save(String path, List<Chat> history) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(path))) {
            oos.writeInt(history.size());
            for (Chat msg : history) {
                msg.writeExternal(oos);
            }
        }
    }
 
    public static List<Chat> load(String path) throws Exception {
        List<Chat> Histories = new ArrayList<>();
 
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {
            int count = ois.readInt();
            for (int i = 0; i < count; i++) {
                Chat msg = new Chat();
                msg.readExternal(ois);
                Histories .add(msg);
            }
        }
 
        return Histories;
    }
 
}
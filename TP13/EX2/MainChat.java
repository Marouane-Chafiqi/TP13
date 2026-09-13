package TP13;

import java.util.ArrayList;
import java.util.List;
 
public class MainChat {
 
    public static void main(String[] args) throws Exception {
 
        List<Chat> history = new ArrayList<>();
        history.add(new Chat("Marwan", "Salam"));
        history.add(new Chat("Fatima", "Labas hamdoliha"));
 
        Histories.save("chat.ser", history);
 
        List<Chat> loaded = Histories.load("chat.ser");
 
        for (Chat msg : loaded) {
            System.out.println("[" + msg.getLength() + " chars] " + msg);
        }
    }
 
}
 